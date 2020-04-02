package com.rc;

/**
 * 这个故事告诉我们，当还是有两个instance的时候，能通过synchronized (SynchronizedClassClass5.class)  来锁住class
 */
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();

        // 下面代码是为了保证线程t1,t2执行完毕
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        method();
    }

    private void method() {
        /* 运用的都是同一个实例class */
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
}
