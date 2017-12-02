// 异常抛出处理
public class Demo1 {
    public static void main(String[] args){
        try{
            division(4,0,null);
        }catch (Exception e){
            System.out.println("something goes wrong");
            System.out.println(e.toString());
        }
    }

    public static void division(int a, int b,int[] arr) throws ArithmeticException,NullPointerException{
        if(b == 0){
            // 异常抛出
            throw new ArithmeticException();
        }else if(arr == null){
            throw new NullPointerException();
        }
        int c = a/b;
        System.out.println(c);
    }
}
