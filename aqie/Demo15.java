package aqie;

import java.util.Arrays;

// 数组的工具类
public class Demo15 {
    public static void main(String[] args) {
        Test15 t = new Test15();
        t.method();
        t.method2();
        t.method3();
    }
}

class Test15{
    void method(){
        String[] arr = {"a","b","c","d"};
        MyArrays myArrays = new MyArrays();
        myArrays.reverse(arr);
        System.out.println(myArrays.myToString(arr));
    }

    void method2(){
        Integer[] arr = {1,2,3,4,5};
        // 该对象只能操作 int类型数组
        MyArrays2<Integer> myArrays = new MyArrays2();
        myArrays.reverse(arr);
        System.out.println(myArrays.myToString(arr));
    }

    void method3(){
        Admin<String> admin = new Admin<String>();
        admin.add("aqie");
    }
}
class MyArrays{
    // 数组反转
    public <T> void reverse(T[] arr){
        for(int startIndex = 0, endIndex = arr.length-1; startIndex < endIndex;
                startIndex++,endIndex--){
            T tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
    }

    // 数组转字符串
    public <T> String myToString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            if(i == 0){
                sb.append("[" + arr[i]+ ",");
            }else if(i == arr.length-1){
                sb.append(arr[i]+"]");
            }else{
                sb.append(arr[i]+",");
            }
        }
        return sb.toString();
    }
}

class MyArrays2<T>{
    // 数组反转
    public  void reverse(T[] arr){
        for(int startIndex = 0, endIndex = arr.length-1; startIndex < endIndex;
            startIndex++,endIndex--){
            T tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
    }

    // 数组转字符串
    public  String myToString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            if(i == 0){
                sb.append("[" + arr[i]+ ",");
            }else if(i == arr.length-1){
                sb.append(arr[i]+"]");
            }else{
                sb.append(arr[i]+",");
            }
        }
        return sb.toString();
    }

    public  static <T> void test(T[] arr){}
}

// 泛型接口
interface Dao3<T>{
    public void add(T t);
}

// 需求 ： 创建接口实现对象时候再指定接口自定义泛型具体数据类型
class UserDao2 implements Dao3<String>{
    @Override
    public void add(String t) {     // 重写时 ： 函数名与形参列表必须一致
        // todo
        System.out.println("add user success");
    }
}
class Admin<T> implements Dao3<T>{     // 类中要使用泛型
    @Override
    public void add(T t) {
        System.out.println("add admin success! "+t);
    }
}
