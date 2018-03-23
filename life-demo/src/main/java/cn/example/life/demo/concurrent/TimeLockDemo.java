package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 季先生 on 2018/3/22 18:47.
 */
@Slf4j
public class TimeLockDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(6, TimeUnit.SECONDS)) {
                log.info("线程{}开始执行",Thread.currentThread().getName());
                Thread.sleep(5000);
                log.info("===========");
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLockDemo tl = new TimeLockDemo();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}
