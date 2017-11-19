public class GuessGame {
    Player p1;
    Player p2;
    Player p3;
    public void startGame(){
        // 创建对象
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        // 声明变量保存猜测数字
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        // 定义变量是否猜中
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        // 产生猜谜
        int targetNumber = (int) (Math.random() *10);
        System.out.println("I am thinking a number between 0 and 9");

        while(true){
            System.out.println(" Number to guess is " + targetNumber);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player one guessed " + guessp1);

            guessp2 = p2.number;
            System.out.println("Player two guessed " + guessp2);

            guessp3 = p3.number;
            System.out.println("Player three guessed " + guessp3);

            // 检查是否猜中,如果猜中则设置猜中变量
            if(guessp1 == targetNumber){
                p1isRight = true;
            }
            if(guessp2 == targetNumber){
                p2isRight = true;
            }
            if(guessp3 == targetNumber){
                p3isRight = true;
            }

            // 如果有一个或者多个猜中
            if(p1isRight || p2isRight || p3isRight){
                System.out.println("We have a winner!");
                System.out.println("Player one is right ?" + p1isRight);
                System.out.println("Player two is right ?" + p2isRight);
                System.out.println("Player three is right ?" + p3isRight);
                // 游戏结束
                break;
            } else{
                System.out.println("Players have to try again!");
            }
        }
    }
}
