package mytest_0;

/**
 * @author liven.
 * @date 2016/7/22 16:07.
 */
public class BusyFlag1 {
    protected  Thread busyFlag = null;

    public void getBusyFlag(){
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
