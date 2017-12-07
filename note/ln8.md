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
            1. list 有序,可重复
            2. set  无序，不可重复
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
