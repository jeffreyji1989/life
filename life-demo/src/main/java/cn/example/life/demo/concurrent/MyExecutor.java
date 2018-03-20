package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Junhuiji on 2018/3/1 14:05.
 * 线程池测试
 */
@Slf4j
public class MyExecutor extends Thread {

    private String name;

    public MyExecutor(){}

    public MyExecutor(String name){
        this.name = name;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        log.info("线程名字为：{}，。。。。。",current.getName());
        try {
            TimeUnit.SECONDS.sleep(3l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}线程执行结束！",name);
    }

    public static void main(String[] args) {
        // 固定线程数
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 无限制的线程数
//        executorService = Executors.newCachedThreadPool();
        // 生成单个线程
//        executorService = Executors.newSingleThreadExecutor();

        for (int i=0; i<10; i++){
            executorService.submit(new MyExecutor("name" + i));
        }
        executorService.shutdown();
        log.info("整个执行结束");

        // 自定义配置线程池
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor()
    }
}
