public class Car {
    // 事务公共属性使用成员变量描述
    String name;
    String color;
    int wheel;

    public void run(){
        System.out.println("you can run but you can not hide");
        System.out.println(color);
    }
}
