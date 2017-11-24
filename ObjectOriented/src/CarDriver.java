public class CarDriver {
    public void learn(){
        Car car = new Car();
        car.color = "red";
        Car car2 = new Car();
        car2.color = "green";
        // car2 = null;  一个引用类型变量未指向任何对象
        car = car2;
        car.run();
        new Car();  // 匿名对象
        System.out.println(new Car() == new Car());  // 内存地址不一致
    }

}
