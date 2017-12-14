package aqie1;
import aqie.Person;

import java.io.*;

public class Demo10 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test10 t = new Test10();
        //t.method();
        t.method2();
    }
}

class Test10{
    // 对象写入到硬盘,对象的序列化
    void method() throws IOException{
        Person person = new Person(1,"aqie");
        File file = new File("D:\\coreJava\\coreJava\\static\\output\\objectFile\\user.txt");
        // 1.创建数据输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        // 2.创建对象的输出流对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // 3. 对象写入到输出流中
        objectOutputStream.writeObject(person);
        // 4. 关闭资源
        objectOutputStream.close();
    }

    // 对象反序列化,读取硬盘中对象
    void method2() throws IOException, ClassNotFoundException {
        File file = new File("D:\\coreJava\\coreJava\\static\\output\\objectFile\\user.txt");
        // 1. 创建数据输出流对象
        FileInputStream fileInputStream = new FileInputStream(file);
        // 2.创建对象的输入流对象
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // 3. 读取对象数据
        Person p  = (Person)objectInputStream.readObject();
        // 4. 输出对象
        System.out.println(p);

    }
}