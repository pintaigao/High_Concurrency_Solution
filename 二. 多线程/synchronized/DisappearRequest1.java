package com.rc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName DisappearRequest1
 * @Description 消失的请求
 * @Author liux
 * @Date 19-3-28 上午11:23
 * @Version 1.0
 */
public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        //下面两行代码是为了保证线程t1,t2执行完毕
        t1.join();
        t2.join();

        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
