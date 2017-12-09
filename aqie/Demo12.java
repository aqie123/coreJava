package aqie;

import java.util.HashSet;
import java.util.LinkedList;

// Demo4 Person 类
public class Demo12 {
    public static void main(String[] args) {
        Test10 t = new Test10();
        // t.method();
        // t.method2();
        t.method3();
    }
}

class Test10{
    // LinkedList  基本操作
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

    // HashSet 根据用户id 存储People对象，不允许重复
    void method2(){
        HashSet set = new HashSet();
        set.add(new Person(1,"aqie"));
        set.add(new Person(2,"aqie2"));
        set.add(new Person(3,"aqie3"));
        set.add(new Person(3,"aqie3"));

        System.out.println(set);
    }

    // LinkedList 存储人的对象,根据id 大小存储
    void method3(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Person(5,"aqie"));
        linkedList.add(new Person(2,"aqie2"));
        linkedList.add(new Person(3,"aqie3"));
        linkedList.add(new Person(1,"aqie4"));
        System.out.println(linkedList);
        sort(linkedList);
        System.out.println(linkedList);
    }
    public static void sort(LinkedList link){
        for(int i = 0;i<link.size()-1;i++){
            for(int j = i+1; j<link.size();j++){
                Person p1 = (Person)link.get(i);
                Person p2 = (Person)link.get(j);
                if(p1.id>p2.id){    // 从小到大    注意交换
                    link.set(i,p2);
                    link.set(j,p1);
                }
            }
        }
    }

    // 存储poker,定义方法可以shuffle(洗牌)
    void method4(){

    }

    // HashSet实现注册功能,用户名密码一致视为同一个用户
}
