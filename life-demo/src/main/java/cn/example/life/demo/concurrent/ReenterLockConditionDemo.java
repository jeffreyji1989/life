package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 季先生 on 2018/3/22 18:16.
 */
@Slf4j
public class ReenterLockConditionDemo implements Runnable{
    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLockConditionDemo tl=new ReenterLockConditionDemo();
        Thread t1=new Thread(tl);
//        t1.isDaemon();
        t1.setName("6666");
        t1.start();
        log.info("t1 start ...");
        Thread.sleep(1000);
        //通知线程t1继续执行
        lock.lock();
        log.info("条件未解除");
        condition.signal();
        log.info("条件解除");
        lock.unlock();
    }
}
