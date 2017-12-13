package aqie1;

import java.io.*;

public class Demo7 {
    public static void main(String[] args) throws IOException{
        Test7 t = new Test7();
        t.method();
    }
}

class Test7{
    void method() throws IOException{
        String fileName = "D:\\coreJava\\coreJava\\static\\g.txt";
        bufferedReader(fileName);
    }

    // 缓冲输入字符流读取文件数据
    public static void bufferedReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // 创建带行号的缓冲字符流对象
        Quto quto = new Quto(bufferedReader);
        LineNum lineNum = new LineNum(quto);

        String line = null;
        while((line = lineNum.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}

// 带行号的缓冲输入字符流
class LineNum extends BufferedReader{
    BufferedReader bufferedReader;
    int count = 1;
    public LineNum(BufferedReader bufferedReader){
        super(bufferedReader);      // 父类没有无参构造函数
        this.bufferedReader = bufferedReader;
    }

    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line == null){
            return null;
        }
        line = count + ":" + line;
        count++;
        return line;
    }
}

// 带双引号的缓冲输入字符流
class Quto extends BufferedReader{
    BufferedReader bufferedReader;
    public Quto(BufferedReader bufferedReader){
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }

    public String readLine() throws IOException {
        String line = bufferedReader.readLine();
        if(line == null){
            return null;
        }
        line = "\"" + line + "\"";
        return line;
    }
}

