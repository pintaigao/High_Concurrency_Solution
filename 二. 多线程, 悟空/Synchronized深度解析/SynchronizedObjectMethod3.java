/**
 * 这个故事告诉我们，两个instance（同一个class），方法锁形式，锁方法
 */
public class SynchronizedObjectMethod3 implements Runnable {

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        // 下面代码是为了保证线程t1,t2执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    @Override
    public synchronized void run() {
        System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
    }
}
