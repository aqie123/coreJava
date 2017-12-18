package aqie1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo22 {
    public static void main(String[] args) throws IOException {
        Test22 t = new Test22();
        t.method();
    }
}

class Test22{

    // Tcp通讯协议
    void method() throws IOException {
        // 1.建立TCP的客户端服务
        Socket socket = new Socket(InetAddress.getLocalHost(),9090);
        // 2. 准备数据,获取对应的流通道
        String data = "this is my first tcp message";
        OutputStream outputStream = socket.getOutputStream();
        // 3. 数据写出
        outputStream.write(data.getBytes());

        // 4.客户端接收服务端回送数据
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int length = inputStream.read(buff);
        System.out.println("client receive data: "+new String(buff,0,length));


        // 5.关闭资源
        // outputStream.close();
        socket.close();
    }
}