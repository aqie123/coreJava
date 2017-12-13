package aqie1;

import java.io.*;

public class FileHandle {

    // 读取文件
    public static void readFile(String fileName){
        FileInputStream fs = null;
        try{
            // 1.找到目标文件
            File file = new File(fileName);

            // 2. 建立数据输入通道
           fs = new FileInputStream(file);

            // 3. 读取数据
            byte[] buff = new byte[1024];       // 类似BufferedInputStream
            int length = 0;     // 记录本次读取的字节个数
            while((length = fs.read(buff)) != -1){
                System.out.println(new String(buff,0,length));
            }
        }catch(IOException e){
            System.out.println("读取文件出错");
            throw new RuntimeException(e);
        }finally {
            try {
                // 4.关闭资源文件 (只关一次，保证代码能执行到).只有打开文件才关闭
                if(fs != null){
                    fs.close();
                    System.out.println("关闭资源成功!");
                }
            }catch (IOException e){
                System.out.println("关闭资源失败...");
                throw new RuntimeException(e);
            }
        }
    }

    // 写入文件
    public static void writeFile(String fileName,boolean append){
        FileOutputStream fileOutputStream = null;
        try{
            // 1.找到目标文件
            File file = new File(fileName);
            // 2. 建立数据输出通道
            fileOutputStream = new FileOutputStream(file,append);
            // 3. 数据写入
            String str = "\r\nhello aqie";
            fileOutputStream.write(str.getBytes());
        }catch(IOException e){
            // 这里异常 后面代码没有必要继续进行
            // 真正异常包装到RuntimeException,然后再抛出
            throw new RuntimeException(e);
        }finally {
            try {
                // 4.关闭资源文件 (只关一次，保证代码能执行到)
                fileOutputStream.close();
                System.out.println("关闭资源成功");
            }catch (IOException e){
                System.out.println("关闭资源失败...");
                throw new RuntimeException(e);
            }
        }
    }

