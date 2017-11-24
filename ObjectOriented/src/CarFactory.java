public class CarFactory {
    String name;
    String address;
    String tel;
    public void repair(Car car){
        if(car.wheel<4){
            car.wheel = 4;
            System.out.println("修好了,给钱");
        }else{
            System.out.println("非常努力修好,多给点钱");
        }
    }
}
