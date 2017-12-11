一 ：操作集合的工具类  Collections    Collection 接口
    1. 区别 Collection 单列集合根接口
            操作集合的工具类  Collections
    2. Collection 常用方法：  Demo19.java
        1. 二分查找,数组要有序
            int binarySearch(list,key)
            list 集合中的元素都是Comparable 的子类
            int binarySearch(list,key,Comparator)
        2. 数组排序
            sort(list)
            list进行排序,其实使用的事list容器中的对象的compareTo方法
            sort(list,comparator)  Demo19.java 比较器
        3. 对集合取最大最小值
            max(Collection)
            max(Collection,comparator)
            min(Collection)
            min(Collection,comparator)
        4. 对list集合进行反转
            reverse(list)
        5. 对比较方式进行强行逆转。
           Comparator reverseOrder();
           Comparator reverseOrder(Comparator);
        6. 对list集合中的元素进行位置的置换。
           swap(list,x,y);     传入索引值
        7. 对list集合进行元素的替换。如果被替换的元素不存在，那么原集合不变。
           replaceAll(list,old,new);  传入value值
        8. 可以将不同步的集合变成同步的集合。
           Set synchronizedSet(Set<T> s)
           Map synchronizedMap(Map<K,V> m)
           List synchronizedList(List<T> list)
        9. 如果想要将集合变数组：
           可以使用Collection 中的toArray 方法。注意：是Collection不是Collections工具类
           传入指定的类型数组即可，该数组的长度最好为集合的size。
    3. Arrays 对数组操作的工具类   Demo20.java
        1.二分查找,数组需要有序
          binarySearch(int[])
          binarySearch(double[])
        2. 数组排序
           sort(int[])
           sort(char[])……
        3. 数组变字符串
            toString(int[])
        4. 复制数组
            copyOf(原数组,新数组长度)
        5. 复制部分数组
            copyOf(int[],int[])
        6. 比较两个数组是否相同
            equals(int[],int[])
        7. 数组变集合 ：可通过集合的操作来操作数组中元素,
            不能使用add,remove 数组长度是固定的，会出现
            UnsupportOperationException
            可使用 contains,indexOf
            1. 如果数组中存入的基本数据类型,则asList会将数组实体
            作为集合中元素,
            2. 数组存入引用数据类型,则asList会将数组中元素作为集合中元素
            List asList(T[])
