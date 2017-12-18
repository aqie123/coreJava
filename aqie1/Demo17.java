package aqie1;

public class Demo17 {
    public static void main(String[] args) {
        Test17 t = new Test17();
        t.method();

        for (int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+ " : "+i);
        }
    }
}

class Test17{
    void method(){
        QQupdate qq = new QQupdate();
        Thread t = new Thread(qq,"qq download");
        t.setDaemon(true);
        System.out.println("is daemon threads " + t.isDaemon());
        t.start();
    }
}

class QQupdate implements Runnable{
    int num = 0;
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" have download"+i+"%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("download complete. begin to install!");
    }
}