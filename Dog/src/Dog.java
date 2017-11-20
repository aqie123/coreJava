class Dog {
    private int size;
    private String name;
    public static void main(String[] args){
        //创建Dog对象
        Dog dog1 = new Dog();
        dog1.bark(3);
        dog1.name = "Bart";
        dog1.size = 70;

        // 创建Dog数组 只有Dog对象引用
        Dog [] myDogs = new Dog[3];

        // 关门放狗
        myDogs[0] = new Dog();   // 创建新的Dog对象并赋值给数组元素
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // 通过数组引用存取Dog
        myDogs[0].name = "Fred";
        myDogs[1].name = "Marge";

        System.out.print("last dog's name is ");
        System.out.println(myDogs[2].name);

        int x = 0;
        int barkNum = dog1.giveSecret();
        while(x < myDogs.length){
            myDogs[x].bark(barkNum);
            x = x+1;
        }
    }

    public void bark( int numOfBark){
        if(size > 60){
            while(numOfBark > 0){
                System.out.println(name + " Woof Woof!");
                numOfBark = numOfBark - 1;
            }

        }else if(size > 14){
            System.out.println(name + " Ruff Ruff!");
        }else{
            System.out.println(name + " Yip Yip!");
        }

    }

    int giveSecret(){
        return 5;
    }
    public void eat(){}
    public void chaseCat(){}
}
