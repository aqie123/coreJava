一：模板设计模式
    1. 写出解决该类问题的一件解决方案
    2. 分析代码,将会变化代码抽取成独立方法，模板中方法使用final修饰
    3. 会发生变化代码抽取成抽象方法
二：intellij idea 使用技巧
    1. 将文件夹标记为根目录,可以设置package
    2. 自动修复 alt+enter
三：创建对象方式
    1. 自定义类创建对象
    2. sun自定义很多类
四：sun 类
    1. Object  Demo2.java
        toString() ：打印用户信息
        equals(Object obj)：对象是否相等,默认比较内存地址
        hashCode()：返回对象哈希码值，可以看做对象内存地址
            1. java规范：重写equals时,都会重写hashCode方法
    2. String  Demo3.java
        1. "hello"创建字符串,jvm先检查字符串常量池中是否存在hello对象,
            不存在则创建,返回地址.已存在内存中,则返回字符串的内存地址
        2. new String("hello")创建字符串,jvm检查字符串常量池中是否存在该字符串对象
            如果已经存在,则不再创建。将常量池中对象拷贝到堆内存中，
            不存在则在字符串常量池中创建该字符串对象
            然后在堆内存中创建该字符串对象，返回堆内存中字符串内存地址
        3. 获取方法
            1. int length() 获取字符串长度
            2. char charAt(int index) 获取指定位置字符
            3. int indexOf(String str) 获取特定字符的位置
            4. int lastIndexOf(int ch) 获取最后一个字符的位置
        4. 判断方法
            1. boolean endWith()
            2. boolean isEmpty()  // 长度为0 null
            3. contains(CharSequences)
            4. equalsIgnoreCase(String anotherString)
        5. 转换方法
            1. String(char[] value)  字符串数组转换为字符串
            2. String(char[] value,int offset,int count)
            3. char[] toCharArray() 字符串转换为字符数组
        6. 其他方法
            1. String replace
            2. String[] split  指定分隔符进行分割
            3. String substring  截取字符串
            4. String toUpperCase()
            5. String toLowerCase()
            6. String trim()  去掉字符串首尾空格
     3.(StringBuffer) String没有增加删除方法 ： 字符串是常量,值创建后不能更改.
        使用字符串缓冲区类修改字符串内容
        1. 字符串内容一旦改变会创建一个新对象
        2. 存储字符的集合容器
        3. 增
            StringBuffer("java");
            append();
            insert(); 指定下标位置添加新的文本对象
        4. 删
            delete(int start,int end);
            deleteCHarAt(int index);
        5. 查
            toString(); 返回容器字符串
            indexOf(String str); 返回第一次出现指定字符串索引
            substring(int start)
        6. 改
            replace(int start );
            setCharAt(int index char ch); 指定索引位置替换字符串
        7. 使用场景
            1. 字符串内容频繁更改
    4. StringBuilder 字符串缓冲类 兼容 StringBuffer 方法一致
        1. 区别
            1. StringBuilder 是线程不安全的
            2. 推荐使用(很少人会用多线程操作字符串)
    5. System 一个类没有构造方法 ：方法都是静态的 *  Demo4.java
        1. arraycopy() 拷贝数组
        2. currentTimeMillis() 当前系统时间
        3. exit()  退出jvm 0正常退出 非0异常退出
        4. gc()  建议jvm运行垃圾回收器 调用finalize()
        5. getenv() 返回一个不能修改的当前系统环境的字符串映射视图
        6. getProperties()
        7. static String getProperty(String key)
    6. Math 
        1. random  0.0-1.0双精度
        2. abs()   双精度浮点数绝对值
        3. round() 浮点或双精度浮点四舍五入后整型或者长整型 0.0-1.0不包括1.0
        4. min() max()  int long float double
        5. ceil() 向上取整
        6. floor() 向下取整
    ７．Runtime 代表当前程序运行环境  Demo5.java
        1. exec(String command) 执行指定路径下的可执行文件
    8. Date  被Calendar 取代  当前系统时间类
    9. SimpleDateFormat   日期格式化类
        1. 时间对象 转换成指定格式字符串 format()
        2. 字符串转换为日期对象   parse()   
    10. Random 
        1. nextInt(n) 范围 0-(n-1)
五：note
    1. Character.isSpaceChar(str.charAt(i)) 判断字符是否为空字符
 