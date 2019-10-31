package com.rc;

/**
 * @ClassName SynchronizedObjectCodeBlock2
 * @Description 对象锁示例1, 代码块形式
 * @Author liux
 * @Date 19-3-28 上午11:51
 * @Version 1.0
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        //下面代码是为了保证线程t1,t2执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    //串并行都有
    /*Object lock1 = new Object();
    Object lock2 = new Object();
    public void run() {
        synchronized (lock1) {
            System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
        }

        synchronized (lock2) {
            System.out.println("lock2部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2部分: " + Thread.currentThread().getName() + "运行结束");
        }
    }*/

    //完全串行
    /*Object lock1 = new Object();
    Object lock2 = new Object();
    public void run() {
        synchronized (lock1) {
            System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
        }

        synchronized (lock1) {
            System.out.println("lock2部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2部分: " + Thread.currentThread().getName() + "运行结束");
        }
    }*/
}
