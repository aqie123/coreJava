package aqie1;

import java.io.*;
import java.util.Arrays;

public class Demo13 {
    public static void main(String[] args) throws IOException {
        Test13 t = new Test13();
        // t.method();
        // t.method2();
        // t.method3();
        //t.method4();
        // t.method5();
        // t.method6();
        // t.method7();
        // t.method8();
        // t.method9();
        t.method10();
    }
}

class Test13{
    // 编码解码
    void method() throws UnsupportedEncodingException {
        String str = "中国";
        // 编码
        byte[] buff = str.getBytes("utf-8");     // 使用平台默认字符集(gbk)编码，结果存储到byte[]数组
        // 三个字节
        System.out.println("utf-8编码值"+ Arrays.toString(buff));

        // 解码
        String result = new String(buff,"utf-8");
        System.out.println(result);
    }

    // 解码练习
    void method2() throws UnsupportedEncodingException {
        String str = "中国";
        // 使用gbk 编码
        byte[] buff = str.getBytes("gbk");
        System.out.println(Arrays.toString(buff));
        // 使用拉丁码表解码
        str = new String(buff,"iso8859-1"); // 这里出现乱码数字不会丢失
        System.out.println(str);
        /* ****解码开始*** */
        // 1.找到四个字符对应数字 iso8859-1 编码
        buff = str.getBytes("iso8859-1");
        // 2.使用gbk解码
        System.out.println(new String(buff,"gbk"));
    }

    // 编码 note
    void method3() throws UnsupportedEncodingException {
        // -2 -1是utf-16的标识位
        String str = "a";
        byte[] buff = str.getBytes("unicode");
        System.out.println(Arrays.toString(buff)); // [-2, -1, 0, 97]
    }

    // 转换流 每次读取一个字节
    void method4() throws IOException {
        // 1.先获取标准输入流
        InputStream in = System.in;
        // read() 每次读取一个字节数据,阻塞性方法
        int content = in.read();
        System.out.println("hello");             // 如果没读取到这行不执行
        System.out.println((char)content);      // 输出控制台输入的
    }

    // 转换流 每次读取一行      从用户输入读取数据
    void method5() throws IOException {
        /*
        // 1.先获取标准输入字节流
        InputStream in = System.in;
        // 字节流转换成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        // 读取一行
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        */
        // 匿名对象实现上面三行
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            if("quit".equals(line)){
                System.exit(0);
            }
            System.out.println(line);
        }
        System.out.println("您输入的数据为");
        bufferedReader.close();
    }

    // 使用字符串getBytes()将字节转换成字符串
    void method6() throws IOException {
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie2.txt";
        // 假定别人传过来就是字符流 (不能使用字符流)
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        String data = "使用字符串getBytes()将字节转换成字符串 向文件写入数据";
        fileOutputStream.write(data.getBytes());        // 需要将字符转换成字节
        fileOutputStream.close();
    }

    //  输出字节流转换成输出字符流(OutputStreamWriter)  向文件写入数据
    void method7() throws IOException {
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie2.txt";
        // 假定别人传过来就是字节流 (不能使用字符流)
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        String data = "输出字节流转换成输出字符流(OutputStreamWriter)  向文件写入数据";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        //写入数据
        outputStreamWriter.write(data);
        //关闭资源
        outputStreamWriter.close();
    }

    // 测试各个码表写入数据大小
    void method8() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie2.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("中国");
        fileWriter.close();
    }

    // 转换流指定码表写入数据
    void method9() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie3.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(fileOutputStream,"gbk");
        outputStreamWriter.write("中国");
        outputStreamWriter.close();
    }

    // 转换流指定码表读取数据
    void method10() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie2.txt";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
        char[] buff = new char[1024];
        int length = 0;
        while((length = inputStreamReader.read(buff)) != -1){
            System.out.println(new String(buff,0,length));
        }
    }
}