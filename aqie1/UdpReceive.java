package aqie1;

import java.io.IOException;
import java.net.*;

public class UdpReceive {
    public static void main(String[] args) throws IOException, InterruptedException {
        T t = new T();

        t.method3();
    }
}

class T{
    // UDP接收端
    void method3() throws IOException, InterruptedException {
        // 1.建立UDP服务,并监听端口
        DatagramSocket socket = new DatagramSocket(9090);
        // 2.准备一个空的数据包
        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff,buff.length);
        // 3.调用UDP服务
        boolean flag = true;
        while (flag){
            socket.receive(packet);     // 阻塞型方法
            Thread.sleep(1000);     // 模拟cpu处理能力不足
            System.out.println(packet.getAddress().getHostAddress()+"服务端接收到数据 "+ new String(buff,0,packet.getLength()));
        }
        // 4.关闭资源
        socket.close();
    }
}