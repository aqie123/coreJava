package aqie;

import java.util.ArrayList;
import java.util.ListIterator;

public class Demo11 {
    public static void main(String[] args) {
        Test9 test9  = new Test9();
        test9.method();
    }
}

class Book{
    int id;
    String name;
    double price;
    public Book(int id,String name,double price){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name;
        //return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book){
            Book book = (Book)obj;
            return book.id == this.id;
        }
        return super.equals(obj);
    }
}
class Test9{
    void method(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Book(1,"代码大全",10));
        arrayList.add(new Book(2,"Effective java",20));
        arrayList.add(new Book(3,"java 性能优化",30));
        arrayList.add(new Book(3,"java 性能优化",30));

        // 定义函数中重复元素, id一致则为同一本书
        ArrayList newList = clearRepate(arrayList);
        System.out.println(newList);
    }

    public static ArrayList clearRepate(ArrayList OldList){
        // 创建一个新的集合对象
        ArrayList newList = new ArrayList();
        // 获取迭代器对象
        ListIterator it = OldList.listIterator();
        while(it.hasNext()){
            // 里面 是book对象
            Book book = (Book) it.next();
            // 判断集合中是否有指定元素
            if(!newList.contains(book)){        // contains 依靠的是equals,equals 默认比较内存地址
                newList.add(book);
            }
        }

        return newList;
    }
}
