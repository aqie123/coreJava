public class Main2 {
    public static void main(String[] args){
        /*
        CarDriver carDriver = new CarDriver();
        carDriver.learn();
        // 匿名对象只调用一次
        new Student().study();

        CarFactory carFactory = new CarFactory();
        // 需求只调用一次repair方法
        carFactory.repair(new Car());
        */

        MemberDriver memberDriver = new MemberDriver();
        memberDriver.aMember();
    }
}