    // 拷贝图片 (字节数组 循环输入输出)
    public static void copyImage(String originImg, String outputImg){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            // 1.找到目标文件
            File file = new File(originImg);
            File outFile = new File(outputImg);
            // 2. 建立数据输入,输出通道
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(outFile);
            // 3. 建立缓冲字节数组,边读边写
            byte[] buff = new byte[1024];
            int length = 0;         // 记录每次读取的字节个数
            // 4. 字节数组边读边写
            while((length = fileInputStream.read(buff)) != -1){
                fileOutputStream.write(buff,0,length);
            }
        }catch (IOException e){
            System.out.println("拷贝图片出错");
            throw new RuntimeException(e);
        }finally {
            try {
                // 5.关闭资源文件 (只关一次，保证代码能执行到)
                if(fileInputStream != null){
                    fileInputStream.close();
                    System.out.println("关闭输入流资源成功");
                }
            }catch (IOException e){
                System.out.println("关闭输入流资源失败...");
                throw new RuntimeException(e);
            }finally {
                try {
                    if(fileOutputStream != null){
                        fileOutputStream.close();
                        System.out.println("关闭输出流资源成功");
                    }
                }catch (IOException e){
                    System.out.println("关闭输出流资源失败...");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 缓冲输入字节流读取文件 (推荐)
    public static void ReadBuffFile(String fileName){
        BufferedInputStream bufferedInputStream = null;
        try{
            // 1.找到目标文件
            File file = new File(fileName);
            // 2.建立文件与程序输入通道
            FileInputStream fileInputStream = new FileInputStream(file);
            // 3.建立文件缓冲输入字节流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            // 4. 读取文件内容
            // 读取英文 一个字节一读
            int content = 0;
            while((content = bufferedInputStream.read()) != -1){
                System.out.print((char)content);
            }

            // 读取中文 三个字节一读
            /*
            byte[] buff = new byte[3];
            int length = 0;
            while((length = bufferedInputStream.read(buff)) != -1){
                System.out.print(new String(buff,0,length));
            }
            */

            /*  效率低
            while((content = fileInputStream.read()) != -1){
                System.out.print((char)content);
            }
            */

        }catch(IOException e){
            System.out.println("\n\r文件读取失败");
            throw new RuntimeException(e);
        }finally {
            // 5.关闭资源
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                    System.out.println("\n\r文件关闭成功");
                }
            }catch(IOException e){
                System.out.println("\n\r文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 缓冲输出字节流 写入文件 (推荐)
    public static void WriteBuffFile(String fileName,String data,boolean append){
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 1. 找到目标文件
            File file = new File(fileName);
            // 2. 建立数据的输出通道
            FileOutputStream fileOutputStream = new FileOutputStream(file,append);
            // 3. 建立缓冲数据字节流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            bufferedOutputStream.write(data.getBytes());
        }catch (IOException e){
            System.out.println("读取文件失败");
            throw new RuntimeException(e);
        }finally {
            try {
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                    System.out.println("文件关闭成功");
                }
            }catch (IOException e){
                System.out.println("文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 缓冲输入输出字节流拷贝图片 (推荐)
    public static void copyBuffImage(String originImg, String outputImg){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try{
            // 1.找到目标文件
            File file = new File(originImg);
            File outFile = new File(outputImg);
            // 2. 建立数据输入,输出通道
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            // 3. 建立字节输入输出缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // 4. 边读边写
            int content = 0;
            while((content = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(content);
            }
        }catch (IOException e){
            System.out.println("拷贝图片出错");
            throw new RuntimeException(e);
        }finally {
            try {
                // 5.关闭资源文件 (只关一次，保证代码能执行到).
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                    System.out.println("关闭字节输入缓冲流资源成功");
                }
            }catch (IOException e){
                System.out.println("关闭输入流资源失败...");
                throw new RuntimeException(e);
            }finally {
                try {
                    if(bufferedOutputStream != null){
                        bufferedOutputStream.close();
                        System.out.println("关闭字节输出缓冲流资源成功");
                    }
                }catch (IOException e){
                    System.out.println("关闭输出流资源失败...");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 字符流读取文件 方式一 每次只会读取一个字符数据
    public static void ReaderFile(String fileName){
        FileReader fileReader = null;
        try{
            // 1.找到目标文件
            File file = new File(fileName);
            // 2.建立数据输入通道
            fileReader = new FileReader(file);

            // 3. 读取文件内容
            int content = 0;
            // 每次读取一个字符数据
            while((content = fileReader.read()) != -1){ // 读到文件末尾返回-1
                System.out.print((char)content);
            }
        }catch(IOException e){
            System.out.println("\n\r文件读取失败");
            throw new RuntimeException(e);
        }finally {
            // 5.关闭资源
            try {
                if(fileReader != null){
                    fileReader.close();
                    System.out.println("\n文件关闭成功");
                }
            }catch(IOException e){
                System.out.println("\n\r文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 字符流读取文件 方式二 使用缓冲字符数组读取文件的数据(推荐)
    public static void ReaderBuffFile(String fileName){
        FileReader fileReader = null;
        try{
            // 1.找到目标文件.
            File file = new File(fileName);
            // 2.建立数据输入通道
            fileReader = new FileReader(file);
            // 3.建立缓冲字符数组,读取文件数据
            char[] buff = new char[1024];
            int length = 0;
            // 读取到字符存储到字符数组中,返回本次读取到字符个数
            while((length = fileReader.read(buff)) != -1){ // 读到文件末尾返回-1
                System.out.print(new String(buff,0,length));
            }
        }catch(IOException e){
            System.out.println("\n\r文件读取失败");
            throw new RuntimeException(e);
        }finally {
            // 5.关闭资源
            try {
                if(fileReader != null){
                    fileReader.close();
                    System.out.println("\n字符流资源关闭成功");
                }
            }catch(IOException e){
                System.out.println("\n\r文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 字符流写入数据
    public static void WriterFile(String fileName,String data,boolean append){
        FileWriter fileWriter = null;
        try {
            // 1. 找到目标文件
            File file = new File(fileName);
            // 2. 建立数据的输出通道
            fileWriter = new FileWriter(file,append);
            // 3. 写入数据
            fileWriter.write(data);
        }catch (IOException e){
            System.out.println("读取文件失败");
            throw new RuntimeException(e);
        }finally {
            try {
                if(fileWriter != null){
                    fileWriter.close();
                    System.out.println("\n字符流资源关闭成功");
                }
            }catch (IOException e){
                System.out.println("文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 字符流拷贝图片     字符 character  字节byte
    public static void characterImage(String originImg, String outputImg){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try{
            // 1.找到目标文件
            File file = new File(originImg);
            File outFile = new File(outputImg);
            // 2. 建立字符流数据输入,输出通道
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(outFile);
            // 4. 建立缓冲字符数组 边读边写
            char[] buff = new char[1024];
            int length = 0;
            while((length = fileReader.read(buff)) != -1){
                fileWriter.write(buff,0,length);
            }
        }catch (IOException e){
            System.out.println("拷贝图片出错");
            throw new RuntimeException(e);
        }finally {
            try {
                // 5.关闭资源文件 (只关一次，保证代码能执行到).
                if(fileReader != null){
                    fileReader.close();
                    System.out.println("关闭字符输入缓冲流资源成功");
                }
            }catch (IOException e){
                System.out.println("关闭字符输入流资源失败...");
                throw new RuntimeException(e);
            }finally {
                try {
                    if(fileWriter != null){
                        fileWriter.close();
                        System.out.println("关闭字节输出缓冲流资源成功");
                    }
                }catch (IOException e){
                    System.out.println("关闭输出流资源失败");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 缓冲输入字符流 分行读取文件
    public static void bufferedReader(String fileName){
        BufferedReader bufferedReader = null;
        // BufferedLineNum bufferedReader = null;
        // BufferedSemi bufferedReader = null;
        try{
            // 1.找到目标文件.
            File file = new File(fileName);
            // 2.建立数据输入通道
            FileReader fileReader = new FileReader(file);
            // 3.建立缓冲输入字符流
            bufferedReader = new BufferedReader(fileReader);
            // LineNum bufferedReader = new LineNum(bufferedReader2);
            // bufferedReader = new BufferedLineNum(fileReader);
            // bufferedReader = new BufferedSemi(fileReader);
           // 4, 读取文件内容 分行读取
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("\n\r文件读取失败");
            throw new RuntimeException(e);
        }finally {
            // 5.关闭资源
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                    System.out.println("\r\n缓冲字符流资源关闭成功");
                }
            }catch(IOException e){
                System.out.println("\n文件关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

    // 自己编写分行读取函数
    public static String myReadLine(FileReader fileReader){
        try {
            StringBuilder sb = new StringBuilder();
            int content  =0;
            while((content = fileReader.read()) != -1){
                if(content == '\r'){
                    continue;
                }else if(content == '\n'){
                    return sb.toString();
                }else{
                    // 正常字符
                    sb.append((char)content);
                }
            }
        }catch(IOException e){
            System.out.println("读取文件异常");
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void bufferedWriter(String fileName,String data,boolean append){
        BufferedWriter bufferedWriter = null;
        try {
            // 1. 找到目标文件
            File file = new File(fileName);
            // 2. 建立数据的输出通道
            FileWriter fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            // 3. 写入数据
            bufferedWriter.newLine(); // bufferedWriter.write("\r\n");
            bufferedWriter.write(data);
        }catch (IOException e){
            System.out.println("读取文件失败");
            throw new RuntimeException(e);
        }finally {
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                    System.out.println("\n缓冲输入字符流资源关闭成功");
                }
            }catch (IOException e){
                System.out.println("缓冲输入字符流资源关闭失败");
                throw new RuntimeException(e);
            }
        }
    }

}
