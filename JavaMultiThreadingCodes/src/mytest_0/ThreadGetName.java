package mytest_0;

/**
 * @author liwen.
 * @date 2016/7/20 17:30.
 */
public class ThreadGetName extends  Thread{

    TestThread testThread;

    public ThreadGetName(TestThread test) {
        super("mytest222");
        this.testThread=test;
    }

    public static void main(String[] args) {
        TestThread test = new TestThread();
        test.setName("mytest111");
        test.start();
        new ThreadGetName(test).start();
    }

    @Override
    public void run() {
        System.out.println("hello javaThread");
    }

}

class TestThread extends Thread{

    public String getResult(){
        String name = Thread.currentThread().getName();
        if(name.startsWith("mytest")){
            String result = name + "---hello";
            System.out.println(result);
            return result;
        } else{
            return "";
        }
    }

    @Override
    public void run() {
        getResult();
    }
}
