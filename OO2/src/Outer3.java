/**
 *  定义局部内部类继承Animal2，创建对象调用run
 */
abstract class Animal2 {
    public abstract void run();
    public abstract void alert();
}
interface Dao2{
    public void del();
}
class Outer3{
    public void print(){
        /*
        class Fish2 extends Animal2{
            public void run(){
                System.out.println("鱼在游");
            }
        }
        // 创建局部内部类的对象
        Fish2 fish2 = new Fish2();
        fish2.run();
        */
        // 创建Animal2子类 匿名内部类 继承Animal2
        new Animal2(){    // 多态  使用变量接收匿名对象
            String name = "fish";
            public void run(){
                System.out.println(name + " is swimming");
            }
            public void alert(){
                System.out.println(name + " is alert");
            }
            // 多态 调用父类没有方法
            public Animal2 sleep(){
                System.out.println(name + " is sleeping");
                return this;
            }
        }.sleep().run();

    }

    public void talk(){
        // 接口实现匿名内部类
        new Dao2(){
            public void del(){
                System.out.println("删除成功");
            }
        }.del();
    }
}
class AnimalDriver{
    public static void main(String[] args){
        Outer3 outer3 = new Outer3();
        outer3.print();
        outer3.talk();
    }
}
