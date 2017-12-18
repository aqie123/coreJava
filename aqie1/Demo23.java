package aqie1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo23 {
    public static void main(String[] args) {
        Test23 t = new Test23();
        t.method();
    }
}

class Test23{
    void method(){

    }
}
class ImageServer extends Thread{
    @Override
    public void run() {
        try{
            // 1.建立tcp服务器连接
            ServerSocket serverSocket = new ServerSocket(9090);

            // 2.接收用户的请求连接
            Socket socket = serverSocket.accept();
            // 3.获取socket输出字节流
            OutputStream outputStream = socket.getOutputStream();
            // 4.获取图片输入流,读取图片数据,将图片数据写出给客户端
            FileInputStream fileInputStream = new FileInputStream("D:\\coreJava\\coreJava\\static\\images\\timg.jpg");
            byte[] buff = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(buff)) != -1){
                outputStream.write(buff,0,length);
            }
            // 5.关闭资源
            fileInputStream.close();
            serverSocket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}