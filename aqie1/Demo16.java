package aqie1;

public class Demo16 {
    public static void main(String[] args) {
        Test16 t = new Test16();
        // t.method();

        // t.method2();
        // t.method3();
        // t.method4();
        t.method5();
    }
}

class Test16{
    void method(){
        SaleTickets saleTickets1 = new SaleTickets("Window One  ");
        SaleTickets saleTickets2 = new SaleTickets("Window Two  ");
        SaleTickets saleTickets3 = new SaleTickets("Window Three  ");
        saleTickets1.start();
        saleTickets2.start();
        saleTickets3.start();
    }

    void method2(){
        WithdrawMoney withdrawMoney = new WithdrawMoney("Husband");
        WithdrawMoney withdrawMoney2 = new WithdrawMoney("Wife");
        withdrawMoney.start();
        withdrawMoney2.start();
    }

    void method3(){
        DeadLockThread d = new DeadLockThread("a");
        DeadLockThread d2 = new DeadLockThread("b");
        d.setPriority(10);
        d2.setPriority(1);
        d.start();
        d2.start();
    }

    void method4(){
        Multithreading m = new Multithreading();
        Thread t = new Thread(m,"secondWay");
        t.start();
    }

    void method5(){
        SellTickets s1 = new SellTickets();
        Thread a = new Thread(s1,"windows 1");
        Thread b = new Thread(s1,"windows 2");
        a.start();      b.start();
    }
}

// simulate station sale 50 tickets
class SaleTickets extends Thread{
    // 非静态成员变量在每个对象中,都维护了一份数据
    static int num = 50;
    public SaleTickets(String name){
        super(name);
    }
    static Object o = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (o){
                if(num > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "sell number"+ num);
                    num--;
                }else{
                    System.out.println("tickets sell up");
                    break;
                }
            }
        }
    }
}

// husband  Passbook creditCard
class WithdrawMoney extends Thread{
    static int balance = 10;
    public WithdrawMoney(String name){
        super(name);
    }
    static Object o = new Object();

    // 非静态同步函数 -- 锁对象this对象 :当前有两个
    @Override
    public synchronized void run() {
        getMoney();
    }

    // 静态同步函数, 当前方法所属类的class文件对象
    // 会出现一个人把钱取光
    private synchronized static void getMoney(){
        while (true){
            if(balance > 0){
                System.out.println(Thread.currentThread().getName()+
                        " remaining balance :"+(balance-1));
                balance = balance - 1;
            }else {
                System.out.println("Your balance is zero !");
                break;
            }
        }
    }
}

class DeadLockThread extends Thread{
    public DeadLockThread(String name){
        super(name);
    }

    @Override
    public void run() {
        if("a".equals(this.getName())){
            synchronized ("RemoteControl"){
                System.out.println(this.getName()+"waiting for battery");
                synchronized ("battery"){
                    System.out.println(this.getName()+" open air conditioner");
                }
            }
        }else if("b".equals(this.getName())){
            synchronized ("battery"){
                System.out.println(this.getName()+"waiting for RemoteControl");
                synchronized ("RemoteControl"){
                    System.out.println(this.getName()+" open air conditioner");
                }
            }
        }
    }
}

// Second way to create multithreading
class Multithreading implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            // System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println("当前线程对象 " + Thread.currentThread());
        System.out.println("当前对象 " + this);
    }
}

class SellTickets implements Runnable{
    static int num = 200;
    @Override
    public void run() {
        while (true){
            synchronized ("aqie"){
                if(num > 0){
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    num--;
                }else{
                    System.out.println("sell out");
                    break;
                }
            }
        }
    }
}