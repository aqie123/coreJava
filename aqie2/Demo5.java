package aqie2;

public class Demo5 {
    public static void main(String[] args) {
        Test5 t = new Test5();
        t.method();
        Car BMW = Test5.getCar(0);
        BMW.sayName();
    }

}

class Test5{
    void method(){

    }
    public static Car getCar(int num){
        if(num == 0){
            return new BMW();
        }else{
            return new Maserati();
        }
    }
}
abstract class Car{
    abstract void sayName();
}

class BMW extends Car{
    public void sayName(){
        System.out.println("I am BWM");
    }
}

class Maserati extends Car{
    public void sayName(){
        System.out.println("I am Maserati");
    }
}