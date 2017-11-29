public class Singleton2 {
    public static void main(String[] args){
        Single2 s1 = Single2.getInstance();
        Single2 s2 = Single2.getInstance();
        System.out.println(s1 == s2);  // true
    }

}

class Single2{
    private Single2(){}

    private static Single2 single = null;

    // 提供一个公共方法(必须和类名一致)
    public static Single2 getInstance(){
        if(single == null){
            single = new Single2();
        }
        return single;
    }
}
