public class Mini extends Car {
    Color color;

    // 无参数构造函数,以默认的颜色调用真正构造函数
    public Mini(){
        this(Color.Red);
    }

    public Mini(Color c){
        super("Mini");
        color = c;
    }

    public Mini(int size){
        super(size);
    }
}
