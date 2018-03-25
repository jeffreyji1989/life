package cn.example.life.service.aop.limit;

/**
 * Created by Junhuiji on 2018/2/27 18:01.
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
@Slf4j
public class MethodRequestLimitAspect {
    private static ConcurrentHashMap<String,Long> limitMap = new ConcurrentHashMap<>();

    @Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(limit)")
    public void requestLimit(final JoinPoint joinPoint, RequestLimit limit) throws Exception {
        try {

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            if (request == null) {
                throw new Exception("方法中缺失HttpServletRequest参数");
            }

            String ip = request.getLocalAddr();
            String url = request.getRequestURL().toString();
            final String key = "req_limit_".concat(url).concat(ip);
            log.info("req_limit_key:{}/nvalue:{}",key,limitMap.get(key));
            if (limitMap.get(key) == null || limitMap.get(key) == 0) {
                limitMap.put(key, 1L);
            } else {
                limitMap.put(key, limitMap.get(key) + 1);
            }
            long count = limitMap.get(key);
            if (count > 0) {
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {    //创建一个新的计时器任务。
                    @Override
                    public void run() {
                        limitMap.remove(key);
                    }
                };
                timer.schedule(task, limit.time());
                //安排在指定延迟后执行指定的任务。task : 所要安排的任务。10000 : 执行任务前的延迟时间，单位是毫秒。
            }
            if (count > limit.count()) {
                log.error("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("发生异常: ", e);
        }
    }
}  
