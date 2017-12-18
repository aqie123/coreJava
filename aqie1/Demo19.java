package aqie1;

public class Demo19 {
    public static void main(String[] args) {
        Test19 t = new Test19("Game");
        t.start();
        for(int i = 0;i<100;i++){
            if(i == 80){
                t.flag = false;
                t.interrupt();
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

class Test19 extends Thread{
    boolean flag = true;
    public Test19(String name){
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("catch a InterruptedException");
            }
            System.out.println(Thread.currentThread().getName()+i);
            i++;
        }
    }
}

