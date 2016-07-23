package mytest_0;

/**
 * @author liven.
 * @date 2016/7/22 16:07.
 */
public class BusyFlag2 {
    protected  Thread busyFlag = null;

    public void getBusyFlag(){
        while(true){
            synchronized (this){
                if(busyFlag==null){
                    busyFlag = Thread.currentThread();
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void freeBusyFlag(){
            if(busyFlag == Thread.currentThread())
                busyFlag = null;
    }
}


/**
 * 静态代码块（可以指定锁的对象）
 * @author liven
 * @date 2016/7/22 17:01
 */