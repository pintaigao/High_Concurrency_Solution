/**
 * 2. 这个故事告诉我们，对象锁,手动锁定对象
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        // 下面代码是为了保证线程t1,t2执行完毕
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    /* 主体部分 */
    /* 1.锁自己 */
    @Override
    public void run() {
        // 保护this
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    /* 2. 锁对象和串并行都有，自定义锁对象 */
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void run() {
        // 因为run是按顺序执行的，所有的Thread都先到这里，谁先拿到锁谁先执行里面的代码，然后其他的等着，等拿到锁的Thread执行完后，这个Thread往下执行，其他的Thread继续在这一行抢锁
        synchronized (lock1) {
            System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
        }

        synchronized (lock2) {
            System.out.println("lock2部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2部分: " + Thread.currentThread().getName() + "运行结束");
        }
    }

    /* 3. 锁对象和完全串行 */
    Object lock1 = new Object();

    public void run() {
        synchronized (lock1) {
            System.out.println("lock1部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1部分: " + Thread.currentThread().getName() + "运行结束");
        }

        synchronized (lock1) {
            System.out.println("lock2部分: 我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2部分: " + Thread.currentThread().getName() + "运行结束");
        }
    }
}
