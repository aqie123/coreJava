public class Outer2 {
    int x = 10;
    public void print(){
       int y = 20;   // 执行到该语句时存在内存,方法执行完毕消失
        // 局部内部类
        class Inner{
            int z = 30;
            public void show(){
                System.out.println("外部类变量"+x);
                System.out.println("外部类局部变量"+y);
                // 对象没消失,方法内局部变量消失了,
                // 解决：访问局部变量复制品,用final修饰防止修改
                System.out.println("内部类局部变量"+z);
            }
        }
        Inner inner = new Inner(); // inner 生命周期比y长： print方法执行完毕,等待回收
        inner.show();
    }
}

class Outer2Driver{
    public static void main(String[] args){
        Outer2 outer2 = new Outer2();
        outer2.print();
    }
}
