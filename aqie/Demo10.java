package aqie;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo10 {
    public static void main(String[] args) {
        Test8 test8 = new Test8();
        // test8.method();
        // test8.method2();
        // test8.method3();
        // test8.method4();
        test8.method5();
    }
}

class Test8{
    void method(){
        List list = new ArrayList();
        list.add("王健林");
        list.add("马化腾");
        list.add("刘强东");
        list.add("4");
        list.add("4");
        list.add(0,"码云");
        list.set(1,"任正非");

        System.out.println("list集合元素 "+list);
        System.out.println(list.get(1));
        System.out.println(list.lastIndexOf("4"));
        System.out.println(list.subList(1,3));
    }

    // 迭代器 listIterator
    void method2(){
        List list = new ArrayList();
        list.add("王健林");
        list.add("马化腾");
        list.add("刘强东");

        System.out.println(list.get(0));  // 从0开始的
        System.out.println(list.get(1));
        System.exit(0);
        ListIterator it = list.listIterator();
        it.next();
        System.out.println("有上个元素 "+ it.hasPrevious());
        // 指针移动到末尾
        while (it.hasNext()){
            it.next();
        }
        while (it.hasPrevious()){
            System.out.println("上个元素是 "+ it.previous());
        }
        // 目前在初始位置
        it.next();
        it.add("name");
        System.out.println("集合元素 " + list);
        it.next();
        it.set("name123");
        System.out.println("集合元素 " + list);

    }

    // 使用四种方式遍历集合元素
    void  method3(){
        List list  = new ArrayList();
        list.add("1"); list.add("2"); list.add("3"); list.add("4");
        System.out.println("集合元素 " + list);
        // 1. toArray() 遍历
        // 集合中元素添加到数组并返回
        Object[] arr = list.toArray();
        for(Object ele:arr){
            System.out.print(ele);
        }

        // 2. iterator 迭代器 正序
        ListIterator it = list.listIterator();
        /*
        while(it.hasNext()){
            System.out.print(it.next());
        }
        */

        // 3. for循环配合get
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i));
            it.next();  // 对本次循环无作用
        }

        // 4. iterator 迭代器 倒序

        while (it.hasPrevious()){
            System.out.print(it.previous());
        }

    }

    void method4(){
        List list  = new ArrayList();
        list.add("1"); list.add("2"); list.add("3");
        ListIterator it = list.listIterator();
        while (it.hasNext()){
            System.out.print(it.next()+",");
            // 添加到当前游标指向位置
            // it.add("6");  // 使用迭代器的add方法，游标会+1
            // ConcurrentModificationException   会报错
            list.add("7");   // 集合对象add方法,每次都加到集合最后面
        }
        System.out.println(list);
    }

    // ArrayList 实现原理
    void method5(){
        ArrayList list = new ArrayList();
        list.add("1");
    }
}
