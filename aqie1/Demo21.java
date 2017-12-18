package aqie1;

import java.io.IOException;
import java.net.*;

public class Demo21 {
    public static void main(String[] args) throws IOException {
        Test21 t = new Test21();
        t.method();
    }
}

class Test21{
    // 模拟udp数据丢失
    void method() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = null;
        for(int i = 0;i<10;i++){
            String data = i+"aaaa";
            // 数据封装到数据包中发送
            packet = new DatagramPacket(data.getBytes(),data.getBytes().length, InetAddress.getLocalHost(),9090);
            // 发送数据
            socket.send(packet);
        }
        // 关闭资源
        socket.close();
    }
}