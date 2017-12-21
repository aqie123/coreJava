public class Singleton{
    public static void main(String[] args){
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);  // true
    }
}
// 饿汉单例模式
class Single {
    // 1.私有化构造函数
    private Single(){}

    // 2. 创建本类对象
    private static final Single instance = new Single();

    // 3.提供公共方法获取本类对象
    public static Single getInstance(){
        return instance;
    }
}



