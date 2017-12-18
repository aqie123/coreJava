一：多线程 属于同一个进程
    a.线程
        1.方法
            1.Thread() e.构造新线程
            2 start() 启动线程,
                a.线程处于runnable状态,具备CPU等待资格(可运行状态)
                b.抢夺CPU执行权->运行状态
                c.->(sleep() wait())临时阻塞状态(不具备CPU等待和执行权)
                d.->消亡状态
            3. run
    b.中断线程
    c.线程状态(六种)
        New(新创建)
        Runnable(可运行)
        Blocked(被阻塞)
        Waiting(等待)
        Timed waiting(计时等待)
        Terminated(被终止)
    d.线程属性
        1.线程优先级 setPriority
        2.守护线程
        3.未捕获异常处理器
        4.
    e.同步
        1.两个及以上线程对共享数据存取,产生竞争条件(race condition)
        2.同步数据存取
        3.锁对象
            2.解锁操作放在finally子句
            3.ReentrantLock(可重入锁) ReentrantLock(公平锁)
        4.条件对象
        5.synchronized关键字
        6. 同步阻塞 
        7. 监视器
        8. Volatile域
        9. final变量
        10. 原子性
        11.死锁
        12. 线程局部变量
        13. 读写锁
        14.        
    f.阻塞队列
    g.线程安全的集合
    h.Callable 与Future
    i.执行器
    j.同步器
    k.线程与Swing
二：多进程        多任务(multitasking)
    1. 并发执行进程数目不是CPU决定的
    2. 一个任务称为一个线程(thread)  多线程程序(multithreaded)
三：多线程与多进程区别
    1.本质：
        每个进程拥有自己一整套变量,进程有独立的地址空间
        线程则共享数据，但拥有自己的栈空间，拥有独立的执行序列。
    2.一个线程可以创建和撤销另一个线程;同一个进程中的多个线程之间可以并发执行
    3.多进程的程序要比多线程的程序健壮，但在进程切换时，耗费资源较大，效率要差一些。