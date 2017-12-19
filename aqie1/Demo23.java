package aqie1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Demo23 {
    public static void main(String[] args) throws IOException {
        // 1.建立tcp服务器连接
        ServerSocket serverSocket = new ServerSocket(9090);
        // 不断接受用户请求
        while(true){
            Socket socket = serverSocket.accept();
            new ImageServer(socket).start();
        }
    }
}

class ImageServer extends Thread{
    Socket socket;

    static HashSet<String> ips = new HashSet<>();

    public ImageServer(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try{
            // 3.获取socket输出字节流
            OutputStream outputStream = socket.getOutputStream();
            // 4.获取图片输入流,读取图片数据,将图片数据写出给客户端
            FileInputStream fileInputStream = new FileInputStream("D:\\coreJava\\coreJava\\static\\images\\timg.jpg");
            byte[] buff = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(buff)) != -1){
                outputStream.write(buff,0,length);
            }
            // 获取用户ip
            String ip = socket.getInetAddress().getHostAddress();
            // 如果可以存储到集合中,意味是新ip地址
            if(ips.add(ip)){
                System.out.println("图片下载成功 "+ip);
                System.out.println("当前下载人数为"+ips.size());
            }

            // 5.关闭资源
            fileInputStream.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}