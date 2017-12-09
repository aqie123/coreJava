package aqie;

import java.util.HashSet;
import java.util.LinkedList;

// Demo4 Person 类
public class Demo12 {
    public static void main(String[] args) {
        Test10 t = new Test10();
        // t.method();
        t.method2();
    }
}

class Test10{
    void method(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("boolean");
        linkedList.add("char");
        linkedList.add("byte");
        linkedList.add("short");
        linkedList.add("int");
        linkedList.add("long");
        linkedList.add("float");
        linkedList.add("double");
        linkedList.addFirst("primitive 基本数据类型八种 ");
        System.out.println("链表 "+linkedList);
    }

    void method2(){
        HashSet set = new HashSet();
        set.add(new Person(1,"aqie"));
        set.add(new Person(2,"aqie2"));
        set.add(new Person(3,"aqie3"));
        set.add(new Person(3,"aqie3"));

        System.out.println(set);
    }
}
