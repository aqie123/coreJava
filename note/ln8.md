一：集合 : 存储任意对象数据的容器 Demo8.java
    1. 数组特点
        1. 只能存储同一种类型的元素
        2. Object[] arr 可以存储任意类型数据
        3. 数组一旦初始化长度固定
        4. 数组中元素与元素间内存地址是连续的
    2. 集合特点
        1.存储任意类型的对象数据
        2.集合长度可变
        3.Collection是集合类的根接口
            1. List 有序,可重复
            2. Set  无序，不可重复
    3.常用方法
        1. 添加
            add  添加成功返回true
            addAll
        2. 删除
            clear  清除集合所有元素
            remove  删除成功返回true
            removeAll 删除两个集合中的交集元素 c2.removeAll(c1);
            retainAll 保留两个集合中交集元素,其他删除 c2.retainAll(c1);
        3. 查看
            contains  包含指定元素返回true
            containsAll  collection 包含指定collection所有元素
            isEmpty      不包含任何元素返回 true
            size        集合元素个数
        4. 迭代  Demo9.java   遍历集合中元素
            iterator 返回迭代器 ： 1.是接口，为什么能创建对象  多态返回实现接口对象
                1.hasNext()  有没有元素可遍历,实际是问当前游标有没有指向一个元素
                2.next()    获取当前指针指向元素,然后下移一个单位
                3.remove()   移除迭代器返回的最后一个元素
            note:
                1.获取到集合中的迭代器,迭代器对象就会有游标指向集合中的第一个元素
            toArray  返回collection中所有元素的数组
                1.遍历集合数组 Object数组  toArray
    4. List   Demo10.java  (特有方法都有索引值)
        1.增加
            add(int index,E element)
            addAll(int index,)      list.addAll(2,list);
        2.查看
            .
        3.删除 
            remove(int index)  返回被删除元素
        4.迭代
            listIterator()  继承 Iterator 接口
                1. hasPrevious()   是否有上一个元素
                2. previous()     游标上移一个单位,指向当前元素 不能喝next()一起用
                3. add(E e)       元素添加到当前游标指向位置
                4. set(E e)       指定元素替代迭代器最后一次返回数据  必须有 next()
        5.获取
            get(int index)
            indexOf(Object o)   查找指定元素第一次出现索引值
            lastIndexOf(Object o)
            subList(int fromIndex,int toIndex) 指定开始结束索引值 (有头没尾)
        6.修改
            set(int index, E element)
        7. ArrayList
            1. 无参构造函数默认容量 10，容量不够自动增长多少
                内部维护了 Object类型数组,实际存储到数组中:特点查询快(内存地址连续)，
                增慢：检查长度，不够用会拷贝数组
                删慢：删除中间元素也涉及到拷贝
                add,使用无参构造函数，当容量不够，数组长度增加右移一位，并复制一个新数组
            2. 特有方法
                ensureCapacity()
                trimToSize()
            3. 应用场景
                1.查询多   图书馆  Demo11.java   
        8. LinkedList  使用链表数据结构实现:查询速度慢 增删快  Demo2.java
            1. 一个链表记录当前元素和下一个元素的内存地址
            2.方法
                1.addFirst  添加到 集合首位置
                2.addLast   添加到集合末尾
                3.getFirst  获取集合首位置
                4.getLast   获取集合末尾元素
                5.removeFirst  删除集合首元素
                6.removeLast    删除集合末尾元素
            3.数据结构
                1.栈 ： 先进后出  属于接口Deque
                    push() 将元素推入列表所表示的堆栈，元素插入列表开头
                    pop()
                2.队列 ：先进先出
                    offer()
                    poll()
            4. 返回逆序的迭代器对象
                1.descendingIterator()
        9.Vector(了解)
            底层使用Object数组实现的,线性安全操作效率低
    5. Set
        1.HashSet(存储原理)
            1. HashSet 添加元素时,先调用元素的HashCode方法得到元素的哈希码值
                通过元素的哈希码值算出元素在哈希表中存储位置
               a.算出的位置目前已经有其他元素,会调用equals与该位置元素进行比较 
               equals返回false,该元素可存储在此位置，返回true，则被视为重复元素
            2. 算出位置目前没任何元素存储,直接添加到该位置
            3. 数据结合：
                使用了哈希表支持的, 存取的速度快
        2.TreeSet  Demo13.java
            1.根据使用的构造方法不同,
                a.用元素的自然顺序对元素进行排序或者
                b.根据创建set时提供的Comparator进行排序,不具备自然特性,必须实现Comparable接口
                  元素比较规则定义在compareTo (比较元素返回的是0则被视为重复元素,不会添加)
                c.元素不具备自然特性,且元素所属的类没有实现Comparable接口
                    创建treeSet对象必须传入一个比较器对象 
                    创建比较器对象 ：定义类实现 Comparator接口
                d. 传入比较器对象优先Comparable接口,
                    推荐使用比较器,复用性高
            2. 数据结构 ： 底层使用了红黑树(二叉树)数据结构实现
                特点 ; 可以对元素进行排序存储
                如果三个元素构不成二叉,会调整节点位置
            3. (红黑树)二叉树
                1. 左小右大
二：note
    1. list.lastIndexOf()   不能add添加 char
    2. 迭代器在迭代过程中时,不准使用集合对象改变集合中元素个数
        否则报错 ConcurrentModificationException  
        ( 使用集合对象方法后不能使用it.next();)