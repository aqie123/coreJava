public class Animal {
    String name;
    String color;
    private int age;
    int x = 10;
    public Animal(String name, String color){
        this.name = name;
        this.color = color;
        System.out.println("有参构造函数");
    }
    public Animal(){
        System.out.println("无参构造函数");
    }
    public void eat(){
        System.out.println(name+" eat!");
    }
}

class Bird extends Animal{
    int x = 20;
    public Bird(){
        super("aqie","red");
        /*
        System.out.println("bird 无参构造函数");
        System.out.println("子类"+x);
        System.out.println("父类"+super.x);
        */
    }

    public void eat(){
        super.eat();
        System.out.println("I am eating!");
    }
}

class BirdDriver{
    public static void main(String[] args){
        Bird bird = new Bird();
        bird.name = "bird";
        // bird.age = 1;

        bird.eat();
        System.out.println(bird.color);     // null
    }
}
