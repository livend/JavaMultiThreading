package mytest_0;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Class.forName() and getClass().getClassLoader().loadClass();
 * @author liven.
 * @date 2016/7/23 10:19.
 */
public class ClassForNameTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassForNameTest1 test = new ClassForNameTest1();
        //Child c = new Child();    //Father的静态代码块>Child的静态代码块>Father的非静态代码块>Father的构建函数>Child的非静态代码块>Child的构建函数
        //Child c2 = new Child();    //Father的非静态代码块>Father的构建函数>Child的非静态代码块>Child的构建函数
        //Class.forName("mytest_0.Child");       //Father的静态代码块>Child的静态代码块    ---静态代码块只执行一次
        test.getClass().getClassLoader().loadClass("mytest_0.Child");      //不执行任何方法   不进行Child.class的初始化
    }
}

class Father{
     static{  //静态代码块
         System.out.println("Father的静态代码块！");
     }

    {      //非静态代码块
        System.out.println("Father的非静态代码块!");
    }

    public Father(){
        System.out.println("Father的构建函数");
    }
}

class Child extends Father{
    static{  //静态代码块
        System.out.println("Child的静态代码块！");
    }

    {      //非静态代码块
        System.out.println("Child的非静态代码块!");
    }

    public Child(){
        System.out.println("Child的构建函数");
    }
}


/**
 * @author liven
 * @date 2016/7/23 10:36
 * 参考：http://blog.csdn.net/yanwushu/article/details/7574713
 */