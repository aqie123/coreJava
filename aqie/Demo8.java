package aqie;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Collection;

public class Demo8 {
    public static void main(String[] args) {
        Test6 test6 = new Test6();
        // test6.method();
        // test6.method2();
        test6.method3();
    }
}

class Test6{
    // 定义容器收集兴趣爱好
    void method(){
        // 创建集合对象  多态 只能访问父类方法
        Collection c = new ArrayList();
        //添加元素
        c.add(12); c.add("12");c.add("上海");
        Collection c2 = new ArrayList();
        c2.add("北京");c2.add("上海");c2.add("广州");

        // c.addAll(c2);
        System.out.println(c2);
        c2.removeAll(c);   // 删除c2 中与c 的交集
        System.out.println(c2.remove("北京"));
        System.out.println(c2);
        // c.clear(); // 清除集合元素
        System.out.println(c);
    }

    void method2(){
        // 接口关系下的多态
        Collection c = new ArrayList();
        // 添加元素
        c.add(new Person(1,"jim"));
        c.add(new Person(2,"tom"));
        c.add(new Person(3,"jerry"));

        // 重写 toString方法
        System.out.println(c);
        // 遍历集合 用equals方法比较  重写 Person中equals
        System.out.println("此人是否存在 "+c.contains(new Person(2,"tom")));
    }

    void method3(){
        Collection c = new ArrayList();
        c.add(1);
        c.add(2);
        c.add(3);

        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(2);
        System.out.println(c.containsAll(c1));

        c1.clear();
        c1.add(null);
        System.out.println(c1.isEmpty());  // false
        System.out.println(c.size());
    }
}


