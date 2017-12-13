package aqie1;
import aqie1.FileHandle;

import java.io.*;

public class Demo5 {
    public static void main(String[] args) {
        Test5 t = new Test5();
        t.method();
    }
}

class Test5{
    // FileHandle 类函数使用
    void method(){
        // 写入文件
        String fileName = "D:\\coreJava\\coreJava\\static\\g.txt";
        // FileHandle.writeFile(fileName,false);

        // 读取文件
        // FileHandle.readFile(fileName);

        // 拷贝图片
        String originImg = "D:\\coreJava\\coreJava\\static\\images\\timg.jpg";
        String outputImg = "D:\\coreJava\\coreJava\\static\\images\\timg2.jpg";
        // FileHandle.copyImage(originImg,outputImg);

        // BufferedInputStream 读取文件
        fileName = "D:\\coreJava\\coreJava\\static\\f.txt";
        // FileHandle.ReadBuffFile(fileName);

        // BufferedOutputStream 写入文件
        // FileHandle.WriteBuffFile(fileName,"啊切",true);

        // 缓冲输入输出字节流 拷贝图片
        // FileHandle.copyBuffImage(originImg,outputImg);

        // 字符流读取文件
        // FileHandle.ReaderFile(fileName);

        // 缓冲字符数组读取文件
        // FileHandle.ReaderBuffFile(fileName);

        // 字符流写入数据
        // FileHandle.WriterFile(fileName,"字符流写入数据",false);

        // 字符流拷贝图片  (会出bug 变小)
        String originText = "D:\\coreJava\\coreJava\\static\\f.txt";
        String outputText = "D:\\coreJava\\coreJava\\static\\images\\f.txt";
        // FileHandle.characterImage(originText,outputText);

        // 缓冲输入字符流 分行读取文件
        // FileHandle.bufferedReader(fileName);

        // 缓冲输出字符流 写入数据
        FileHandle.bufferedWriter(fileName,"努力 奋斗 aqie",true);
    }

}