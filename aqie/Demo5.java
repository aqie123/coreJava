package aqie;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;

// Runtime 类
public class Demo5 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        /*
        try{
            test3.method();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        */
        test3.method2();
        //test3.devision();
    }
}

class Test3{
    void method() throws IOException,InterruptedException{
        Runtime runtime = Runtime.getRuntime();
        // 启动进程
        Process p = runtime.exec("D:\\Users\\Administrator\\AppData\\Local\\Youdao\\Dict\\YoudaoDict.exe");
        // 程序暂停三秒钟
        Thread.sleep(3000);
        // 杀死进程
        p.destroy();
    }

    void method2(){
        Runtime runtime = Runtime.getRuntime();
        // 返回字节
        System.out.println("java虚拟机使用的最大内存 "+runtime.maxMemory());
        System.out.println("java虚拟机内存总量 "+runtime.totalMemory());
        System.out.println("java虚拟机当前空闲内存 "+runtime.freeMemory());
    }

    void devision(){
        int num = 1660944384;
        System.out.println(num/1024/1024/1024);
    }
}
