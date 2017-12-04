package hello;

import javax.swing.*;

public class Welcome {
    public static void main(String[] args){
        /*
        String[] greeting = new String[2];
        greeting[0] = "Welcome to Core Java";
        greeting[1] = "By aqie";

        for(String g : greeting){
            System.out.println(g);
        }
        */
        JFrame frame = new JFrame("QQ程序");
        // 设置窗体可见
        frame.setVisible(true);
        // 设置窗体大小
        frame.setSize(400,500);
        // 设置关闭时退出
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
