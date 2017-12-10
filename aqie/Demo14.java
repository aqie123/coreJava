package aqie;

import java.util.ArrayList;

public class Demo14 {
    public static void main(String[] args) {
        Test12 t = new Test12();
        // t.method();
        t.method2();
    }
}

class Test12{

    // 定义集合存储字符串,然后把字符串的元素转换成大写
    void method(){
        // 泛型只存储String
        ArrayList<String> list = new ArrayList<String>();

        list.add("aa");
        list.add("bb");
        list.add("cc");

        for(int i = 0;i<list.size();i++){
            // 有泛型，从集合中取元素不用类型强转
            String str = list.get(i);

            list.set(i,str.toUpperCase());
        }
        System.out.println(list);
    }

    // 定义方法可以接收任意类型的数据,该方法返回类型与实参一致
    void method2(){
        String str = print("abc");
        print(123);
    }

    public static <T> T print(T o){

        return o;
    }
}
