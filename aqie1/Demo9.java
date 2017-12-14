package aqie1;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Demo9 {
    public static void main(String[] args) throws IOException{
        Test9 t = new Test9();
        // t.method();
        // t.method2();
        // t.method3();
        // t.method4();
        // t.method5();
        t.method6();
    }
}

class Test9{
    // 合并两个文件到一个文件
    void method() throws IOException{
        File file = new File("D:\\coreJava\\coreJava\\static\\test\\note1.txt");
        File file2 = new File("D:\\coreJava\\coreJava\\static\\test\\note2.txt");
        File file3 = new File("D:\\coreJava\\coreJava\\static\\test\\note.txt");

        // 建立字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        // 建立数据输入字节流
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        // 输入流对象存储到集合中
        ArrayList<FileInputStream> list  = new ArrayList<>();
        list.add(fileInputStream);
        list.add(fileInputStream2);


        // 边读边写
        byte[] buff = new byte[1024];
        int length = 0;
        for(int i = 0; i<list.size();i++){
            FileInputStream inputStream = list.get(i);
            while((length = inputStream.read(buff)) != -1){
                fileOutputStream.write(buff,0,length);
            }
            // 每读完一个就关闭资源
            inputStream.close();
        }
        fileOutputStream.close();

    }

    // SequenceInputStream 合并 两个文件
    void method2() throws IOException{
        File file = new File("D:\\coreJava\\coreJava\\static\\test\\note1.txt");
        File file2 = new File("D:\\coreJava\\coreJava\\static\\test\\note2.txt");
        File file3 = new File("D:\\coreJava\\coreJava\\static\\test\\note.txt");

        // 建立字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        // 建立数据输入字节流
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);

        // 创建序列流
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream,fileInputStream2);

        // 边读边写
        byte[] buff = new byte[1024];
        int length = 0;
        while((length = sequenceInputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }
        // 关闭资源
        sequenceInputStream.close();
        fileOutputStream.close();

    }

    // sequenceInputStream  Vector 合并 两个文件
    void method3() throws IOException{
        File file = new File("D:\\coreJava\\coreJava\\static\\test\\note1.txt");
        File file2 = new File("D:\\coreJava\\coreJava\\static\\test\\note2.txt");
        File file3 = new File("D:\\coreJava\\coreJava\\static\\test\\note3.txt");
        File output = new File("D:\\coreJava\\coreJava\\static\\test\\note.txt");

        // 1. 建立字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(output);
        // 2. 建立数据输入字节流
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        // 3. 通过Vector得到迭代器
        Vector<FileInputStream> vector = new Vector<>();
        vector.add(fileInputStream);
        vector.add(fileInputStream2);
        vector.add(fileInputStream3);
        Enumeration<FileInputStream> e = vector.elements();

        // 4. 创建序列流
        SequenceInputStream sequenceInputStream = new SequenceInputStream(e);

        // 5. 创建缓冲数组 边读边写
        byte[] buff = new byte[1024];
        int length = 0;
        while((length = sequenceInputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }

        sequenceInputStream.close();
        fileOutputStream.close();
    }

    // 通过 ArrayList 得到迭代器   实现序列流合并文件
    void method4() throws IOException{
        File file = new File("D:\\coreJava\\coreJava\\static\\test\\note1.txt");
        File file2 = new File("D:\\coreJava\\coreJava\\static\\test\\note2.txt");
        File file3 = new File("D:\\coreJava\\coreJava\\static\\test\\note3.txt");
        File output = new File("D:\\coreJava\\coreJava\\static\\test\\note.txt");

        // 1. 建立字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(output);
        // 2. 建立数据输入字节流
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        // 3.通过ArrayList  得到迭代器
        ArrayList<FileInputStream> list = new ArrayList<>();
        list.add(fileInputStream);
        list.add(fileInputStream2);
        list.add(fileInputStream3);
        Iterator<FileInputStream> it = list.iterator();

        // 4. 创建序列流对象
        SequenceInputStream sequenceInputStream = new SequenceInputStream(new Enumeration<InputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public InputStream nextElement() {
                return it.next();
            }
        });

        // 5. 创建缓冲数组 边读边写
        byte[] buff = new byte[1024];
        int length = 0;
        while((length = sequenceInputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }

        sequenceInputStream.close();
        fileOutputStream.close();
    }

    // 把一份MP3切成n份，每份一兆
    void method5() throws IOException{
        File file = new File("D:\\coreJava\\coreJava\\static\\music\\Neru - ハウトゥー世界征服.mp3");
        // 读取文件的输入字节流
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buff = new byte[1024*1024];
        int length = 0;
        int count = 1;
        while((length = fileInputStream.read(buff)) != -1){
            // 每读取一次则生成一份文件
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\coreJava\\coreJava\\static\\music\\partMusic\\part" +count+".mp3");
            fileOutputStream.write(buff,0,length);
            count++;

            // 关闭资源
            fileOutputStream.close();
        }
        // 关闭资源
        fileInputStream.close();
    }

    // 合并 MP3文件
    void method6() throws IOException{
        File dir = new File("D:\\coreJava\\coreJava\\static\\music\\partMusic");
        // 1.获取文件夹中所有子文件
        File[] files = dir.listFiles();
        // 2.创建Vector对象存储 FileInputStream 对象
        Vector<FileInputStream> vector = new Vector<>();
        for (int i =0; i< files.length;i++){
            if(files[i].getName().endsWith(".mp3")){
                vector.add(new FileInputStream(files[i]));
            }
        }
        // 3.创建序列流对象
        SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
        // 4.创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\coreJava\\coreJava\\static\\music\\mergeMusic\\世界征服.mp3");
        // 5. 边读边写
        byte[] bytes = new byte[1024*1024];
        int length = 0;
        while((length = sequenceInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,length);
        }
        // 6. 关闭资源
        fileOutputStream.close();
        sequenceInputStream.close();
    }
}