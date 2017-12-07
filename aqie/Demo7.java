package aqie;

import java.util.Random;

public class Demo7 {
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        // test5.method();
        // test5.method2();
        test5.method3();
    }
}

class Test5{
    void method(){
        System.out.println(Math.abs(-3.14));
        System.out.println(Math.ceil(-3.14));  // -3
        System.out.println(Math.floor(-3.14));  // -4
        System.out.println(Math.round(-3.45));  // -3
        System.out.println(Math.random());  // 0.0-1.0不包括1.0
    }

    void method2(){
        Random random = new Random();
        System.out.println(random.nextInt(11));
    }

    // 实现四位验证码
    void method3(){
        char[] arr = {'a','b','c','d','e',3,8,6,'啊','切'};
        Random random = new Random();

        // 创建字符串缓冲区类
        StringBuilder strbuild = new StringBuilder();


        // 产生四位随机索引值
        for(int i = 0;i<4;i++){
            int index = random.nextInt(arr.length);
            char temp = arr[index];
            strbuild.append(temp);
        }
        System.out.println("验证码： "+strbuild);
    }
}
