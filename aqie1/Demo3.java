package aqie1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        /*
        try{
            t.method();
        }catch (IOException e){}
        */

        try{
            t.method2();
        }catch (IOException e){}

        try{
            t.method3();
        }catch (IOException e){}


    }
}

class Test3{
    // 输入字节流 每次只能读取一个字节 (效率低)
    void method() throws IOException{
        long startTime = System.currentTimeMillis();
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\images\\timg.jpg");

        // 2. 建立数据输入通道
        FileInputStream fs = new FileInputStream(file);

        // 3.读取文件数据,返回读取的字节数据,每次只会读取一个字节
        int content = 0;
        while((content = fs.read()) != -1){
            System.out.print((char)content);      // 类型强转
        }

        // 4. 关闭资源  释放资源文件
        fs.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);  // 1276
    }

    // 使用(缓冲数组) 字节数组 (无法完整读取一个文件数据)
    void method2() throws IOException{
        long startTime = System.currentTimeMillis();
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\b.txt");
        // 2. 建立数据输入通道
        FileInputStream fs = new FileInputStream(file);
        // 3.创建字节数组，读取文件数据
        byte[] buf = new byte[1024];        // 一般越大效率越高
        int length = fs.read(buf); // read传入字节数组,
        // System.out.println(length);   输出读取文件长度
        System.out.println(new String(buf,0,length));
        // 数据存储到字节数组中，返回本次读取多少个字节数据存储到字节数组中
        // 4. 关闭资源  释放资源文件
        fs.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    // 循环配合缓冲数组读取
    void method3() throws IOException{
        long startTime = System.currentTimeMillis();
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\b.txt");

        // 2. 建立数据输入通道
        FileInputStream fs = new FileInputStream(file);

        // 3. 读取数据
        byte[] buff = new byte[1024];
        int length = 0;     // 记录本次读取的字节个数
        while((length = fs.read(buff)) != -1){
            System.out.println(new String(buff,0,length));
        }

        // 4. 关闭资源  释放资源文件
        fs.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}