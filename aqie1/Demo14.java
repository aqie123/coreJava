package aqie1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 递归
public class Demo14 {
    public static void main(String[] args) throws IOException{
        Test14 t = new Test14();
        // t.method(5);
        //System.out.println(Test14.method2(6));

        String dir = "D:\\coreJava\\coreJava\\static\\test";
        String dir2 = "D:\\coreJava\\coreJava\\static\\deleteFile";
        File directory = new File(dir);
        File directory2 = new File(dir2);
        // t.method3(directory);
        // t.method4(directory," ");
        // t.method5(directory,"|--");
        t.method6(directory2);
    }
}

class Test14{
    // calculate 5 的factorial
    void method( int num){
        int sum = 1;
        while(num >0){
            sum *= num;
            num--;
        }
        System.out.println(sum);
    }

    // calculate 5
    public static int method2(int num){
        if (num == 1){
            return num;
        }
        return num*method2(num - 1);
    }

    // 列出一个文件夹中所有子孙文件与文件夹,并写入文件
    public void method3(File directory) throws IOException{
       String fileName = "D:\\coreJava\\coreJava\\static\\aqie3.txt";
        // 字符输入流
        FileWriter fileWriter = new FileWriter(fileName,true);

       // 获取文件夹下所有文件及文件夹 对象
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isDirectory()){
                fileWriter.write("\n 文件夹"+file.getName());
                method3(file);
            }else if(file.isFile()){
                fileWriter.write("\n 文件 "+file.getName());
            }
        }
        fileWriter.close();
    }

    // 列出指定目录所有子孙文件与子孙目录名,名称前面有相应空格
    // 第一级前面一个，第二级前面两个
    public void method4(File directory,String space) throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie4.txt";
        // 字符输入流
        FileWriter fileWriter = new FileWriter(fileName,true);
        // 获取文件夹下所有文件及文件夹 对象
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isFile()){
                fileWriter.write("\n"+space+file.getName());
                System.out.println("\n"+space+file.getName());
            }else if(file.isDirectory()){
                fileWriter.write("\n"+space+file.getName());
                System.out.println("\n"+space+file.getName());
                method4(file,space+"\t");
            }
        }
        fileWriter.close();
    }

    // 树状结构展示 文件夹中子孙目录
    public void method5(File directory,String prefix) throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\aqie5.txt";
        // 字符输入流
        FileWriter fileWriter = new FileWriter(fileName,true);
        // 获取文件夹下所有文件及文件夹 对象
        File[] files = directory.listFiles();
        for (File file : files){
            if(file.isFile()){
                System.out.println(prefix+file.getName());
            }else if(file.isDirectory()){
                System.out.println(prefix+file.getName());
                method5(file,"|  "+prefix);
            }
        }
        fileWriter.close();
    }

    // 删除一个非空文件夹,文件夹有子孙目录
    public void method6(File directory) throws IOException{
        // 获取文件夹下所有文件及文件夹 对象
        File[] files = directory.listFiles();
        for(File file:files){
            if(file.isFile()){
                file.delete();
            }else if(file.isDirectory()){
                String[] dirFiles = file.list();
                if(dirFiles.length == 0){
                    file.delete();
                }else{
                    method6(file);
                }
            }
        }
        directory.delete();
    }

    // todo 剪切一个非空文件夹
    public void method7(File origin,File target) throws IOException{

    }
}