1. ConcurrentModificationException
    (https://www.2cto.com/kf/201403/286536.html)
   原因： List、Set、Map 都可以通过Iterator进行遍历，这里仅仅
    是通过List举例，在使用其他集合遍历时进行增删操作都需要
    留意是否会触发ConcurrentModificationException异常
   解决：
   使用Iterator提供的remove方法，用于删除当前元素
2. NullPointerException
    1. FileInputStream fs = null 而读取文件时,文件不存在
3.