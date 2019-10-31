package com.rc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SynchronizedToLock13
 * @Description 加锁和释放锁的时机展示
 * @Author liux
 * @Date 19-3-28 下午4:29
 * @Version 1.0
 */
public class SynchronizedToLock13 {
    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("这是synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("这是lock形式的锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock13 synchronizedToLock13 = new SynchronizedToLock13();
        synchronizedToLock13.method1();
        synchronizedToLock13.method2();
    }
}
