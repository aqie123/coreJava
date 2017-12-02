abstract class Animal {
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
    public abstract void run();
}

class Bird extends Animal{
    String name = "lark";
    String color = "Silver";
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
    public void run(){}
}

class Dog extends Animal{
    public Dog(String name,String color){
        super(name,color);
    }
    public void run(){

    }
}

// home可以收养各种动物，之前用方法重载
// 通过多态接收多个类型参数
class Home{
    // 收养动物
    public static void adoption(Animal animal){
        System.out.println("adapt" + animal.name);
    }
    // 出售动物,返回动物对象
    public static Animal saleAnimal(int money){
        if(money == 100){
            return new Bird();
        }else if(money == 200){
            return new Dog("Patchy","black");
        }else{
            return new Dog("Pike","Silver");
        }
    }
}

class BirdDriver{
    public static void main(String[] args){
        Animal bird = new Bird();
        Animal dog = new Dog("Husky","red");
        /*
        Bird bird = new Bird();

        bird.name = "bird";
        // bird.age = 1;

        bird.eat();
        System.out.println(bird.color);     // null
        System.out.println("鸟是动物类"+(bird instanceof Bird));
        */

        Home.adoption(bird);
        Home.adoption(dog);
        Animal myPet = Home.saleAnimal(300);
        System.out.println(myPet.color);
        System.out.println(myPet.name);

    }
}
