package aqie2;

import java.util.ArrayList;
import java.util.Random;

public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        Employee e = new Employee("aqie");
        Employee e2 = new Employee("aqie123");
        Student s = new Student("Ming");

        WeatherStation2 w = new WeatherStation2();
        w.addListener(e);
        w.addListener(e2);
        w.startWork();
    }
}


class WeatherStation2{
    String[] weathers = {"暴雨","雾霾","台风","晴天","阵雨"};
    /*
    // 气象站维护一个人对象
    Employee employee;
    public WeatherStation(Employee e){
        this.employee = e;
    }
    */
    // 内部维护一个集合
    ArrayList<Employee> list = new ArrayList<>();       // 程序的解耦,类与类不能过度依赖
    public void addListener(Employee e){
        list.add(e);
    }
    // 当前天气
    String weather;
    Random random = new Random();

    public void updateWeather(){
        int index = random.nextInt(weathers.length);
        weather = weathers[index];
        System.out.println("Current weather is " + weather);
    }

    // 每隔1-1.5秒更新天气
    public void startWork() throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                while(true){
                    updateWeather();
                    // employee.notifyWeather(weather);
                    for(Employee e:list){
                        e.notifyWeather(weather);
                    }
                    int millis = random.nextInt(501)+1000;
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}

class Student{
    String name;
    public Student(String name){
        super();
        this.name = name;
    }

    // 人要根据天气作出相应处理方案
    public void notifyWeather(String weather){
        if("暴雨".equals(weather)){
            System.out.println(name+"不上学");
        }else if("雾霾".equals(weather)){
            System.out.println(name+"商务上学");
        }else if("阵雨".equals(weather)){
            System.out.println(name+"正常上学");
        }else if("晴天".equals(weather)){
            System.out.println(name+"努力上学");
        }else{
            System.out.println(name+"睡觉，盖被子");
        }
    }
}

