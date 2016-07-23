package mytest_0;

/**
 * @author liven.
 * @date 2016/7/22 16:23.
 */
public class ThreadTest implements Runnable {
    private static  int seq;
    public synchronized int  getSeq(){
        return seq++;
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadTest(),"t1");
        Thread t2 = new Thread(new ThreadTest(),"t2");
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        for(int i = 0;i<10000;i++){
            System.out.print(getSeq()+",");
        }
    }
}

/**
 * 线程t1和t2构建的时候，是new出的两个不同对象，一个对象都有一把锁，无法保证getSeq()方法的原子性
 */