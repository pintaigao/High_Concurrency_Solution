package com.rc;

/**
 * @ClassName SynchronizedSuperClass12
 * @Description 可重入粒度测试，调用父类方法
 * @Author liux
 * @Date 19-3-28 下午3:55
 * @Version 1.0
 */
public class SynchronizedSuperClass12 {



    public synchronized void doSomething() {
        System.out.println("这是父类方法");
    }
}

class TestClass extends SynchronizedSuperClass12 {

    @Override
    public synchronized void doSomething() {
        System.out.println("这是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();

    }
}