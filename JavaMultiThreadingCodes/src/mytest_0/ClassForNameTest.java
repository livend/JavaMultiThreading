package mytest_0;

/**
 * @author liven.
 * @date 2016/7/23 9:56.
 */
public class ClassForNameTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("java.lang.Thread");    //会进行实例化
        System.out.println(c.getName());
        System.out.println(c.getClass());
        System.out.println(((Thread)(c.newInstance())).toString());

        ClassForNameTest test = new ClassForNameTest();
        Class c2 = test.getClass().getClassLoader().loadClass("java.lang.Thread");    //不会进行实例化
        System.out.println(c2.getName());
        System.out.println(c2.getClass());
        System.out.println(c2.newInstance().toString());
    }
}
