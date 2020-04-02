package com.rc;

/**
 * @ClassName SynchronizedOtherMethod11
 * @Description 可重入粒度测试：调用类内另外的方法
 * @Author liux
 * @Date 19-3-28 下午3:51
 * @Version 1.0
 */
public class SynchronizedOtherMethod11 {

    public static void main(String[] args) {
        SynchronizedOtherMethod11 synchronizedOtherMethod11 = new SynchronizedOtherMethod11();
        synchronizedOtherMethod11.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("这是method2");
    }
}
