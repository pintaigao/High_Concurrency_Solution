package com.rc;

/**
 * @ClassName SynchronizedClassClass5
 * @Description 类锁的第一种形式，class 形式
 * @Author liux
 * @Date 19-3-28 下午2:04
 * @Version 1.0
 */
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();


    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();

        //下面代码是为了保证线程t1,t2执行完毕
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }


    @Override
    public void run() {
        method();
    }

    private void method() {
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
