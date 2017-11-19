## begin learn java
IntelliJ IDEA 注册码 http://idea.lanyus.com/
程序员代码面试指南 IT名企算法与数据结构题目最优解
1. 推荐书单
    http://coredumper.cn/index.php/2017/08/06/java_booklist/
2. java 文档
    https://docs.oracle.com/javase/8/docs/
    
 一：安装
    1. D:\Program Files\Java\jdk1.8.0_151
       D:\javajre
       JAVA_HOME=D:\Program Files\Java\jdk1.8.0_151
       PATH=%JAVA_HOME%\bin;%PATH%;       echo %JAVA_HOME%
       CLASSPATH=.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
    2. javac hello.java   ->  java hello 
二：搭建tomcat
    1. 创建对象存放在 Garbage-Collectible Heap
    2. 没有全局变量概念
        1. 任何变量加上public static final ，都会变成全局变量取用的常数
        2. 常量pi和random()必须定义在Math类中,很特殊,不会有多个实例或者对象
    3. 成百上千类同时提交
        1. 所有文件存档 jar文件，引入文字文件  manifest ,定义哪个文件带有main函数
    4. 搭建tomcat (https://www.cnblogs.com/puresoul/p/4234742.html)
           1. 下载
           2, 启动
                1. 双击startup.bat  shutdown.bat 关闭tomcat
                2.  添加环境变量 %CATALINA_HOME%\bin;
                    添加环境变量 CATALINA_HOME = D:\Program Files\apache-tomcat-8.5.23
                    此时在另一个窗口打开Tomcat
                    1. 命令行输入catalina run就可看到在当前窗口启动了tomcat：
                 3. 开机自启动
                    1. service.bat install Tomcat
                    2. 服务中开启
           3.查看是否启动 net start 
           4. 修改Tomcat服务器端口
                server.xml文件，修改配置文件中的Connector节点的port属性
三