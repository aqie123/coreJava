package aqie2;

public class Demo3 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        t.method();
    }
}

class Test3{
    void method(){
        System.out.println("bat 处理文件Q");
    }
}

// 懒汉单例模式
class Single{
    private Single(){}

    private static Single single = null;

    // 提供一个公共方法(必须和类名一致)
    public static Single getInstance(){
        if(single == null){
            synchronized ("锁"){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}