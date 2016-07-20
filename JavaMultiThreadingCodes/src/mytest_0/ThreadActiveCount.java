package mytest_0;

/**
 * @author liwen.
 * @date 2016/7/20 18:05.
 */
public class ThreadActiveCount {

    public static void main(String[] args) {
         MyThread my = new MyThread();
         MyThread my2 = new MyThread();
         Thread t1 = new Thread(my);
         Thread t2 = new Thread(my);
         Thread t3 = new Thread(my);
         Thread t4 = new Thread(my2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

         Thread[] threads = new Thread[Thread.activeCount()];        //默认会有两个线程，一个main线程，一个monitor线程
         int i = Thread.enumerate(threads);
         System.out.println(i);

         for(Thread t:threads){
             System.out.println("hello:"+t.getName());
         }

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

/**
 * Thread.activeCount()计算值和线程的生命周期不一样，当线程一旦创建即使还未调用start()，会出现在activeCount中(from java-thread book) ---- 这是错误的
 * 线程只有调用了start()方法，才会出现在activeCount中；只会显示该程序启动所用到的线程，不会显示虚拟机中的其他线程（如：垃圾回收线程）
 * 一个线程实例只能启动一次
 */
