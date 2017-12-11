package aqie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Demo22 {
    public static void main(String[] args) {
        Test22 t = new Test22();
        t.method();
    }
}

class Test22{
    void method(){
        ArrayList a = new ArrayList();
        MyList list = new MyList();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        for(String ele : list){
            System.out.print(ele);
        }
    }
}

class MyList implements Iterable<String>{
    Object[] arr;
    // 当前索引值
    int index = 0;
    public MyList(){
        arr = new Object[10];
    }

    public void add(Object obj){
        int miniLength = index + 1;
        ensureCapacity(miniLength);
        arr[index++] = obj;
    }

    // 检查当前长度是否够用,不够自动扩展
    // ArrayList  参照List实现方式
    public void ensureCapacity(int miniLength){
        if(miniLength == arr.length){
            int newLength = (int) (arr.length*1.5);
            arr = Arrays.copyOf(arr,newLength);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int cursor;  // 游标

            @Override
            public boolean hasNext() {
                return cursor != index;
            }

            @Override
            public String next() {
                return (String)arr[cursor++];
            }
        };
    }
}
