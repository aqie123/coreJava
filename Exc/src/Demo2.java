public class Demo2 {
    public static void main(String[] args){
        try{
            feiQ(null);
        }catch(CableMissException e){
            System.out.println(e.toString());
            // System.out.println("sth goes wrong");
            // throw new ArithmeticException();
            // System.exit(0); // 0:正常退出, 非0异常退出
        }finally {
            System.out.println("bend down!");
        }
    }
    public static void feiQ(String ip) throws CableMissException{
        if(ip == null){
            throw new CableMissException(" Cable missing");
        }
        System.out.println("Your friend list is ...");
    }
}

// 自定义异常类
class CableMissException extends Exception{
    public CableMissException(String message){
        super(message); // 调用父类一个参数的构造函数
    }
}
