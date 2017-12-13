package aqie1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Demo6 {
    public static void main(String[] args) {
        Test6 t = new Test6();
        t.method();
    }
}

class Test6{
    // BufferedReader 功能
    void method(){

    }
}

// 带行号的缓冲类
class BufferedLineNum extends BufferedReader{
    int count = 0;
    public BufferedLineNum(Reader in){
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        // 调用父类方法
        String line = super.readLine();
        if(line == null){
            return null;
        }
        line = count + ":" + line;
        count++;
        return line;
    }
}

// 带分号缓冲类
class BufferedSemi extends BufferedReader{
    public BufferedSemi(Reader in){
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if(line == null){
            return null;
        }
        line = line + ";";
        return line;
    }
}