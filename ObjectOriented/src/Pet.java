public class Pet {
    int id; // 编号
    String name = "狗";
    String color;

    public Pet(String n,String color){  // 形式参数也是属于局部变量
        name = n;
        this.color = color;
    }
    public Pet(int id,String name,String color){
        this(name,color);
        this.id = id;
        // this.name = name;
        // this.color = color;

    }
    void eat(){
        String name = "猫";
        System.out.println("局部变量 宠物："+name);
        System.out.println("调用对象 宠物："+this);
        System.out.println("成员变量 宠物："+this.name);
    }
    void sleep(){
        System.out.println(this.name+"在睡觉");
    }
    public static void main(String[] args){
        Pet p = new Pet("猪","黄色");
        Pet p2 = new Pet("沙皮狗","黑色");
        Pet p3 = new Pet(1,"哈皮狗","白色");
        // p.eat();
        p2.sleep();
        p3.sleep();
    }
}
