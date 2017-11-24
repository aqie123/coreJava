public class Student {
    String name;
    int age;
    static String country = "中国";

    {
        System.out.println("非静态代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
       // printCountry();
    }

    public void compareAge(Student student2){
        if(this.age>student2.age){
            System.out.println(this.name+"大");
        }else{
            System.out.println(student2.name+"大");
        }
    }

    public void printCountry(){
        System.out.println(this.country);
    }

    public static void sleep(){
        System.out.println(country+"have a good sleep!");
    }

    void learn(){
        sleep();
        System.out.println(country+"study hard");
    }

    public static void main(String[] args){

        Student s1 = new Student("小明",18);
        s1.country = "美国";
        Student s2 = new Student("小红",19);
        s1.compareAge(s2);
        System.out.println(s2.country);

        // 使用类名访问静态变量
        System.out.println(Student.country);
        // Student.sleep();
        // s1.sleep();
        s1.learn();
    }
}
