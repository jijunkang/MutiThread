package com.example.mutithread.demo;

import lombok.SneakyThrows;

/**
 * @author layman
 */
public class Selling01 {
    public static void main(String[] args) {
        //创建线程任务对象
        TicketWindow tt = new TicketWindow();
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

class TicketWindow implements Runnable {
    private int ticket = 50;
    private Long sleepTime = 100L;

    /**
     * 卖票
     */
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                //模拟出票操作
                Thread.sleep(sleepTime);
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖第 " + ticket + " 张票。");
				ticket--;
            }
        }
    }
}
