package aqie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo20 {
    public static void main(String[] args) {
        Test20 t = new Test20();
        t.method();
    }
}

class Test20{
    void method(){
        int[] arr = {2,5,86,11};
        int[] arr2 = Arrays.copyOf(arr,5);  // false
        int[] arr3 = Arrays.copyOf(arr,4);  // true
        Integer[] arr4 = {2,5,86,11,34};       // 不能比较

        // 数组拷贝
        System.out.println(Arrays.toString(arr2));

        // 数组比较
        System.out.println(Arrays.equals(arr,arr3));


        // 数组变集合   注意集合这里类型
        List<Integer> list = Arrays.asList(arr4);
        System.out.println(list);
    }
}
