/**
 * 需求：所有学生会学习,部分学生会赚钱
 */
public class Student {
    String name;
    public Student(String name){
        this.name = name;
    }
    void study(){
        System.out.println(name+" learn hard");
    }
}

interface Money{
    void makeMoney();
}
interface FallInLove{
    void love();
}
interface Birth{
    void birth();
}
// 接口可以多继承
interface Family extends FallInLove,Birth{
    void child();
}
abstract class CleverPeople implements Money,Family{

}

class PartTimeStudent extends Student implements Money,FallInLove{
    public PartTimeStudent(String name){
        super(name);
    }
    public void makeMoney(){
        System.out.println(name+" make money");
    }
    public void love(){
        System.out.println(name+" fall in love with sb");
    }
}

class CleverStudent extends CleverPeople{
    public void makeMoney(){}
    public void love(){}
    public void birth(){}
    public void child(){}
}

class StudentDriver{
    public static void main(String [] args){
        Student s = new Student("ming");
        s.study();

        PartTimeStudent s2 = new PartTimeStudent("aqie");
        s2.makeMoney();
    }
}