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
        w.addListener(s);
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
    ArrayList<Weather> list = new ArrayList<>();       // 程序的解耦,类与类不能过度依赖
    public void addListener(Weather e){
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
                    for(Weather e:list){
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





