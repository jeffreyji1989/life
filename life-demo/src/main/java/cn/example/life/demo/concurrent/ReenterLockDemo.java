package cn.example.life.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 季先生 on 2018/3/22 18:04.
 */
public class ReenterLockDemo implements Runnable {
    private static  final ReentrantLock lock = new ReentrantLock();
    static int j = 0;
    @Override
    public void run() {
       for (int i=0; i<100000; i++){
           lock.lock();
           lock.lock();
           j++;
           lock.unlock();
           lock.unlock();
       }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockDemo reenterLockDemo = new ReenterLockDemo();
        Thread t1 = new Thread(reenterLockDemo);
        Thread t2 = new Thread(reenterLockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(j);
    }
}
