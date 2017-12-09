package aqie;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// Demo4 Person 类   Demo2 User类
public class Demo12 {
    public static void main(String[] args) {
        Test10 t = new Test10();
        // t.method();
        // t.method2();
        // t.method3();
        // t.method4();
        // t.method5();
        t.method6();
    }
}

class Poker{
    String  num;
    String color;
    public Poker(String num,String color){
        super();
        this.num = num;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + " " +this.num;
        // return super.toString();
    }
}

class Test10{
    // LinkedList  基本操作
    void method(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("boolean");
        linkedList.add("char");
        linkedList.add("byte");
        linkedList.add("short");
        linkedList.add("int");
        linkedList.add("long");
        linkedList.add("float");
        linkedList.add("double");
        linkedList.addFirst("primitive 基本数据类型八种 ");
        System.out.println("链表 "+linkedList);
    }

    // HashSet 根据用户id 存储People对象，不允许重复
    void method2(){
        HashSet set = new HashSet();
        set.add(new Person(1,"aqie"));
        set.add(new Person(2,"aqie2"));
        set.add(new Person(3,"aqie3"));
        set.add(new Person(3,"aqie3"));

        System.out.println(set);
    }

    // LinkedList 存储人的对象,根据id 大小存储
    void method3(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(new Person(5,"aqie"));
        linkedList.add(new Person(2,"aqie2"));
        linkedList.add(new Person(3,"aqie3"));
        linkedList.add(new Person(1,"aqie4"));
        System.out.println(linkedList);
        sort(linkedList);
        System.out.println(linkedList);
    }

    public static void sort(LinkedList link){
        for(int i = 0;i<link.size()-1;i++){
            for(int j = i+1; j<link.size();j++){
                Person p1 = (Person)link.get(i);
                Person p2 = (Person)link.get(j);
                if(p1.id>p2.id){    // 从小到大    注意交换
                    link.set(i,p2);
                    link.set(j,p1);
                }
            }
        }
    }

    // LinkedList 存储poker,定义方法可以shuffle(洗牌)
    void method4(){
        // 生成 pokers
        LinkedList pokers = createPoker();
        showPokers(pokers);
        shufflePokers(pokers);
        showPokers(pokers);
    }

    // 温习String对比
    void method5(){
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println("内容一致嘛 "+str1.equals(str2));
        System.out.println("是同一个对象嘛 "+(str1 == str2));

        // hashCode默认情况得到是内存地址, String的hashCode根据内容算出来的
        System.out.println("Str1的HashCode "+str1.hashCode());
        System.out.println("Str2的HashCode "+str2.hashCode());
    }

    // HashSet实现注册功能,用户名密码一致视为同一个用户
    // 重写User hashCode  equals
    void method6(){
        // 定义集合用于存储用户
        HashSet users = new HashSet();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("please input your name");
            String userName = scanner.next();
            System.out.println("please input your password");
            String password = scanner.next();

            User user = new User(userName,password);
            if(users.add(user)){
                System.out.println("register success");
            }else{
                System.out.println("repeat user");
            }
            System.out.println("当前用户 "+users);
        }

    }

    // 构造一副Poker
    public static LinkedList createPoker(){
        // 定义一个集合存储扑克牌
        LinkedList pokers= new LinkedList();

        // 生成数组存储所有点数
        String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        // 生成数组存储花色 hearts(红桃), diamonds(方片), spades(黑桃) and clubs(梅花)
        String[] colors = {"hearts","diamonds","spades","clubs"};
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<colors.length;j++){
                pokers.add(new Poker(nums[i],colors[j]));
            }
        }
        return pokers;
    }

    // 显示pokers
    public static void showPokers(LinkedList pokers){
        for(int i=0; i<pokers.size();i++){
            if(i%10 == 9){
                System.out.println(pokers.get(i));
            }else {
                System.out.print(pokers.get(i)+",");
            }
        }
    }

    // 洗牌
    public static void shufflePokers(LinkedList pokers){
        Random random = new Random();
        for(int i = 0;i<100;i++){
            // 随机产生两个索引值
            int index1 = random.nextInt(pokers.size());
            int index2 = random.nextInt(pokers.size());

            // 让两张牌位置交换
            // 获取两个随机位置 牌
            Poker p1 = (Poker) pokers.get(index1);
            Poker p2 = (Poker) pokers.get(index2);
            // 交换位置
            pokers.set(index2,p1);
            pokers.set(index1,p2);
        }

    }




}




