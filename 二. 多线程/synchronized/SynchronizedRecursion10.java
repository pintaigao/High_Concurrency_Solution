package com.rc;

/**
 * @ClassName SynchronizedRecursion10
 * @Description 可重入粒度测试，递归调用本方法
 * @Author liux
 * @Date 19-3-28 下午3:45
 * @Version 1.0
 */
public class SynchronizedRecursion10 {

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
        synchronizedRecursion10.method1();
    }


    int a = 0;
    private synchronized void method1() {
        System.out.println("这是method1,a = " + a);
        if (a == 0) {
            a++;
            method1();
        }
    }
}
