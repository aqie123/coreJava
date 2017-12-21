package aqie2;

public class Student implements Weather{
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
