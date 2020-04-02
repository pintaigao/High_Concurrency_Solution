package com.rc;

/**
 * @ClassName SynchronizedYesAndNo6
 * @Description 同时访问一个类的不同同步方法
 * @Author liux
 * @Date 19-3-28 下午2:30
 * @Version 1.0
 */
public class Test {
    int num = 0;
    Object mutex = new Object();
    static Test t = new Test();
    static Test t2 = new Test();

    private void add() {
        synchronized (mutex) {
            this.num++;
        }
    }

    public static void main(String[] args) {
        t.add();
        t2.add();
        System.out.println(t.num);
        System.out.println(t2.num);
        System.out.println("finished");
    }
}
