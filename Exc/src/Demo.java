public class Demo {
    public static void main(String[] args) {
        division(4,2);
        System.out.println("hello aqie");
    }
    public static void division(int a, int b){
        int c = 0;
        try{
            c = a/b;
        }catch (ArithmeticException e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        System.out.println(c);

    }
}


