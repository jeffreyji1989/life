package cn.example.life.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 季先生 on 2018/3/22 18:22.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable{
    final Semaphore semp = new Semaphore(5);
    @Override
    public void run() {
        try {
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+":done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semp.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo=new SemapDemo();
        for(int i=0;i<20;i++){
            exec.submit(demo);
        }
        exec.shutdown();
    }
}
