package aqie2;

import java.io.Serializable;

public class Person implements Comparable<aqie2.Person>,Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public int id;
    int age;
    static String identity;
    private String income;
    protected String sex;

    public Person(){}
    private Person(String name){
        this.name = name;
    }
    public Person(int id,String name){
        this.name = name;
        this.id = id;
    }
    public Person(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void eat(int num){
        System.out.println(name+"is eating"+num+"lunch");
    }
    public void eat(int num,String[] arr){
        System.out.println(name+"is eating"+num+"dinner && breakfast");
    }
    public static void sleep(int time){
        System.out.println(identity+" is sleeping!"+time);
    }
    private void study(){
        System.out.println(name + "you rank is No.1!");
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
        if(obj instanceof aqie.Person){
            aqie2.Person person = (aqie2.Person)obj;
            return this.id == person.id;
        }
        return super.equals(obj);
    }

    // @Override
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
    public int compareTo(aqie2.Person o) {
        if(o != null){
            return (int)(this.id-o.id);
        }
        return 0;
    }
}
