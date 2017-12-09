package aqie;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// 迭代器
public class Demo9 {
    public static void main(String[] args) {
        Test7 t = new Test7();
        // t.method();
        t.method2();
        // t.method4();
    }
}

class Test7{
    // toArray
    void method(){
        Collection c = new ArrayList();
        c.add("aqie");
        c.add("bqie");
        c.add("cqie");
        // 集合中元素存储到Object数组中再返回
        Object[] arr = c.toArray();
        for(Object str:arr){
            System.out.print(str);
        }
    }

    // iterator 迭代器
    void method2(){
        Collection c = new ArrayList();
        c.add("aqie"); c.add("bqie"); c.add("cqie");

        // c中的 iterator()返回的Itr implements Iterator
        // 多态
        Iterator it = c.iterator();
        System.out.println("是否有元素可遍历 "+ it.hasNext());
        while (it.hasNext()){
            System.out.println("元素 "+ it.next());
            it.remove();  // 清空集合内元素
        }
        System.out.println("集合元素 "+c);
    }

    // 多态
    void method3(){
        // 面向接口的多态,接口声明变量,指向接口实现类的对象
        // Dao dao = new UserDao();
        Dao dao = getInstance();    // 获取接口实现类对象
    }

    public static Dao getInstance(){
        // 返回的 Dao接口的实现类
        return new UserDao();
    }

    void method4(){
        Collection c = new ArrayList();
        c.add("aqie"); c.add("bqie"); c.add("cqie");
        Iterator it = c.iterator();
        it.next();
        it.remove();
        System.out.println("集合元素 "+c);
    }

    void method5(){

    }
}

interface Dao{
    public void add();
}

class UserDao implements Dao{
    @Override
    public void add() {
        System.out.println("添加用户成功");
    }
}

