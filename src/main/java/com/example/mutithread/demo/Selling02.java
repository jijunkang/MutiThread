package com.example.mutithread.demo;

import lombok.SneakyThrows;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author layman
 * @date 2021/3/1
 */
public class Selling02 {
    public static void main(String[] args) {
        //创建线程任务对象
        TicketWindow02 tt = new TicketWindow02();
        //创建三个窗口
        Thread windowA = new Thread(tt,"窗口A");
        Thread windowB = new Thread(tt,"窗口C");
        Thread windowC = new Thread(tt,"窗口C");

        //同时卖票
        windowA.start();
        windowB.start();
        windowC.start();
    }
}

class TicketWindow02 implements Runnable {
    private int ticket = 50;
    private Long sleepTime = 100L;
    private Lock lock = new ReentrantLock();
    /**
     * 卖票
     */
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            lock.lock(); //加锁
            if (ticket > 0) {
                //模拟出票操作
                Thread.sleep(sleepTime);

                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖第 " + ticket + " 张票。");
                ticket--;
            }
            lock.unlock(); //释放锁
        }
    }
}
