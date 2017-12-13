package aqie1;

public class Demo8 {
    public static void main(String[] args) {
        Test8 t = new Test8();
        t.method();
    }
}

class Test8{
    void method(){
        Child child = new Child();
        Mother mother = new Mother(child);
        Father father = new Father(mother);
        father.work();
    }
}
interface Work{
    public void work();
    public static void sleep(){}
}

class Child implements Work{
    Work w;

    public void work(){
        System.out.println("I can paint");
    }
}

class Mother implements Work{
    Work w;
    public Mother(Work w){
        this.w = w;
    }
    public void work(){
        w.work();
        System.out.println("I can dope");
    }
}
class Father implements Work{
    Work w;
    public Father(Work w){
        this.w = w;
    }
    public void work(){
        w.work();
        System.out.println("I can install frame");
    }
}
