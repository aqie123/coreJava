一.装饰者设计模式  
    1. 增强一个类功能
        1.继承    Demo6.java
        2.代码不灵活,继承体系太庞大
    2, 步骤      Demo7.java
        1. 增强类内部维护一个被增强类的引用
        2. 增强类与被增强类有一个共同的父类或者父接口
    3. 好处
        1. 利用多态,实现了类与类之间相互装饰
        2. 缺点 ：代码结构不清晰
    4. 练习 Demo8.java
        1. 一家三口工作,儿子绘画,妈妈比儿子强上涂料
            爸爸比妈妈强上画框
 二. 序列流对象  Demo9.java  (难点) day21 序列流
    1. SequenceInputStream  序列流没有读写能力
    2. 通过Vector得到迭代器 创建序列流
    3. Vector 线程安全，换作ArrayList
    4. Enumeration 接口
    5. 需求 把一份MP3切成n份，每份一兆，然后再合并起来
三. 对象输入输出流
    a. ObjectOutputStream  对象的输出流对象 : 对象数据写入到文件上    Demo10.java
        1. ObjectOutputStream(OutputStream ) 没有读写能力
                Serializable 没有任何方法,标识接口
        2. 需求 ： 永久性保存user对象
    b. ObjectInputStream 对象的输入流类
    c. 注意
        1.只支持java.io.Serializable接口对象写入流中
        2.反序列化构造对象,不会调用构造方法,克隆对象也不会调用构造方法
        3. 对象写入文件,除了记录对象信息,还记录class版本号(类名,包名,工程名,成员一起算出)
        4. 反序列化，jvm会根据本地class计算出id号与文件记录id号比对,不一致失败
        5. 类成员后期改动,序列化之前指定serialVersionUID: 
            private static final long serialVersionUID = 1L;
        6. 一个类某些成员不想被序列化到硬盘上,用transient 修饰
        7. 如果一个类内部维护了另一个类对象(也就是new 了个对象),
            另一个类也必须实现Serializable接口
    d.所有集合类都实现了Serializable接口,可以写到硬盘上
四：Properties 配置文件类  父类 Map集合类  Demo11.java （难点 课时10）
    1.作用
        1. 生成配置文件
        2. 读取配置
    2.注意
        1. extends Hashtable (put putAll 不推荐)推荐setProperty方法
        2. properties.setProperty() 不能传入非字符串数据
        3. store(OutputStream out, String comments) 传入字节流,不能编码转码
        4. 保存中文使用store不能使用字节流,字节流默认使用iso8859-1码表保存
            有中文建议使用字符流
        5. 修改了properties数据,要重新生成配置文件
           修改配置文件  Map集合修改值 ：只要键一样，值就换了
    3.需求 
        properties实现软件只能试用三次,三次后提示购买退出jvm