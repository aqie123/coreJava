package aqie1;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Demo11 {
    public static void main(String[] args) throws IOException{
        Test11 t = new Test11();
        // t.method();
        // Test11.createProperties();
        // Test11.readProperties();
        Test11.runSoftware();
    }
}

class Test11{
    // 创建配置文件
    void method() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\output\\configFile\\config.cfg";
        Properties properties = new Properties();
        // 不能传入非字符串数据
        properties.setProperty("SitName","dwy");
        properties.setProperty("develop","true");
        properties.setProperty("name","啊切");
        properties.setProperty("tryTime","3");

        // 字节流
        // FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        // 有中文使用字符流
        FileWriter fileWriter = new FileWriter(fileName);
        // 利用Properties生成配置文件
        properties.store(fileWriter,"comments");
        fileWriter.close();
    }

    // 温习遍历
    public static void createProperties(){
        Properties properties = new Properties();
        properties.setProperty("SitName","dwy");
        properties.setProperty("develop","true");
        properties.setProperty("name","aqie");

        // 遍历
        Set<Map.Entry<Object,Object>> set = properties.entrySet();
        for(Map.Entry<Object,Object> entry : set){
            System.out.println("键： "+ entry.getKey() + "值 " + entry.getValue());
        }
    }

    // 读取配置文件
    public static void readProperties() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\output\\configFile\\config.cfg";
        Properties properties = new Properties();

        // 建立输入字符流对象
        FileReader fileReader = new FileReader(fileName);
        properties.load(fileReader);

        // 遍历元素
        Set<Map.Entry<Object,Object>> set = properties.entrySet();
        for(Map.Entry<Object,Object> entry : set){
            System.out.println("键： "+ entry.getKey() + "值 " + entry.getValue());
        }

        // 修改配置中值
        properties.setProperty("name","aqie");
        // 重新生成配置文件
        properties.store(new FileWriter(fileName),"修改配置");

    }

    // 软件限制试用次数
    public static void runSoftware() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\output\\configFile\\config.cfg";
        // 1.启动
        System.out.println("欢迎试用");
        // 检查是否存在配置文件
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        // 定义变量记录运行次数
        int runtime = 0;
        // 2.读取配置文件,并修改试用次数

        Properties properties = new Properties();

        // 建立输入字符流对象
        FileReader fileReader = new FileReader(fileName);
        properties.load(fileReader);
        // 如果配置文件定义运行次数，则使用配置文件中的
        String num = (String) properties.getProperty("num");
        if(num != null){
            // 字符串转换整形
            runtime = Integer.parseInt(num);
        }

        // 3.如果试用次数为3，则退出
        if(runtime == 3){
            System.out.println("使用次数用光,请购买正版");
            System.exit(0);
        }
        runtime++;
        System.out.println("您已经运行了" + runtime + "次,还剩余"+(3-runtime)+"次");
        // 重新生成配置文件
        properties.setProperty("num",runtime + "");      // 数字转化字符串
        properties.store(new FileWriter(fileName),"add use time");

    }
}