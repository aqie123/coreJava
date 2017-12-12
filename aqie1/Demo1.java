package aqie1;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        // t.method();
        try{
            t.method2();
        }catch (IOException e){

        }

        // t.method3();
        // t.method4();
        // t.method5();
        t.method6();

    }
}

class Test1{
    // exists
    void method(){
        // 绝对路径
        File file = new File("D:\\coreJava\\coreJava\\static\\a.txt");
        System.out.println(file.exists());

        // 相对路径
        // D:\coreJava\coreJava\aqie1\Demo1.java  D:\coreJava\coreJava\static\a.txt
        File file4 = new File("static/a.txt");
        System.out.println(file4.exists());
        System.out.println(file.equals(file4));
        System.out.println(file.getAbsoluteFile());
        System.out.println(file4.getAbsoluteFile());

        File file2 = new File("D:\\coreJava\\coreJava\\static\\","b.md");
        System.out.println(file2.exists());

        File parentFile = new File("D:\\coreJava\\coreJava\\static\\");
        File file3 = new File(parentFile,"b.md");
        System.out.println(file3.exists());
        System.out.println(file3.separator);

        File file5 = new File(".");
        System.out.println("当前路径 " + file5.getAbsolutePath());
    }

    void method2() throws IOException{
        File file = new File("D:/coreJava/coreJava/static/b.txt");
        File file3 = new File("D:/coreJava/coreJava/static/c.txt");
        File file4 = new File("D:/coreJava/coreJava/static/test/c.txt");
        File file2 = new File("D:/coreJava/coreJava/static/test");
        // 非 RuntimeException子类
        file.createNewFile();   // 创建文件
        file3.renameTo(file4);   // 重命名   或剪切

        file2.mkdir();          // 创建目录
        file4.delete();         // 删除文件
    }

    // 获取
    void method3(){
        File file = new File("D:/coreJava/coreJava/static/b.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
    }

    // 文件夹操作
    void method4(){
        // 列出所有盘符
        File[] files = File.listRoots();
        for(File file : files){
            System.out.print(file);
        }

        // 列出目录下所有文件和文件夹
        File file = new File("D:/coreJava/coreJava/static");
        String[] filesName = file.list();
        for(String fileName : filesName){
            System.out.print(fileName);
        }

        // 返回当前目录下所有子文件和子目录 对象
        File[] fileObjects = file.listFiles();
        for(File fileObject : fileObjects){
            System.out.println(fileObject.getName());
        }
    }

    // 返回一个目录下面所有java文件
    void method5(){
        File file = new File("D:\\coreJava\\coreJava\\OO2\\src");
        File[] fileObjects = file.listFiles();
        for (File fileObject : fileObjects
             ) {
            String fileName = fileObject.getName();
            String postfix = fileName.substring(fileName.lastIndexOf(".")+1);
            // 正则 fileName.matches(".+\\.java")
            if("java".equals(postfix)){
                System.out.println(fileName);
            }
        }
    }

    // 列出指定目录所有子文件名 和子目录名 分开列出
    void method6(){
        File file = new File("D:\\coreJava\\coreJava\\static");
        File[] fileObjects = file.listFiles();
        for (File fileObject:fileObjects
             ) {
            if(fileObject.isDirectory()){
                System.out.println(fileObject.getName());
            }
        }

        for (File fileObject:fileObjects
                ) {
            if(!fileObject.isDirectory()){
                System.out.println(fileObject.getName());
            }
        }
    }
}

class FilenameFilter{

}
