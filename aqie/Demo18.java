package aqie;
// 遍历HashMap方式三  entrySet() 推荐
/*
public class Demo18 {
    public static void main(String[] args) {
        Map.Entry<String,String> entry = new Map.Entry<>();
    }
}

class Map{
    static class Entry<K,V>{
        K key;
        V value;
    }
}
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Demo18 {
    public static void main(String[] args) {
        Test18 t = new Test18();
        //t.method();
        t.method2();
        t.method3();
    }
}

class Test18{
    // HashMap  存储Person对象
    void method(){
        HashMap<Person,String> map = new HashMap<>();
        map.put(new Person(18,"aqie"),"001");
        map.put(new Person(22,"bqie"),"002");
        map.put(new Person(24,"cqie"),"003");
        System.out.println(map.put(new Person(30,"dqie"),"004"));
        // 如果id一致不允许重复添加 (只是针对键)  但是值会覆盖掉
        /**
         * 1. 重写 hashCode
         * 2. 重写 equals
         */
        System.out.println(map.put(new Person(30,"dqie123"),"005"));

        System.out.println(map);
        // {name: aqie=001, name: bqie=002, name: cqie=003, name: dqie=005}
    }

    // TreeMap 键 实现 Comparable接口 根据id排序
    void method2(){
        TreeMap<Person,String> tree = new TreeMap<>();
        tree.put(new Person(3,"aqie"),"001");
        tree.put(new Person(2,"bqie"),"002");
        tree.put(new Person(4,"cqie"),"003");
        tree.put(new Person(1,"dqie"),"004");

        System.out.println(tree);
    }

    void method3(){
        TreeMap<Person,String> tree = new TreeMap<>(new AgeComparator2());
        tree.put(new Person(3,18,"aqie"),"001");
        tree.put(new Person(2,22,"bqie"),"002");
        tree.put(new Person(4,24,"cqie"),"003");
        tree.put(new Person(1,20,"dqie"),"004");
        System.out.println(tree);
    }
}

// 自定义比较器
class AgeComparator2 implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
