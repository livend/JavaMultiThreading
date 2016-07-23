package mytest_0;

/**
 * @author liven.
 * @date 2016/7/22 16:07.
 */
public class BusyFlag1_deadlock {
    protected  Thread busyFlag = null;

    public synchronized void getBusyFlag(){
        while(tryGetBusyFlag()  == false){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean tryGetBusyFlag(){
        if(busyFlag==null){
              busyFlag = Thread.currentThread();
              return  true;
        }
        return  false;
    }

    public synchronized void freeBusyFlag(){
            if(busyFlag == Thread.currentThread())
                busyFlag = null;
    }
}


/**
 * 会出现死锁。synchronized的作用域太大 --- 可以采用静态代码块 synchronized(this){}
 * @author liven
 * @date 2016/7/22 17:01
 */