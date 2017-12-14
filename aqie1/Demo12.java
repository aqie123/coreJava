package aqie1;

import java.io.*;

public class Demo12 {
    public static void main(String[] args) throws IOException{
        Test12 t = new Test12();
        // t.method();
        // t.method2();
        // t.method3();
        t.method4();
    }
}

class Test12{
    // 向一个文件写入 int 类型数据 97 (字符流，字节流)
    void method() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie.txt";
        File file = new File(fileName);

        // 创建字节流数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //fileOutputStream.write(97);
        fileOutputStream.write("97".getBytes());
        fileOutputStream.close();

        // 创建字符流数据输出通道
        /*
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("97");
        fileWriter.close();
        */
    }

    // 打印流写入数据
    void method2()throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie.txt";
        File file = new File(fileName);
        PrintStream printStream = new PrintStream(file);
        // 打印数据
        printStream.println(97);
        printStream.println(true);
        printStream.println(3.14);
        printStream.close();
    }

    // 打印日志 ,并记录多个异常
    void method3() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\logs\\1.log";
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        PrintStream printStream = new PrintStream(fileOutputStream);
        try{
            /*String str = null;
            System.out.println(str.length());*/
            int num = 1/0;
        }catch (Exception e){
            e.printStackTrace(printStream);
        }
    }

    // 修改标准输出流
    void method4() throws FileNotFoundException {
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie.txt";
        PrintStream printStream = new PrintStream(fileName);
        System.setOut(printStream);
        System.out.println("修改标准输出流");
    }
}