package mytest_0;

import java.util.Currency;
import java.util.Objects;

/**
 * 模拟循环列表
 * @author liven.
 * @date 2016/7/25 16:32.
 */
public class CircleList {
    private CircleListNode current;

    public synchronized void insert(Object o){
        CircleListNode tn = new CircleListNode();
        tn.o = o;
        if(current == null){
            tn.next = tn.prev = null;
            current = tn;
        }else{
            tn.next = current;
            tn.prev = current.prev;
            current.prev.next = tn;
            current.prev = tn;
        }
    }

    public synchronized void delete(Object o){
         CircleListNode p = find(o);
         CircleListNode next = p.next;
         CircleListNode prev = p.prev;
         if(p == p.next){   //列表中的最后一个对象(只有一个对象)
             current = null;
             return;
         }

        prev.next = next;
        next.prev = prev;

        if(current == p){
             current = next;
        }
    }

    private CircleListNode find(Object o){
        CircleListNode p = current;
        if(p == null){
            throw new IllegalArgumentException("异常");
        }

        do{
            if(p.o == o){
                 return p;
            }
            p = p.next;
        }while(p!=current);
        throw new IllegalArgumentException("不存在");
    }

    public synchronized  Object locate(Object o){
        CircleListNode p = current;
        do {
            if(p.o.equals(o)){
               return p.o;
            }
        }while (p != current);
        throw new IllegalArgumentException();
    }

    public synchronized Object getNext(){
        if(current == null){
            return  null;
        }
        current = current.next;
        return  current.o;
    }
}

class CircleListNode{
    Object o;
    CircleListNode next;
    CircleListNode prev;
}
