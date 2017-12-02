public class Duck {
    int age = 10;
    static String name = "duck";
    private int size;
    private static int duckCount = 0;

    public Duck(){
        duckCount++;
    }

    void setSize(int a){
        size = a;
    }
    int getSize(){
        return size;
    }
    void sleep(){
        System.out.println("Duck is sleeping");
    }
    static void eat(){
        System.out.println("Duck is eat");
    }

}
class GreyDuck extends Duck{
    int age = 20;
    static String name = "greyDuck";
    void sleep(){
        System.out.println("greyDuck is sleeping");
    }
    static void eat(){
        System.out.println("greyDuck is eat");
    }
    void bite(){
        System.out.println("greyDuck is bite");
    }
}

class DuckDriver{
    public static void main(String[] args){
        Duck d = new GreyDuck();
        System.out.println(d.age);
        System.out.println(d.name);
        d.sleep();
        d.eat();
        // d.bite();   报错
    }
}
