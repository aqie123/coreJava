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
            底层使用Object数组实现的,与ArrayList原理一致，线性安全操作效率低
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
    3. 字符串具备可比性 ： 实现了Comparable接口,有compareTo()
        a.字符串比较规则
            1. 两个字符串可以找到对应位置不同的字符,比较第一个不同的字符
            2. 找不到不同位置上字符,则对比两个字符串的长度
三：泛型  Demo14.java
    1. 好处
        1. 运行时出现问题提前至编译时
        2. 避免无谓的强制类型转换
    2. 写法 ()
        1. ArrayList<String> list = new ArrayList<String>(); V
        2. ArrayList<Object> list = new ArrayList<String>(); X
        3. ArrayList<String> list = new ArrayList<Object>(); X
        // 为了兼容
        4. ArrayList list = new ArrayList<String>();         V
        5. ArrayList<String> list = new ArrayList();         V
    3. 注意
        1.泛型里面没有多态
        2.左右两边数据类型必须一致,或者只写一边泛型
        3.推荐两边都写
    4. 自定义泛型 ：一个数据类型的变量或者是一个数据类型的占位符  Demo15.java
        1.注意
            1. 函数自定义泛型的具体数据类型是在调用函数时,传递实参数据时
                确定具体的数据类型
            2. 泛型中不能使用基本类型数据的,如果需要使用基本数据类型
                就要使用基本数据类型对应的包装类型
                byte -> Byte
                int  -> Integer 包装了基本类型int值，Integer对象包含int类型字段
                float ->Float
                double -> Double
                short -> Short
                long -> Long
                char -> Character
                boolean ->Boolean
         2. 在写一些工具类时使用到    
    5. 自定义泛型类    Demo15
        1. class MyArrays<T>{} 函数中就可以不必声明
        2.注意
            1.类上声明的自定义泛型的具体数据类型在使用该类创建具体对象时确定
            2. 如果一个类已经声明了自定义泛型,该类在创建对象时候没有
            指定自定义泛型的具体数据类型,默认为Object类型
            3. 静态方法不能使用类上声明的自定义泛型,如果需要使用自定义泛型只能在自己方法上使用
                1.因为 T类型在创建对象才能确定,静态方法不需要创建对象
                2. public  static <T> void test(T[] arr){}
    6. 泛型接口  Demo5.java
        1. 注意
            1、实现接口时确定泛型类型
            2. 接口自定义泛型,实现该接口时未指定具体数据类型
                默认为Object
        2. 应用 ： Demo13.java AgeComparator 优化
                   Demo4.java  Person   compareTo()方法
    7. 泛型的上下限   Demo16.java
        1. 需求 ：定义一个可以接收任意类型的集合对象,接收的集合对象
                只能存储Integer 以及 Integer 的父类
        2. ? super Integer  泛型的下限  Integer 及以上
        3. ? extends Integer  泛型的上限
四：map 遍历方式   Demo17.java
    1. 用处 ： 存储成对数据  双列集合 Map
    2. Map : 
        1.实现Map接口存储数据都是以键值对存在的（key）不能重复
        2. 子类
            1. HashMap  没有顺序  Demo18.java
                1.底层依赖于哈希码实现的,存储的位置是根据键的哈希码算出来的
                2. 存储原理 ：
                    HashMap存储元素时,HashMap会调用键的HashCode得到一个哈希码值
                    通过哈希码值得到元素在哈希表中存储位置
                    情况一：算出位置没有任何元素,直接添加
                    情况二 ： 键的哈希码值算出位置已经有其他元素,调用键的equals方法
                    与这个位置元素再比较一次<equals返回false可以添加，返回 true 被视为重复元素
            2. TreeMap 
                1. 存储原理
                    底层使用了红黑树实现的，
                2. 特点
                    根据键进行存储
                3. 注意
                    1. 添加元素，键不具备自然顺序特性,键所属类必须实现Comparable接口
                    2. 既不具备自然顺序,也没实现Comparable接口,必须在创建treeMap
                    对象时传入比较器对象Comparator  Demo18
            3. Hashtable(了解)
                1.原理：实现一个哈希表(HashMap一致) 线程安全操作效率低
         3. 增
            put()
                添加元素到map,返回以前与key关联的值,如果没有针对key映射关系
                则返回null
            putAll()
         4. 删
            clear()  清除所有元素
            remove()  删除指定值 返回 value
         5. 获取
            get()   根据键获取对应的值
            size()
         6. 判断
            containskey()
            containsValue()
            isEmpty()
         7. 迭代
            keySet()    返回Set类型,把key数据存储到Set返回
            entrySet()  返回Collection  将所有值存储到Collection
                1. Entry 是Map的静态内部类  Demo18.java
            values()    返回Set
    3.HashMap