package aqie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Collection 常用方法：
public class Demo19 {
    public static void main(String[] args) {
        Test19 t = new Test19();
        t.method();
        t.method2();
        t.method3();
    }
}

class Test19{
    // 具备可比性数组排序
    void method(){
        // 推荐加泛型
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(0);
        list.add(5);
        list.add(8);
        System.out.println(list);  // [3, 3, 0, 5, 8] 有序可重复
        Collections.sort(list);
        System.out.println(list);
    }

    // 不具备可比性数组排序  Demo4.java Animal 类
    // 通过比较器对象
    void method2(){
        ArrayList<Animal> list  = new ArrayList<>();
        list.add(new Animal("001",20));
        list.add(new Animal("002",10));
        list.add(new Animal("003",30));

        Comparator comparator = new HeightComparator();
        Collections.sort(list,comparator);
        System.out.println(list);

        // 二分查找
        System.out.println(Collections.binarySearch(list,new Animal("003",30),comparator));
        System.out.println("最大值 "+Collections.max(list,comparator));
    }

    void method3(){
        ArrayList<Integer> list  = new ArrayList<>();       // 线程不安全
        list.add(3);
        list.add(5);
        list.add(7);
        // 二分查找
        System.out.println("元素索引值 "+ Collections.binarySearch(list,7));
        System.out.println("最大值 "+Collections.max(list));
        System.out.println("最小值 "+Collections.min(list));

        // 集合元素反转
        Collections.reverse(list);
        System.out.println("整数集合元素 "+list);

        // 集合元素位置交换
        Collections.swap(list,0,1);
        System.out.println("整数集合元素 "+list);

        // 集合元素替换
        Collections.replaceAll(list,5,9);
        System.out.println("整数集合元素 "+list);

        // 不同步的集合变成同步的集合
        List list2 = Collections.synchronizedList(list);
    }
}

class HeightComparator implements Comparator<Animal>{
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.height - o2.height;
    }
}