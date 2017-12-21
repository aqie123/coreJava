一：bat处理文件: 批处理文件一次性可以执行多个命令的文件 Demo3.java
    1.  set classpath   查看当前 classpath路径
        set classpath=.\aqie2.zip
        D:\coreJava>java aqie2.Demo3
        pause 
        一次性命令 (针对jar zip 目录起作用)
        java -classpath .\aqie2.zip aqie2.Demo3  （指定路径 class类文件）
    2.bat常用命令 
        1.pause: 让控制台停留
        2.echo off : 之下的命令都会隐藏起来,只显示结果
        3. @ :  隐藏当前行命令
        4.echo: 控制台输出
        5.title:控制台标题
        6. rem  %% 注释
        7.%[1-9] %1 %2 占位符,通过命令行传参运行
        8.
    
二：懒汉单例模式:线程安全问题解决       Demo3.java
    1.保证内存中只有一个该类对象
    2.
三：反射            aqie2.Demo4.java
    1.作用
        1.反编译：.class-->.java
        2,通过反射机制访问java对象的属性，方法，构造方法等；
    2.当class文件被加载到内存时候，jvm会马上对class文件成员解剖
        然后将class文件的成员数据封装到class对象中,如果获取到Class对象
        可以通过class对象来操作该类的所有成员
    3.class 对象的获取方式
        1、Class.forName(类名)    推荐
        2. 通过类名Person.class
        3. 通过对象获取Class对象 getClass()
    4.注意
        1.反射技术中,一个类的任何成员，都使用了一个类来描述
    5.  具体应用
        1.通过反射获取 获取到单个构造函数，通过constructor创建对象  method2()  
        2.通过class对象获取成员函数  Method类    method3()
        3. 通过class对象获取成员变量  Field类    method4()
        
四：工厂设计模式:专门用于生产对象的方法  Demo5.java  
    1.需求：定义工厂方法可以产生任何类型的对象,  Demo6.java
        产生的对象根据配置文件而定
五：观察者设计模式       Demo7.java
    1. 当一个事物发生指定动作时,通知另一个事物处理相应的处理方案
    2. 需求：编写气象站,气象站要不断的更新天气,
        人要根据当前天气作相应处理
        1.问题：天气更新多次,人作出一次反应
                天气更新一次,人作出多次反应
                气象站只能为一个人服务
                气象站只能为一类人服务   Demo8.java
        2. 定义 Weather接口     接口利用多态解耦
            订阅天气预报的群体必须先实现Weather接口
    3.设计步骤
        1.把要通知对方的行为抽出来，定义在一个接口上
        然后在本类中维护该接口的成员
六：断点调试
    1.