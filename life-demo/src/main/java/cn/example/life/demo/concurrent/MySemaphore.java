package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Junhuiji on 2018/3/1 14:27.
 * 信号量测试
 * eg： 某公测有2个坑位，10个人上厕所
 */
@Slf4j
public class MySemaphore implements Runnable {
    // 顾客编号
    private int id;
    // 信号量
    private Semaphore position;

    public MySemaphore(int id, Semaphore semaphore) {
        this.id = id;
        this.position = semaphore;
    }

    @Override
    public void run() {
        if (position.availablePermits() > 0) {
            log.info("顾客【{}】，进入厕所，有空位！", this.id);
            try {
                position.acquire();
                System.out.println("顾客[" + this.id + "]获得坑位");
                TimeUnit.SECONDS.sleep(3l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("顾客[" + this.id + "]使用完毕");
            position.release();
        } else {
            log.info("顾客【{}】，进入厕所，没有空位，需要排队", this.id);
        }
    }

    public static void main(String[] args) {
        // 模拟20个人
        int num = 20;
        // 模拟3个坑位
        Semaphore position = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < num; i++) {
            executorService.submit(new MySemaphore(i + 1, position));
        }
        executorService.shutdown();
        position.acquireUninterruptibly(3);
        System.out.println("使用完毕，需要清扫了");
        position.release(3);
    }
}
