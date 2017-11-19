public class Player {
    // 要被猜数字
    int number = 0;

    public void guess(){
        number = (int) (Math.random() * 10);
        System.out.println("I'm guessing " + number);
    }
}
