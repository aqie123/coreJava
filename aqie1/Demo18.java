package aqie1;

public class Demo18 {
    public static void main(String[] args) {
        Test18 t = new Test18();
        // t.method();
        t.method2();
    }
}

class Test18{
    void method(){
        CookDinner c = new CookDinner();
        Thread t1 = new Thread(c,"CookDinner");
        t1.start();
    }
    void method2(){
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        // 创建线程对象
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();     t2.start();
    }
}

class CookDinner implements Runnable{
    @Override
    public void run() {
        System.out.println("cut up vegetables");
        System.out.println("wash vegetables");

        System.out.println("wait for soy sauce");
        // 线程让步
        BuySauce b = new BuySauce();
        Thread t2 = new Thread(b,"BuySauce");   t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("cooking");
        System.out.println("eat dinner");
    }
}

class BuySauce implements Runnable{
    @Override
    public void run() {
        System.out.println("walk down the stairs");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("buy soy sauce");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("come back");
    }
}

class Product{
    String name;
    double price;
    // Whether the product is finished or not
    boolean flag;
}

class Producer implements Runnable{
    // Maintenance
    Product product;
    public Producer(Product p){
        this.product = p;
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            synchronized (product){
                // if the production is not finish
                if(!product.flag){
                    if(i%2 == 0){
                        product.name = "Alienware";
                        product.price = 10000;
                    }else{
                        product.name = "bicycle";
                        product.price = 30000;
                    }
                    System.out.println("Producer " + product.name + " "+product.price);
                    i++;
                    // change flag
                    product.flag = true;
                    product.notify();
                }else {
                    // if the product is finished,wait for the consumer to consume
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consumer implements Runnable{
    Product product;
    public Consumer(Product p){
        this.product = p;
    }
    @Override
    public void run() {
        while(true){
            synchronized (product){
                if (product.flag){
                    System.out.println("consumer spending " + product.name+" "+product.price);
                    // change flag
                    product.flag = false;
                    product.notify();
                }else {
                    // has not been product,wake up the producer
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}