package aqie;

import java.util.ArrayList;
import java.util.Collection;

public class Demo16 {
    public static void main(String[] args) {
        Test13 t = new Test13();
        t.method();
    }
}

class Test13{
    void method(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Number> list2 = new ArrayList<Number>();
        list.add(1);
        list.add(4);
        print(list);

        ArrayList<Double> list3 = new ArrayList<Double>();
        list3.add(3.12);
        test(list3);
    }
    // 泛型通配符 ？   只能存储Integer 以及 Integer 的父类
    public static void print(Collection<? super Integer> c){
        System.out.println("泛型下限 "+c);
    }
    public void test(Collection<? extends Number> c){
        System.out.println("泛型上限 " + c);
    }
}
