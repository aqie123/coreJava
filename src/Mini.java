/**
 * 程序代码只摆在某个构造函数(包括super调用)
 * 所有构造函数先调用该构造函数
 * this() this(aString) this(27,x)
 * this 就是对对象本身使用
 */

public class Mini extends Car {
    // 定义变量,只是这个变量是Color类型的
    Color color;
    // 无参数构造函数,以默认的颜色调用真正构造函数
    public Mini(){  // 1
        this(Color.Red);
    }

    public Mini(Color c){ // 2
        super("Mini");
        color = c;
        // 真正构造函数,执行初始化
    }

    public Mini(float weight){
        this(Color.Green);
    }

    public Mini(int size){
        this(Color.Green);
    }
}
