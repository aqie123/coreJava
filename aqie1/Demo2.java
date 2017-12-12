package aqie1;
import aqie.Person;

import java.util.HashSet;
import java.util.Iterator;

public class Demo2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        // t.method();
        t.method2();
    }
}

class Test2{
    // 导入不同包的类
    void method(){
        Person p = new Person(1,"aqie");
        System.out.println(p);
    }

    // HashSet  People  id相同则为同一个人
    void method2(){
        Person p = new Person(1,"aqie");
        Person p2 = new Person(2,"aqie2");
        Person p3 = new Person(1,"aqie");
        HashSet<Person> people = new HashSet<>();
        people.add(p); people.add(p2); people.add(p3);
        System.out.println("集合的元素 " + people);

        // 迭代器 Iterator 迭代 HashSet
        Iterator<Person> it = people.iterator();        // 加泛型
        while (it.hasNext()){
            Person person = it.next();                  // 上面加泛型，这里不用管
            if(person.name.equals("aqie2")){
                // 不用HashSet  使用ArrayList
                person.name = "啊切";                   // 改名字会造成删除失败 hashCode根据name算出来
                // people.remove(person);               // 这么迭代 遇到next会报错
                it.remove();
            }
        }
        System.out.println("集合的元素 " + people);
    }
}