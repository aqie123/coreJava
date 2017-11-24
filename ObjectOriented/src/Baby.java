public class Baby {
    // 问题：一种一出生就有姓名身份证,一种出生后才会有(黑户)
    int id;
    String name;
    {
        System.out.println("构造代码块");
    }
    void cry(){
        System.out.println(name+": Wa Wa ");
    }
    public Baby(){
        System.out.println("this is unregistered child");
        cry();
    }
    public Baby(int i, String n){
        id = i;
        name = n;
        cry();
    }
    public static void main(String[] args){
        Baby b = new Baby();  // 黑户
        b.id = 10016;
        b.name = "aqie";

        Baby b1 = new Baby(1007,"aqie");
    }
}
