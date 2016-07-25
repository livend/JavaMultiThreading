package mytest_0;

import java.util.Vector;

/**
 * 模拟消息列队
 * @author liven.
 * @date 2016/7/25 15:33.
 */
public class MsgQueue {
    Vector vector = new Vector();

    public synchronized void send(Object obj){
        vector.add(obj);
    }

    public synchronized  Object recy(){
         if(vector.size()==0){
             return null;
         }
         Object obj = vector.firstElement();
         vector.remove(0);
         return  obj;
    }
}
