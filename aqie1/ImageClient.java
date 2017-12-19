package aqie1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ImageClient {
    public static void main(String[] args) throws IOException {
        // 1.建立tcp客户端
        Socket socket = new Socket(InetAddress.getByName("192.168.0.135"),9090);
        // 2. 获取socket输入流
        InputStream inputStream = socket.getInputStream();
        // 3.建立文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\coreJava\\coreJava\\static\\output\\images\\out.jpg");
        // 4. 边读边写
        byte[] buff = new byte[1024];
        int length = 0;
        while((length = inputStream.read(buff)) != -1){
            fileOutputStream.write(buff,0,length);
        }
        // 关闭资源
        fileOutputStream.close();
        socket.close();
    }
}
