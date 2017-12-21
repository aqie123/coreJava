- 计算机
    ###. 硬件
        1. cpu 运算控制核心
        2. 内存: 软件运行数据先加载到内存，
            CPU从内存读取数据
            优点：存取速度快
            缺点：断电，程序退出 数据会丢失
        3. 硬盘
    ### 软件
        1.系统软件
            windows,linux,unix,mac os
        2.应用软件
- 常见DOS命令
    1.dir 列出当前文件夹
    2.md  创建文件夹
    3.rd 删除文件夹(不能删除非空)
      
    4.echo "今天是个好日子">ln1.md 
    5.命令行查看 type ln1.md
    6. del a.txt 删除文件
        del 后面跟文件夹 删除文件夹内所有文件(不会删除文件夹)
    7. * 通配符匹配任意文件名  
        del * 杀出文件夹所有文件
        del *.txt
        通过通配符进入文件夹
    8. tab 内容补全键
    9. 查看所有环境变量信息 set
        set JAVA_HOME
        修改 set JAVA_HOME = D:\Program Files\Java\ ;
        清空 set JAVA_HOME = ;
        添加path 下新路径  set path = aaa; %path%;
- JAVA
    1. 环境
        一次编译 qq.class，到处运行 (通过java虚拟机解释)
        1. JRE java运行环境 = java 虚拟机+核心类库(辅助虚拟机运行文件)
        2. JDK java开发工具集 = java 开发工具 + jre  (完成编译)
        3. JVM ：java 虚拟机
    2. jdk
        1.bin  java 开发工具可执行文件
        2.include   存储的本地方法的方法
        3.jre : java虚拟机
    3. 
        1. 类名与java源文件可以不一致,class文件与类名一致
        2. path ： 任意路径可以找到java 开发工具
        3. java_home: 避免频繁修改path 环境变量信息
        4. classpath : 设置class文件路径
            set classpath=.\test.zip
        5. main函数作用及其特点
            程序主入口,类需要独立运行
        6. class定义类
        7. javac 启动java编译器,编译java源文件
        8. java 启动java虚拟机,解释并执行指定class文件
    4. path classpath
        path 在运行一个可执行命令的时候，系统会查找这个命令的位置
      所以你运行javac  java的时候都需要path