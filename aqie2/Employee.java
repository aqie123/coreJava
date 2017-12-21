package aqie2;

public class Employee implements Weather{
    String name;
    public Employee(String name){
        super();
        this.name = name;
    }

    // 人要根据天气作出相应处理方案
    public void notifyWeather(String weather){
        if("暴雨".equals(weather)){
            System.out.println(name+"不工作");
        }else if("雾霾".equals(weather)){
            System.out.println(name+"商务工作");
        }else if("阵雨".equals(weather)){
            System.out.println(name+"正常工作");
        }else if("晴天".equals(weather)){
            System.out.println(name+"努力工作");
        }else{
            System.out.println(name+"睡觉");
        }
    }
}
