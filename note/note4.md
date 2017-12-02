一：异常
    1. java的中异常祖先是Throwable，Throwable的直接子类是Exception和Error
    2. Throwable 常用方法
        1. toString()     返回该异常的类的完整类名  包名+类名 = 完整类名
        2. getMessage()    创建Throwable对象的时候传入的消息字符串
        3. printStackTrace() 打印异常栈信息
    3. Error 
        1. Error 一般是jvm或者硬件引发的,一般不会通过代码处理
    4. Exception : 需要代码处理()
        1. jvm发现异常,创建异常对象,并调用printStackTrace() 打印异常栈信息
            Object->Throwable->Exception->RuntimeException
            运行异常(RuntimeException及其子类) ： 方法抛出运行异常对象，方法声明可省略,
                        调用了声明抛出运行时异常类型方法,调用者可以处理也可以不处理
            编译异常 ： 必须声明，必须处理
            java编译器对运行异常宽松原因 ：运行异常可以通过代码避免掉 
        2. 异常处理方式
            1.捕获 try{} catch(){异常类型 变量名}catch(){}
                a. try块出现异常,之后所有代码均无法运行
                b. try 块可以跟多个catch块,捕获异常类型必须从小到大
            2. 抛出 (throw throws)
                a. 方法内部抛出编译异常对象,必须在方法声明中抛出
                b. 如果调用了声明编译时抛出异常方法,调用者必须进行处理(捕获或者抛出),否则编译报错
                c. 一个方法遇到throw关键字，会立马停止执行(一种情况只能抛出一种异常对象)
                    throws后面可以跟多个异常类型
                d. 区别
                   1. throw : 跟异常对象,一次只能抛出一个异常对象
                      throws: 方法上声明抛出异常类型
        3.抛出和捕获使用场景
            1. 通知调用者出了异常 抛出异常信息
            2. 与用户打交道代码出错必须捕获
    5. 自定义异常类：继承Exception
        1.
    6. finally 块 Demo3.java
        1. 不管程序是否正常读取文件,一定保证释放资源代码正常执行
        2. 前提： 必须配合try块使用
            1.return 结束函数 throw都不会阻止finally执行
            2. 只有java虚拟机退出运行 exit();  System.exit(0); 
                // 0:正常退出, 非0异常退出 一般try 传0 cache 非0
    7. try catch 形式
        1. try{} catch(){}  没有资源文件释放,需要处理异常代码使用
        2. try{} catch(){} finally{}  既有资源释放也需要处理异常
        3. try{}finally{}  只需要释放资源文件,不需要异常代码处理
            
二：三层架构
    1.Web
    2.service 业务逻辑层
    3.dao 数据持久层
三： Spring(Spring：DI/AOP  IOC原理)、Struts(MVC)、Hibernate(ORM)
    1. HTTP协议
    2. Servlet和JSP
    3. hibernate和mybatis是对jdbc的封装，利用反射等完成参数赋值对象转换，
        或者在执行sql的时候做安全检查和适当缓存。
    spring和struts就是在自己的servlet中分发各种请求，因为都拦截了，
    然后就可以根据url来匹配action中的方法，
    还可以自动把request中携带的参数赋给action中的变量或者action方法中的参数，让你可以直接用。
 四：note
    1. 资源文件使用完毕一定要释放
    2. 
