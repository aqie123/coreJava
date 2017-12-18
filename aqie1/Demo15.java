package aqie1;

public class Demo15 extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Test15 t = new Test15("Test15");    // t.start();
        System.out.println("自定义线程优先级 " + t.getPriority());


        Thread.sleep(1000);     // 指定线程睡眠毫秒数
        Thread thread = Thread.currentThread();        // 当前线程 main
        thread.setPriority(10);
        System.out.println(thread.getName());
        System.out.println("主线程优先级 "+ thread.getPriority());


        QQ q = new QQ();        // q.start();
    }
}

class Test15 extends Thread{
    public Test15(String name){
        // 指定调用Thread类一个参数的构造方法,给线程初始化
        super(name);
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread() == this);
        for(int i =0; i<100;i++){
            System.out.println(this.getName()+ ": "+i);
        }
    }
}

class QQ extends Thread{
    @Override
    public void run(){
        for(int i =0; i<100;i++){
            System.out.println(this.getName()+ ": "+i);
        }
    }
}