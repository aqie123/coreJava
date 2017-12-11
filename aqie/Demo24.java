package aqie;

public class Demo24 {
    public static void main(String[] args) {
        Test24 t = new Test24();
        t.method();
        t.method2();
        t.method3();
    }
}

class Test24{
    void method(){
        Accountant a = new Accountant("aqie");
        // 只能使用提供的对象
        a.setSex(Gender.man);
        System.out.println(a);
    }

    // 枚举类简单应用
    void method2(){
        Season.AUTUMN.getSeason();
    }

    // switch 枚举类型  switch 中只需要写枚举值SPRING  其他则为 Season.SPRING:
    void method3(){
        Season currentSeason = Season.WINTER;
        switch(currentSeason){
            case SPRING:
                System.out.println("这是春天");
                break;
            case SUMMER:
                System.out.println("这是夏天");
                break;
            case AUTUMN:
                System.out.println("这是秋天");
                break;
            case WINTER:
                System.out.println("这是冬天");
                break;
        }
    }
}

// custom sex
class Gender{
    // 对外提供本类的对象
    public static final Gender man = new Gender("man");
    public static final Gender woman = new Gender("woman");

    String value;

    private Gender(String value){
        this.value = value;
    }
}

class Accountant{
    String name;
    private Gender sex;

    public Accountant(String name){
        this.name = name;
    }

    public Gender getSex(){
        return sex;
    }

    public void setSex(Gender sex){
        this.sex = sex;
    }

    @Override
    public String toString() {
        // 这个value
        return this.name + this.sex.value;
    }
}

// 自定义枚举类
enum Season{
    // 这些是对象 ，构造方法传参
    SPRING("春天"){
        @Override
        void detail() {

        }
    },SUMMER("夏天"){
        @Override
        void detail() {

        }
    },AUTUMN("秋天"){
        @Override
        void detail() {

        }
    },WINTER("冬天"){
        @Override
        void detail() {

        }
    };

    String value;

    Season(String value){
        this.value = value;
    }

    public void getSeason(){
        System.out.println(value);
    }

    abstract void detail();
}