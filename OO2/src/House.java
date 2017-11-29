public class House {
    String name = "aqie";
    public House(String name){
        this.name = name;
    }
    public House(){}
    public House decorate(){
        System.out.println(" I am decorate House");
        return new House();
    }
}
class Bedroom extends House{
    private String name = "aqie123";
    public Bedroom(String name){
        super(name); // 指定调用父类有参数构造方法
        System.out.println(this.name);
        System.out.println(super.name);
    }
    public Bedroom decorate(){
        System.out.println(" I am decorate Bedroom");
        return new Bedroom("aqie");
    }
}
class HouseDriver{
    public static void main(String[] args){
        Bedroom bedroom = new Bedroom("Full house!");
        bedroom.decorate();
    }
}
