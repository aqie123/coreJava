package aqie1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpReceive {
    public static void main(String[] args) throws IOException {
        // 1. 建立tcp服务端
        ServerSocket serverSocket = new ServerSocket(9090);
        // 2. 建立缓冲数组，获取输入流对象
        Socket socket = serverSocket.accept();      // 阻塞性方法,无连接时一直等待
        // 3. 获取socket流通道
        InputStream inputStream = socket.getInputStream();
        // 4. 输入通道读取数据
        byte[] buff = new byte[1024];
        int length = inputStream.read(buff);
        System.out.println("服务端接收到数据 " + new String(buff,0,length));

        // 服务端回送数据到客户端

        // 获取socket输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("receive data".getBytes());

        //5.关闭资源
        serverSocket.close();


    }
}
