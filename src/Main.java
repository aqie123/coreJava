public class Main {

    public static void main(String[] args) {
        // 1. 猜数游戏
        // GuessGame g = new GuessGame(); g.startGame();
        // 2. 基础学习
        BaseLearn b = new BaseLearn(); // b.learn();

        // 创建Dog数组
        /*
        Dog[] pets;   // 声明 Dog 类型数组变量
        pets = new Dog[7];  // 只有Dog对象引用
        pets[0] = new Dog(); // 创建新的Dog对象并赋值给数组元素
        pets[0].bark();

        int num = 10;
        int y = b.learn3(num);
        System.out.println(y);
        */
        // b.learn4();

        // Duck myDuck = new Duck();

        Hippo h = new Hippo("Aqie");
        System.out.println(h.getName());


    }


}
