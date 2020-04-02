package com.rc;

/**
 * 这个故事告诉我们，当有两个instance的时候，而且是自己写的方法，能通过static synchronized void method()静态方法来锁住方法
 */
public class SynchronizedClassStatic4 implements Runnable {

    /* 类锁 */
    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

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

    private static synchronized void method() {
        System.out.println("我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
