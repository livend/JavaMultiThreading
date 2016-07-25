package mytest_0;

/**
 * @author liven.
 * @date 2016/7/23 15:39.
 */
public class SynchronizedTest {

    public synchronized void hello(){
        System.out.println("hello ");
        end();     //不会造成线程的死锁，同一个对象
    }

    public synchronized void end(){
        System.out.println("java! ");
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                test.hello();
            }
        });
        t.start();
    }
}
