package mytest_0;

/**
 * @author liven.
 * @date 2016/7/23 14:39.
 */
public class BusyFlag5 {
    protected  Thread busyFlag = null;
    protected int busyCount = 0;

    public void getBusyFlag() throws InterruptedException {
        while (!tryGetBusyFlag()) {
            Thread.sleep(100);
        }
    }

    public synchronized boolean tryGetBusyFlag(){
        if(busyFlag == null){
             busyFlag = Thread.currentThread();
             busyCount = 1 ;
             return  true;
        }
        if(busyFlag == Thread.currentThread()){
             busyCount++;
             return  true;
        }
        return false;
    }

    public synchronized void freeBusyFlag(){
        if(getBusyFlagOwner()==Thread.currentThread()){
              busyCount--;
              if(busyCount==0){
                  busyFlag = null;
              }
        }
    }

    public synchronized Thread getBusyFlagOwner(){
        return busyFlag;
    }
}

/**
 * @author liven
 * @date 2016/7/23 15:30
 * wait()方法：Object类中的方法，必须在同步方法或者同步代码块中被调用
 * notify()方法：Object类中的方法，必须在同步方法或者同步代码块中被调用
 */
