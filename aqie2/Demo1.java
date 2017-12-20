package aqie2;

import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;
import java.awt.*;

public class Demo1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        // t.method();
        // t.method2();
        // t.method3();
        // t.method4();
        t.method5();
        // t.method6();
        // t.method7();
        //t.init();
    }
}

class Test1{

    // 第一个窗体
    void method(){
        // 1. 创建一个窗体对象(初始不可见)
        JFrame frame = new JFrame("My first window");
        // 2. 设置窗体可见
        frame.setVisible(true);
        // 3. 设置窗体大小 (像素)
        // frame.setSize(300,400);
        // 4.设置窗体初始位置
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        // 5. 设置窗体的关闭事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 获取默认系统工具包
    void method2(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕分辨率
        Dimension dimension = toolkit.getScreenSize();
        System.out.println("x: " + dimension.getWidth());
        System.out.println("y: " + dimension.getHeight());
    }

    // 对话框
    void method3(){
        JFrame frame = new JFrame("My first window");
        frame.setSize(300,400);
        JDialog dialog = new JDialog(frame,"Dialog",true);
        dialog.setBounds((1600-300)/2,(900-400)/2,300,400);
        dialog.setVisible(true);
    }

    // JOptionPane 对话框
    void method4(){
        JFrame jFrame = new JFrame();
        JOptionPane jOptionPane = new JOptionPane();
        jOptionPane.showMessageDialog(jFrame,"learn JOptionPane",
                "Notice",JOptionPane.INFORMATION_MESSAGE);
        // 确认对话框
        int num = JOptionPane.showConfirmDialog(jFrame,"是否继续");
        System.out.println(num);

        // 输入对话框
        String message = JOptionPane.showInputDialog(jFrame,"请输入您的信息");
        System.out.println(message);
    }

    // 文件对话框
    void method5(){
        JFrame frame = new JFrame("Windows");
        FileDialog dialog = new FileDialog(frame,"请打开文件",FileDialog.LOAD);
        dialog.setVisible(true);
        System.out.println("文件路径 "+dialog.getDirectory());
        System.out.println("文件名 "+dialog.getName());
        FileDialog dialog2 = new FileDialog(frame,"请保存文件",FileDialog.SAVE);
        dialog2.setVisible(true);
    }

    // 面板 Panel
    void method6(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        frame.setBounds((1600-300)/2,(900-400)/2,300,400);
        frame.setVisible(true);
        // 添加panel到窗体上
        frame.add(panel);
        // 设置窗体关闭事件
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 标签
    void method7(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setBounds((1600-600)/2,(900-800)/2,600,800);
        frame.setVisible(true);
        // 创建一个标签对象
        JLabel label = new JLabel("用户名");
        JTextField jTextField = new JTextField(12);
        // 组件添加到面板
        panel.add(label);
        panel.add(jTextField);
        // 密码
        JLabel label1 = new JLabel("密码");
        JPasswordField jPasswordField = new JPasswordField(12);
        panel.add(label1);
        panel.add(jPasswordField);

        // 性别 单选框(一定要分组)
        JLabel sex = new JLabel("性别");
        JRadioButton man = new JRadioButton("man");
        JRadioButton woman = new JRadioButton("woman");
        // 分组
        ButtonGroup group = new ButtonGroup();
        group.add(man);
        group.add(woman);

        panel.add(sex);
        panel.add(man);
        panel.add(woman);

        // 城市  下拉
        JLabel city = new JLabel("城市");
        Object[] cities = {"北京","上海","广州","深圳"};
        JComboBox cityBox = new JComboBox(cities);
        panel.add(city);
        panel.add(cityBox);

        // 多选框
        JLabel hobbies = new JLabel("Hobby");
        JCheckBox java = new JCheckBox("java");
        JCheckBox javascript = new JCheckBox("javascript");
        JCheckBox perl = new JCheckBox("perl");
        panel.add(hobbies);
        panel.add(java);
        panel.add(javascript);
        panel.add(perl);

        // 自我介绍
        JLabel introduction = new JLabel("MY Introduction");
        JTextArea textArea = new JTextArea(15,20);
        panel.add(introduction);
        panel.add(textArea);
    }

    // 菜单组件(JMenuBar  JMenu)
    JFrame jFrame = new JFrame();
    // 菜单条
    JMenuBar bar = new JMenuBar();
    // 菜单
    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");
    JMenu helpMenu = new JMenu("Help");
    // 菜单项
    JMenuItem copy = new JMenuItem("复制");
    JMenuItem save = new JMenuItem("保存");
    JMenuItem open = new JMenuItem("打开");

    JMenuItem about = new JMenuItem("About");
    JMenuItem update = new JMenuItem("Update");
    // 文本域
    JTextArea area = new JTextArea(12,15);

    void init(){
        bar.add(fileMenu);
        bar.add(editMenu);
        // 菜单项添加菜单
        fileMenu.add(open);
        fileMenu.add(save);
        editMenu.add(copy);

        // 多级导航
        editMenu.add(helpMenu);
        helpMenu.add(about);
        helpMenu.add(update);
        // 菜单添加到窗体
        jFrame.add(bar,BorderLayout.NORTH);
        jFrame.add(area);

        jFrame.setBounds((1600-600)/2,(900-800)/2,600,800);
        jFrame.setVisible(true);
    }
}