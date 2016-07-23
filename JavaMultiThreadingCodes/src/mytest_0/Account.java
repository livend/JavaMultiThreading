package mytest_0;

/**
 * 模拟银行账户
 * @author liven.
 * @date 2016/7/21 21:56.
 */
public class Account {
    private float total;         //总存款
    private BusyFlag flag = new BusyFlag();

    public boolean deduct(float t){      //模拟取款
        boolean succeed = false;
        flag.getBusyFlag();
        if(t <= total){
            total -= t;
            succeed = true;
        }
        flag.freeBusyFlag();
        return succeed;
    }
}

