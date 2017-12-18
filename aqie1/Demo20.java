package aqie1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo20 {
    public static void main(String[] args) throws UnknownHostException {
        Test20 t = new Test20();
        t.method();
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
}