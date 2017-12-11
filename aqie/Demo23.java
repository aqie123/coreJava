package aqie;

import java.util.ArrayList;

public class Demo23 {
    public static void main(String[] args) {
        Test23 t = new Test23();
        // t.method();
        // t.method2();
        // t.method3();
        t.method4();
        t.method5();
    }
}

class Test23{
    // calculate the average grade of my class
    // define a function to figure out the summation of the parameters
    void method(){
        int[] arr = {1,2,3};
        sum(arr);
        sum2("a",1,2,3,4);
    }

    // receive array
    public static void sum(int[] arr){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        System.out.println(sum);
    }

    public static void sum2(String name,int... arr){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        System.out.println(sum);
         // 数组内存地址 [I@4554617c
        System.out.println(arr);
    }

    // 包装类
    void method2(){
        String str = "12";
        int num = Integer.parseInt(str);
        System.out.println(num);
        System.out.println("二进制 " + Integer.toBinaryString(num));

    }


    void method3(){
        // 自动装箱
        ArrayList<Integer> list = new ArrayList<>();
        // 集合存储对象  却能添加基本类型数据
        list.add(1);
        list.add(2);

        // 自动拆箱
        Integer i = new Integer(10);  // 引用数据类型数据
        System.out.println(i+3);            // 引用数据类型 + 基本数据类型

    }

    // Integer
    void method4(){
        Integer i1 = 12;
        Integer i2 = 12;
        Integer i3 = 128;
        Integer i4 = 128;
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println("The same Object " + (i1 == i2));
        System.out.println("The same Object " + (i3 == i4));
        System.out.println("The same Object " + (i5 == i6));
    }

    void method5(){

    }
}
