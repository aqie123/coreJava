public class Person {
    int i = 1;
    // 构造代码块
    {
        i = 2;
    }

    // 构造函数 是最后执行的
    public Person(){
        i = 3;
    }

}

class Demo{
    public static void main(String[] args){
        Person p = new Person();
        System.out.println(p.i);    // 3
        System.out.println(p);
    }
}
