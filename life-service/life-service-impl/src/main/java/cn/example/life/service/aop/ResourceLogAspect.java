package cn.example.life.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * author:jeffrey(jeffreyji@aliyun.com)
 * date: 2018/3/25 20:04
 * version:1.0.0
 * description:
 */
@Aspect
@Component
@Slf4j
public class ResourceLogAspect {

    @Value("${server.port}")
    private int serverPort;

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * cn.example.life.service..*Resource.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void requestLog(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("server.port:{}", serverPort);
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("返回的结果:{} ", ret);
        log.info("总共用时:{} ", (System.currentTimeMillis() - startTime.get()) / 1000.0 + "s");
    }
}
