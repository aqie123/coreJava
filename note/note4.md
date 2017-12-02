一：异常
    1. java的中异常祖先是Throwable，Throwable的直接子类是Exception和Error
    2. Throwable 常用方法
        1. toString()     返回该异常的类的完整类名  包名+类名 = 完整类名
        2. getMessage()    创建Throwable对象的时候传入的消息字符串
        3. printStackTrace() 打印异常栈信息
    3. Error 
        1. Error 一般是jvm或者硬件引发的,一般不会通过代码处理
    4. Exception : 需要代码处理
        1. jvm发现异常,创建异常对象,并调用printStackTrace() 打印异常栈信息
        2. 异常处理方式
            1.捕获 try{} catch(){异常类型 变量名}
            2. try块出现异常,之后所有代码均无法运行
        3.