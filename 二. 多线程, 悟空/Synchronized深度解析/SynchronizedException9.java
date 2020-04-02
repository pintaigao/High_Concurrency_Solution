package com.rc;

/**
 * @ClassName SynchronizedException9
 * @Description 跑出异常后是否会释放锁
 * @Author liux
 * @Date 19-3-28 下午2:51
 * @Version 1.0
 */
public class SynchronizedException9 implements Runnable {

    static SynchronizedException9 instance = new SynchronizedException9();

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
        System.out.println("加锁方法1。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("故意中断，释放synchronized锁");
//        System.out.println("加锁方法1 " + Thread.currentThread().getName() + "运行结束");
    }

    private synchronized void m2() {
        System.out.println("加锁方法2。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("加锁方法2 " + Thread.currentThread().getName() + "运行结束");
    }
}
