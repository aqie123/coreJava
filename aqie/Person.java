package aqie;

import java.util.Arrays;
import java.util.Properties;

class Demo4 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        // Test2.method();
        // Test2.method2();
        // Test2.method3();
        Test2.method4();
    }
}

class Test2{
    static void method(){
        int[] sourceArr = {144,23,37,56}; // 原数组
        int[] targetArr = new int[4];  // 目标数组
        System.arraycopy(sourceArr,1,targetArr,2,2); // 数组越界
        System.out.println(Arrays.toString(targetArr));
    }

    static void method2(){
        for (int i=0;i<4;i++){
            Person person = new Person(1,"john"+i);
            System.gc();
        }
    }

    static void method3(){
        String java = System.getenv("JAVA_HOME");
        System.out.println(java);
    }

    static void method4(){
        Properties p = System.getProperties();
        String osName = System.getProperty("os.name");
        // p.list(System.out);  输出系统信息
        if("Windows 7".equals(osName)){
            System.out.println("software installation");
        }else {
            System.out.println("Environment disconformity");
        }
    }
}

public class Person implements Comparable<Person>{
    public String name;
    int id;
    int age;
    public Person(int id,String name){
        this.name = name;
        this.id = id;
    }
    public Person(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this.name);
    }

    @Override
    public String toString() {
        // return super.toString();
        return "name: "+this.name;
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        // return this.id;
        return this.name.hashCode()+this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person person = (Person)obj;
            return this.id == person.id;
        }
        return super.equals(obj);
    }

    @Override
    // 重新定义元素与元素比较规则
    // 负数 正数 0  小于 大于 等于
    /*
    public int compareTo(Object o) {
        if(o instanceof Person){
           Person person = (Person) o;
           System.out.println(this.name+" compareTo "+person.name);
            return this.id-person.id;
        }
        return 0;
    }
    */
    public int compareTo(Person o) {
        if(o != null){
            return (int)(this.id-o.id);
        }
        return 0;
    }
}

class Animal{
    public String name;
    int age;
    int height;
    String id;
    public Animal(String id,int height){
        this.id = id;
        this.height = height;
    }
    public Animal(int age,String name){
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // return super.toString();
        // return "name: "+this.name;
        return this.id;
    }


}