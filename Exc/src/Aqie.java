public class Aqie {

}

class AqieDriver{
    public static void main(String[] args) {
        /*
        Throwable a = new Throwable("出错啦");
        System.out.println("toString " + a.toString()); // java.lang.Throwable 包名+类名
        System.out.println(a.getMessage());
        */
        // System.out.println(a.printStackTrace());
        // test();
        // jvm 默认管理内存64M
        byte[] arr = new byte[1024*1024*1024];  // 1G
    }

    public static void test(){
        Throwable a = new Throwable("出错啦");
        a.printStackTrace();
    }
}