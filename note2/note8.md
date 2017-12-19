一.图形化界面 aqie2 Demo1.java
    1.所有图形类都称作组件类。
        1. 容器组件
        2. 非容器组件
    2.图形组件类位于 java.awt  javax.swing
    3.区别
       1. swing的图形都是以J开头
       2. awt图形类图形都是依赖系统图形库
          swing图形类都是sun实现的
二：对话框
    容器组件        Demo1.java
        1.Dialog(所有者,标题,
        true:未关闭前不准操作所有者
        false：未关闭前可以操作所有者)
        2. JOptionPane(对话框)
        3. FileDialog (文件对话框)
        4.Panel (面板)
    非容器组件       Demo1.java
        1. 菜单组件
三：布局管理器  : 用于摆放容器   Demo2.java
    1. 边框布局管理器(BorderLayout)
        1.添加组件默认在中间
        2. frame默认使用的BorderLayout
        3.东南西北哪个缺少,中间会占据其位置
    2. 流式布局管理器(FlowLayout)
        1.默认居中对齐
        2.panle 默认使用的是FlowLayout
    3. 表格布局管理器 GridLayout
        1. 添加组件超过表格个数,会添加多一列处理
        2. 

四：事件:某个组件发生指定动作,会有相应处理方案
    1.事件源
    2.监听器 : 
        1. 鼠标点击 空格
        2.鼠标监听器 (MouseListener 接口)
        3. 适配器(MouseAdapter)该类已经实现MouseListener
            但实现方法全部为空
        4. 键盘监听器
            1. 适配器(KeyAdapter())
    3.事件
    4.处理方式
    