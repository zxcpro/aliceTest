package com.guoyi;

import java.util.concurrent.CountDownLatch;

public class Foo {
    //1114. 按序打印
    // https://leetcode.cn/problems/print-in-order/solutions/2301545/ban-yun-javage-chong-xie-fa-by-dbj98-x48-5hod/

    private final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private final CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


    // synchronized 写法
    private boolean oneDone;
    private boolean twoDone;

    public Foo() {
        oneDone = false;
        twoDone = false;
    }

    public synchronized void first1(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second1(Runnable printSecond) throws InterruptedException {
        while(!oneDone){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        twoDone = true;
        notifyAll();
    }

    public synchronized void third1(Runnable printThird) throws InterruptedException {
        while(!twoDone){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }




}
