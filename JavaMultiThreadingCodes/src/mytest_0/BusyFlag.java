package mytest_0;

import java.util.concurrent.TimeUnit;

/**
 * BusyFlag类用来设计代替同步方法
 * @author liven.
 * @date 2016/7/21 21:26.
 */
public class BusyFlag {
    protected  Thread busyflag = null;

    public void getBusyFlag(){
        while(busyflag!=Thread.currentThread()){
           if(busyflag == null){
               busyflag = Thread.currentThread();
           }
            try {
                Thread.sleep(100);
                //TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void freeBusyFlag(){
        if(busyflag == Thread.currentThread()){
             busyflag = null;
        }
    }
}

/**
 * 为什么我觉得这个类写的很奇怪呢？一定会出问题的啊 ----如何代替同步方法？
 * 解释：多线程中只保持一个BusyFlag的实例
 **/

/**
 * 1.除了long和double类型外，java中所有的赋值操作都是原子性的   ---java规范    long和double类型会出现问题
 */
