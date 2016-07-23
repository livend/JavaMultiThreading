package mytest_0;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 模拟网络套接字
 * @author liven.
 * @date 2016/7/20 22:29.
 */
public class AsyncReadSocket extends Thread {
    private Socket s;
    private volatile StringBuffer result;

    public AsyncReadSocket(Socket s){
        this.s = s;
        this.result = new StringBuffer();
    }

    @Override
    public void run() {
        DataInputStream is = null;
        try {
            is = new DataInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                char c = is.readChar();
                appendResult(c);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 将新数据放入缓冲区
     * @author liven
     * @date 2016/7/21 20:41
     */
    public synchronized  void  appendResult(char c){
        result.append(c);
    }

    public synchronized String getResult(){
        String ret = result.toString();
        result = new StringBuffer();     //读取一段字符后，置空缓冲区
        return ret;
    }

}

/**
 * 锁是基于对象的，不是基于方法
 */
