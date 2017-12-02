public class Circle {
    double r;
    // 修饰基本成员变量
    static final double PI = 3.14;
    public Circle(double r){
        this.r = r;
    }

    void getArea(){
        System.out.println("circle acreage "+PI*r*r);
    }
}

class CircleDriver{
    public static void main(String[] args){
        // 修饰引用类型变量
        final Circle circle = new Circle(3.0);
        circle.getArea();
        // 局部变量是独立的
        print(circle);
    }
    public static void print(Circle c){
        // 一个方法运行会在栈内存开辟独立的空间
        c = new Circle(4.0);
    }
}