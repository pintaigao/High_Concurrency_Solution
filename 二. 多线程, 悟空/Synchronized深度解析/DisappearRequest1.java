/**
 * 1. 这个故事告诉我们，如果不加锁，i不会到200000的
 */
public class DisappearRequest1 implements Runnable {

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        // 下面两行代码是为了保证线程t1,t2执行完毕，然后执行System out print
        t1.join();
        t2.join();

        System.out.println(i);
    }
}
