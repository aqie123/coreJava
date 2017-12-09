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
                2.
        8. LinkedList
        9.Vector(了解)
    5. Set
二：note
    1. list.lastIndexOf()   不能add添加 char
    2. 迭代器在迭代过程中时,不准使用集合对象改变集合中元素个数
        否则报错 ConcurrentModificationException  
        ( 使用集合对象方法后不能使用it.next();)