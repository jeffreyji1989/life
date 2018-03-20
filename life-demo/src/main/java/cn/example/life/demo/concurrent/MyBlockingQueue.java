package cn.example.life.demo.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Junhuiji on 2018/3/1 16:53.
 */
@Slf4j
public class MyBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        // 声明一个队列
        BlockingQueue<String> queue = new LinkedBlockingDeque(5);
        //定义一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //启动n个生产者
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Producer p4 = new Producer(queue);
        Producer p5 = new Producer(queue);

        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(p3);
        executorService.submit(p4);
        executorService.submit(p5);
        //启动消费者
        Consumer c = new Consumer(queue);
        executorService.submit(c);
        // 执行10s
        TimeUnit.SECONDS.sleep(10L);

        //关闭生产者
        p1.stop();
        p2.stop();
        p3.stop();
        p4.stop();
        p5.stop();
        //30s 后退出程序
        TimeUnit.SECONDS.sleep(30L);
        executorService.shutdown();

    }
}

//生产者
@Slf4j
class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue queue;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("启动生产者线程。。。。。。");
        String data = null;
        try {
            while (isRunning) {
                data = "data" + count.getAndIncrement();
                log.info("将数据{}放入队列中", data);
                TimeUnit.SECONDS.sleep(3L);
                if (!queue.offer(data)) {
                    log.error("注意数据{}放入队列失败!", data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            log.info("退出生产者线程");
        }

    }

    public void stop() {
        isRunning = false;
    }
}

@Slf4j
class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("启动消费者线程。。。。。。");
        boolean isRunning = true;
        try {
            log.info("消费者开始从队列中取数据。。。");
            while (isRunning) {
                String data = queue.poll(10,TimeUnit.SECONDS);
                if (!StringUtils.isEmpty(data)){
                    log.info("从队列中取出数据{}", data);
                    TimeUnit.SECONDS.sleep(1);
                    log.info("数据{}消费完成！", data);
                } else {
//                    log.info("队列中还没有数据");
                    isRunning = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("退出消费者线程!");
        }
    }
}
