一：File类  Demo1.java
    1. 解决 ： 设备与设备间数据传输问题  
        内存 -> 硬盘  硬盘->内存 键盘->内存
    2. 应用场景 ：
        1. 导出报表 2.上传文件 3.播放音频文件 
    3. File 类常用方法
        1. 判断
            exists 判断文件是否存在
            isFile() 是否是文件
            isDirectory()  是否是目录
            isHidden()  是否是隐藏文件或隐藏目录
            isAbsolute()  抽象路径是否为绝对路径
        2. 创建
            1. createNewFile   创建空文件 成功true,失败 false
            2. mkdir()        创建目录，只创建最后一级
            3. mkdirs()       创建所有目录
            4. renameTo       重命名文件或文件夹,也可以操作非空文件夹
                              文件不同相当于文件的剪切,剪切时不能操作
                              非空文件夹, 成功返回true (不能剪切文件夹)
        3. 删除
            1.delete()  删除文件或文件夹,文件夹非空不能删除
            2.deleteOnExit() 虚拟机停止时,删除此抽象路径表示的文件或目录
                保证程序异常时创建的文件也可以删除
        4. 获取
            1.getName()
            2.getPath()
            3.getAbsolutePath()
            4.length()      文件大小 (字节数)
            5.getParent()    未指定 父级则返回null
            6.lastModified()  最后一次修改时间
        5. 文件夹相关
            1. static File[] listRoots() 列出所有的根目录
            2. list()  返回目录下的文件或文件名(包括隐藏文件) String类型
            3. list(FilenameFilter filter) 返回当前目录下符合过滤条件的文件或子目录
            4. listFiles()   返回目录下文件或者目录对象(File 实例)  File类型
            5. listFiles(FilenameFilter filter) 返回指定当前目录中符合过滤条件的子目录或子文件
            2-5 对文件操作返回null
        6. 应用场景
            1.File类仅能获取和修改文件的属性数据，不能读取文件内容数据
    4. 目录分隔符
        windows  \   Unix/linux /   separator
二： HashSet  迭代器Iterator遍历
    1.
三：note
    1.不同包的类调用 public 修饰符
    2. 跨包调用类 方法和属性  记得修饰符
四：IO流  Demo3.java
    1.类别
        1. 流向划分 ：(以当前程序作为参展物,数据流出，使用输出流)
           a. 输入流 :
                硬盘->程序
           b. 输出流
        2. 处理单位
            a. 字节流
                读取文件字节数据,读到数据不会经过任何处理
            b. 字符流 = 字节流 + 解码
                读到的字节数据会转换成字符数据,以字符为单位
    2. 输入字节流 的抽象基类： InputStream
        1. FileInputStream  1.读取文件的输入字节流 2.用(缓冲数组) 字节数组
            1. 找到目标文件
            2. 建立数据输入通道
            3. 返回读取的字节数据fs.read() / fs.read(buf) 数据存储到字节数组中
            4. 关闭资源  释放资源文件
    3. 输出字节流 抽象基类  OutputStream 
        1. FileOutputStream
            1.注意
                1.new FileOutputStream(file); 目标文件不存在先创建后写入
                2. 文件存在内容则被覆盖
                3. 追加数据 FileOutputStream(file,boolean append)
                4. write(int b) 参数接收int类型,但是只会把数据低八位写入,
                    其他24位丢弃
            2. 写入方法
                1. write()
                2. write(byte[])
                3. write(byte[],start,end)
    4.note:
        1.关闭资源原则 ： 先开后关    
五：IOException 
    1. RuntimeException(Throwable cause)
六： 缓冲输入输出字节流
    1. 前期准备
        1.FileInputStream 读取文件时,如何读取文件效率最高:
            使用字节数组做缓冲区读取的效率最高， 
        2.凡是缓冲流没有读写文件能力 
    2. InputStream -> FilterInputStream ->BufferedInputStream
        Sun准备 缓冲输入字节流 BufferedInputStream,提高读取文件效率
        本质： 内部维护8kb 字节数组
    3. BufferedInputStream  Demo5.java method2   缓冲输入字节流
        1.注意：
            BufferedInputStream close() 关闭的是 传进去的fileInputStream对象
        2.bufferedInputStream.read() 为什么比 fileInputStream.read() 读取效率高
            1.bufferedInputStream.read 返回的字节都是从内部维护的字节数组中取的 fill()
            2. fileInputStream.read() 每次都是从硬盘取的
        3. bufferedInputStream 为什么使用 InputStream构建
            1. 必须依赖一个有读取文件能力对象
    4. OutputStream -> FilterOutputStream ->BufferedOutputStream 缓冲输出字节流
        1. 提高效率 先存进字节数组,只有调用close()和flush()才会写到硬盘
        2. BufferedOutputStream close() 实际上就是出入的OutputStream对象的close()方法
七：字符流 (读取中文数据)
    1. 前提
        a.写入
            1.字节流写入中文,一个中文占两个字节
            2.字节流不具备编码和解码功能
            3. getBytes() 使用平台默认字符集将String编码为byte序列
                并将结果存储到一个新的byte数组中
                字符串不能使用默认字符集编码,应使用CharsetEncoder类
        b.读中文
            1.System.out.print((char)content); 读到两个字节才能转换成一个中文
            2.字节流读中文很麻烦  
            3. ReaderBuffFile()  new String(buff,0,length)
               使用默认的字符集解码指定的byte子数组,新的String长度是字符集的函数
               可能不等于该子数组长度
    2. note 
        1.码表
            ASCII 字符 -> 码值,一个字符占一个字节,一个字节七位即可表示
            GB2312 英文占一个字节,中文占两个字节
            GBK 中文编码表升级
            Unicode 国际标准规范,所有文字使用两个字节,java也是
            UTF-8 最多用三个字节表示一个字符
    3. 解决
        1.字符流以字符为单位,会把独到的字节转换为字符, 字符流 = 字节流 + 编码(解码)
    4. 输入字节流 抽象基类 Reader
        1. Reader -> InputStreamReader -> FileReader 读取文件数据的输入字符流
    5. 输出字节流 
        1. FileWriter 向文件写出数据的输出字符流
            1. 注意 new FileWriter 如果目标文件不存在,则创建目标文件
            2. FileWriter内部维护字符数组,真正写到硬盘 flush()  close()
    6. 字符流拷贝图片出bug
        1. 图片字符对应码值在码表不存在
八：使用场景
    1. 操作文本使用字符流
    2,操作图片等二进制使用字节流
九：Buff : 不具备文件读写功能,
    1.缓冲输入字符流 Reader -> BufferedReader 
        1.提高读取文件字符数据效率
        2.FileReader功能进行拓展  bufferedReader.readLine()
    2.缓冲输出字符流 Reader -> BufferedWriter
        1. 拓展  bufferedWriter.write(data);
十： 练习 Demo5.java
    1. 缓冲输入输出流编写注册登录功能
    2. 注册用户保存到文件
    3. 登录时查找的数据从文件上找