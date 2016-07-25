package mytest_0;

/**
 * 共享内存的实现
 * @author liven.
 * @date 2016/7/25 15:50.
 */
public class ShareMemory extends BusyFlag5 {
    byte[] memory;

    public ShareMemory(int size){
        memory = new byte[size];
    }

    public synchronized byte[] attach() throws InterruptedException {
        getBusyFlag();
        return memory;
    }

    public synchronized  void detach(){
          freeBusyFlag();
    }
}
