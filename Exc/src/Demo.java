// 异常捕获处理
public class Demo {
    public static void main(String[] args) {
        // division(4,0,null);
        division(4,1,new int[]{1,2,3});   // 数组匿名对象
        System.out.println("hello aqie");
    }
    public static void division(int a, int b,int[] arr){
        int c = 0;
        try{
            System.out.println(arr.length);
            c = a/b;
        }catch (ArithmeticException e){
            System.out.println(e.toString());
            // System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }
        System.out.println(c);

    }
}


