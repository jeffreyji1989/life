package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 季先生 on 2018/3/22 16:23.
 */

@Slf4j
public class CountDownLatchDemo implements Runnable{
    private static final int COUNT = 10;
    static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(COUNT);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(COUNT);
        for (int i=0; i<COUNT;i++){
            log.info(exec.toString());
            exec.execute(demo);
        }
        COUNT_DOWN_LATCH.await();
        log.info("{}个线程都已经执行完毕!",COUNT);
        exec.shutdown();
        
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(COUNT));
            log.info("随机迷糊10s钟以内");
            COUNT_DOWN_LATCH.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
