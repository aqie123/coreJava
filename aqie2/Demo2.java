package aqie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 布局管理器
public class Demo2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        // t.method();
        // t.method1();
        // t.method2();
        t.method3();
        // t.method4();
        // t.method5();
        // t.method6();
        //t.method7();
    }
}

class Test2{
    // 边框布局管理器(BorderLayout)
    void method(){
        JFrame frame = new JFrame("边框布局管理器");
        BorderLayout borderLayout = new BorderLayout();
        // 窗体使用边框布局管理器
        frame.setLayout(borderLayout);
        frame.add(new JButton("东"),BorderLayout.EAST);
        frame.add(new JButton("南"),BorderLayout.SOUTH);
        frame.add(new JButton("西"),BorderLayout.WEST);
        frame.add(new JButton("北"),BorderLayout.NORTH);
        frame.add(new JButton("中"),BorderLayout.CENTER);
        // 初始化窗体
        frame.setBounds((1600-600)/2,(900-800)/2,600,800);
        frame.setVisible(true);
    }

    // 流式布局管理器(FlowLayout)
    void method1(){
        JFrame frame = new JFrame("流式布局管理器(FlowLayout)");
        JPanel panel = new JPanel();
        // 创建流式布局管理器,并指定对齐方式
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT,0,0);
        // 面板使用流式布局管理器
        panel.setLayout(flowLayout);

        frame.add(panel);
        // 初始化窗体
        frame.setBounds((1600-600)/2,(900-800)/2,600,800);
        frame.setVisible(true);

        panel.add(new JButton("东"),BorderLayout.EAST);
        panel.add(new JButton("南"),BorderLayout.SOUTH);
        panel.add(new JButton("西"),BorderLayout.WEST);
        panel.add(new JButton("北"),BorderLayout.NORTH);
        panel.add(new JButton("中"),BorderLayout.CENTER);

    }

    // 表格布局管理器 GridLayout
    void method2(){
        JFrame frame = new JFrame("表格布局管理器 GridLayout");
        // 初始化窗体
        frame.setBounds((1600-600)/2,(900-800)/2,600,800);
        frame.setVisible(true);

        GridLayout gridLayout = new GridLayout(4,3);
        frame.setLayout(gridLayout);

        for (int i = 0;i<10;i++){
            frame.add(new JButton(i+""));
        }
        frame.add(new JButton("+"));
        frame.add(new JButton("-"));
        frame.add(new JButton("*"));
        frame.add(new JButton("/"));
        frame.add(new JButton("."));
        frame.add(new JButton("confirm"));
    }

    // 事件(点击 ，空格)
    void method3(){
        JFrame frame = new JFrame("事件");
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        //创建按钮
        JButton button = new JButton("click me");
        // 按钮添加监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    // 鼠标点击，空格会调用
                System.out.println("I am clicked!");
                // JButton button1 = (JButton) e.getSource();  // 获取事件源对象
                String content = button.getText();
                if("click me".equals(content)){
                    button.setText("I have changed");
                }else{
                    button.setText("click me");
                }
            }
        });
        frame.add(button);
    }

    // 鼠标监听器
    void method4(){
        JFrame frame = new JFrame("事件");
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        //创建按钮
        JButton button = new JButton("click me");
        frame.add(button);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标点击");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("鼠标按下");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("鼠标松开");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标离开");
            }
        });
    }

    // 适配器
    void method5(){
        JFrame frame = new JFrame("事件");
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2){
                    System.out.println("double click!");
                }
                System.out.println("click!");
            }
        });
    }

    // 键盘监听器
    void method6(){
        JFrame frame = new JFrame("事件");
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        //创建按钮
        JButton button = new JButton("click me");
        frame.add(button);
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("键入某个键");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("释放某个键");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("按下某个键");
            }
        });
    }

    // 键盘适配器
    void method7(){
        JFrame frame = new JFrame("事件");
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        //创建按钮
        JButton button = new JButton("click me");
        frame.add(button);
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // System.out.println("输入字符 "+e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println("按下字符 "+e.getKeyChar() + "键的code"+e.getKeyCode());
            }
        });
    }
}