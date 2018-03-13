package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Junhuiji on 2018/3/1 15:37.
 * eg:相亲节目 非诚勿扰 1个男的N个女的
 * 每个女的都要跟男的聊一下
 */
@Slf4j
public class MyReentrantLock {
    public static void main(String[] args) {
        // 女人的数量
        int num = 20;
        ExecutorService girls = Executors.newCachedThreadPool();
        final Boy boy = new Boy("GuanxiChen");
        for (int i = 0; i < num; i++) {
            final int count = i;
            girls.submit(new Runnable() {
//                @Override
                public void run() {
                    boy.talk("女孩" + count);
                }
            });
        }
        //女孩交谈完毕
        girls.shutdown();
    }
}

@Slf4j
class Boy {
    // 男人是 稀有资源
    private String name;
    private ReentrantLock lock = new ReentrantLock();

    public Boy() {
    }

    public Boy(String name) {
        this.name = name;
    }

    public void talk(String girlName) {
        try {
            lock.lock();
            log.info("{}获得跟{}交谈的机会！", girlName, this.name);
            //交谈5秒钟
            TimeUnit.SECONDS.sleep(5L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("{}跟{}交谈结束！", girlName, this.name);
            lock.unlock();
        }
    }
}
