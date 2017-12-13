package aqie1;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) {
        Test4 t = new Test4();
        try{
            t.method();
        }catch(IOException e){}
        try{
            t.method2();
        }catch(IOException e){}
        try{
            t.method3();
        }catch(IOException e){}
        try{
            t.method4();
        }catch(IOException e){}

    }
}

class Test4{
    // 方式一： static/d.txt  写入数据,每次只能写一个字节数据
    void method() throws IOException{
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\d.txt");
        // 2. 建立数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        // 3. 将数据写出
        fileOutputStream.write('a');
        fileOutputStream.write('q');
        fileOutputStream.write('i');
        fileOutputStream.write('e');
        // 00000000-0000000-00000001-10000000 384
        fileOutputStream.write(384);
        // 4.关闭资源文件
        fileOutputStream.close();
    }

    // 方式二： static/e.txt  数据转成字节数组再写出
    void method2() throws IOException {
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\e.txt");
        // 2. 建立数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        // 3. 数据写入
        String str = "\r\nhello aqie";
        byte[] buff;
        buff = str.getBytes();
        fileOutputStream.write(buff);
        // 4.关闭资源文件
        fileOutputStream.close();

    }

    // 方式三：static/f.txt  字节数组指定长度写入
    void method3() throws IOException{
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\f.txt");
        // 2. 建立数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        // 3.数据写入
        String data = "abcd";
        byte[] buff = data.getBytes(); // 97 98 99 100
        fileOutputStream.write(buff,0,2);
        // 4,关闭
        fileOutputStream.close();
    }

    // 图片拷贝
    void method4() throws IOException{
        // 1.找到目标文件
        File file = new File("D:\\coreJava\\coreJava\\static\\images\\timg.jpg");
        File directory = new File("D:\\coreJava\\coreJava\\static\\output");
        directory.mkdir();
        File outFile = new File(directory,"timg2.jpg");
        // 2. 建立数据输入通道
        FileInputStream fileInputStream = new FileInputStream(file);
        // 3. 建立数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        // 4. 建立缓冲字节数组,边读边写
        byte[] buff = new byte[1024];
        // 记录每次读取的字节个数
        int length = 0;
        // 5. 字节数组边读边写
        while((length = fileInputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }
        // 6. 关闭资源文件
        fileOutputStream.close();
        fileInputStream.close();

    }
}