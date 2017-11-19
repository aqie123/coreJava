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
三. web应用部署到Tomcat
    1.
四.数据类型 primitive 八种
    1. boolean  char
    2. integer 整型(带符号)
        byte
        short
        int
        long 
    3.  float
        double
    4.
五. 基础
    1. 对象引用变量保存的是存取对象的方法
    2. 声明为 private 的方法、变量和构造方法只能被所属类访问，并且类和接口不能声明为 private。
    3.变量类型
        类变量：独立于方法之外的变量，用 static 修饰。
        实例变量：独立于方法之外的变量，不过没有 static 修饰。
        局部变量：类的方法中的变量。
    4.JAVA 的类（外部类）有 2 种访问权限: public、default。
      而方法和变量有 4 种：public、default、protected、private。
      其中默认访问权限和 protected 很相似，有着细微的差别。
       public 意味着任何地方的其他类都能访问。
       default 则是同一个包的类可以访问。
       protected 表示同一个包的类可以访问，其他的包的该类的子类也可以访问。
       private 表示只有自己类能访问
    5.数组初始化
        1. String[] str = {"1","2","3"}; // 正确的
        2. String[] str;
           str = new String[] {"1","2","3"}; // 正确了
        3.  int[] arr = new int[3];
            int[] arr1= new int [] {1,2,3,4,5};
            int[] arr2 = {1,2,3,4,5};