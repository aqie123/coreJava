package aqie2;

import java.util.ArrayList;
import java.util.Random;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Employee e = new Employee("aqie");
        Employee e2 = new Employee("aqie123");
        WeatherStation w = new WeatherStation();
        w.addListener(e);
        w.addListener(e2);
        w.startWork();

        /*
        Random random = new Random();
        while (true){
            e.notifyWeather(w.weather);
            int s = random.nextInt(501)+1000;
            Thread.sleep(s);
        }
        */
    }
}

class Test7{
    void method(){

    }
}
class Observer{

}

class WeatherStation{
    String[] weathers = {"暴雨","雾霾","台风","晴天","阵雨"};
    /*
    // 气象站维护一个人对象
    Employee employee;
    public WeatherStation(Employee e){
        this.employee = e;
    }
    */
    // 内部维护一个集合
    ArrayList<Employee> list = new ArrayList<>();
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

