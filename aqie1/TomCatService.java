package aqie1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TomCatService extends Thread{
    Socket socket;
    public TomCatService(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 3. 获取socket输出流通道
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello browser!".getBytes());
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 建立服务端服务
        ServerSocket serverSocket = new ServerSocket(9090);
        while(true){
            // 2. 接收客户端连接
            Socket socket = serverSocket.accept();
            new TomCatService(socket).start();
            System.out.println("用户已连接");
        }

    }
}
