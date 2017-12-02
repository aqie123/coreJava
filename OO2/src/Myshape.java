import sun.security.util.Length;

/**
 * 定义方法接收任意类型图形对象,在其内部调用计算边长周长方法
 * 定义方法返回任意类型的图形对象
 */
abstract class Myshape {
    public abstract void getLength();
    public abstract void getArea();
}

// 长方形
class Rectangle extends Myshape{
    int length;
    int width;
    public Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }
    public void getLength(){
        System.out.println("长方形边长 "+2*(length+width));
    }
    public void getArea(){
        System.out.println("长方形面积 "+length*width);
    }
}

// 正方形
class Square extends Myshape{
    int length;
    public Square(int length){
        this.length = length;
    }
    public void getLength(){
        System.out.println("正方形边长 "+4*length);
    }
    public void getArea(){
        System.out.println("正方形面积 "+length*length);
    }
}

// 圆
class Circles extends Myshape{
    public static double PI = 3.14;
    int radius;
    public Circles(int radius){
        this.radius = radius;
    }

    public void getLength(){
        System.out.println("圆形边长 "+2*PI*radius);
    }
    public void getArea(){
        System.out.println("圆形面积 "+PI*radius*radius);
    }

    // 多态下调用子类特有方法 ： 强制类型转换
    public void speak(){
        System.out.println("I am talking");
    }
}

class MyshapeDriver{
    public static void main(String[] args){
        Myshape rectangle = getShape(2);
        Length(rectangle);
        Area(rectangle);

        Myshape square = getShape(1);
        Length(square);
        Area(square);

        // 强制类型转换
        Circles circles = (Circles)getShape(0);
        circles.speak();
        Area(circles);
    }
    public static void Length(Myshape shape){
        shape.getLength();
    }
    public static void Area(Myshape shape){
        shape.getArea();
    }

    // 返回任意类型对象
    public static Myshape getShape(int i){
        if(i == 0){
            return new Circles(2);
        }else if(i == 1){
            return new Square(4);
        }else{
            return new Rectangle(3,4);
        }
    }

    // 定义方法接收任意类型图形对象,在方法内部调用对象特有方法
    public static void print(Myshape myshape){
        if(myshape instanceof Circles){
            Circles c = (Circles)myshape;
        }else if(myshape instanceof Square){
            Square s = (Square)myshape;
        }else{
            Rectangle r = (Rectangle)myshape;
        }
    }
}