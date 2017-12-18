package aqie1;

import java.io.IOException;
import java.net.*;

public class Demo20 {
    public static void main(String[] args) throws IOException {
        Test20 t = new Test20();
        // t.method();

        t.method2();
    }
}

class Test20{
    void method() throws UnknownHostException {
        // InetAddress address = InetAddress.getLocalHost();   // 获取本机IP地址对象
        InetAddress address = InetAddress.getByName("192.168.0.135");
        System.out.println(address);
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        InetAddress[] addresses = InetAddress.getAllByName("http://www.baidu.com");
        System.out.println();
    }

    // UDP 发送端
    void method2() throws IOException {
        // 1, 建立UDP的服务
        DatagramSocket socket = new DatagramSocket();
        // 2, 准备数据,将数据封装到数据包
        String data = "first UDP message";
        byte[] buff = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length,InetAddress.getLocalHost(),9090);
        // 3. 发送数据
        socket.send(packet);
        // 4. 关闭资源 (释放端口号)
        socket.close();
    }

}