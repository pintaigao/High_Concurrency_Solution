package com.rc;

/**
 * @ClassName SynchronizedYesAndNo6
 * @Description 同时访问一个类的不同同步方法
 * @Author liux
 * @Date 19-3-28 下午2:30
 * @Version 1.0
 */
public class SynchronizedYesAndYes7 implements Runnable {

    static SynchronizedYesAndYes7 instance = new SynchronizedYesAndYes7();

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
        if (Thread.currentThread().getName().equals("Thread-0")) {
//            System.out.println("---m1---");
            m1();
        } else {
//            System.out.println("---m2---");
            m2();
        }

    }

    private synchronized void m1() {
        System.out.println("加锁方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    private synchronized void m2() {
        System.out.println("加锁方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
