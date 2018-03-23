package cn.example.life.demo.concurrent;

/**
 * Created by 季先生 on 2018/3/22 17:25.
 */
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name){
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in "+getName());
                LockSupport.park();
                
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(10000);
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
        System.out.println("===============");
    }
}
