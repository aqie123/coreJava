package aqie;

import java.util.Comparator;
import java.util.TreeSet;

// TreeSet
public class Demo13 {
    public static void main(String[] args) {
        Test11 t = new Test11();
        // t.method();
        // t.method2();
        // t.method3();
        // t.method4();
        t.method5();
    }
}

class Test11{
    // treeSet简单比较
    void method(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(3);
        treeSet.add(3);
        treeSet.add(0);
        treeSet.add(5);
        treeSet.add(8);

        System.out.println(treeSet);
    }

    void method2(){
        TreeSet treeSet = new TreeSet();
        treeSet.add('a');
        treeSet.add('q');
        treeSet.add('i');
        treeSet.add('e');

        System.out.println(treeSet);
    }

    // 对象比较，实现Comparable接口  重写Person   compareTo()
    void method3(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person(3,"aqie3"));
        treeSet.add(new Person(1,"aqie"));
        treeSet.add(new Person(2,"aqie2"));

        System.out.println(treeSet);
    }

    // Animal  比较器对象比较
    void method4(){
        // 创建比较器对象
        AgeComparator ageComparator = new AgeComparator();

        TreeSet treeSet = new TreeSet(ageComparator);
        treeSet.add(new Animal(11,"dolphin"));
        treeSet.add(new Animal(9,"elephant"));
        treeSet.add(new Animal(6,"ape"));
        treeSet.add(new Animal(8,"goat"));

        System.out.println(treeSet);
    }

    // TreeSet对象对字符串拼接
    void method5(){
        String str = " 8 10 15 5 2 7";
        TreeSet t = new TreeSet();
    }

}

// 自定义比较器类
class AgeComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Animal && o2 instanceof Animal){
            Animal a1 = (Animal) o1;
            Animal a2 = (Animal) o2;
            return a1.age-a2.age;
        }
        return 0;
    }
}
