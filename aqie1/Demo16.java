package aqie1;

public class Demo16 {
    public static void main(String[] args) {
        Test16 t = new Test16();
        // t.method();

        t.method2();
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
    static int balance = 100;
    public WithdrawMoney(String name){
        super(name);
    }
    static Object o = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (o){
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
}