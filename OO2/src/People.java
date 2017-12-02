public abstract class People {
    String name;
    String color;
    public People(String name,String color){
        this.name = name;
        this.color = color;
    }
    public abstract void run();
}

class WhitePeople extends People{
    public WhitePeople(String name,String color){
        super(name,color);
    }
    public void run(){
        System.out.println(name+" white people run");
    }

    public void jump(){
        System.out.println(name+"just jump!");
    }
}

class BlackPeople extends People{
    public void run(){
        System.out.println(name+" black people run");
    }

    public BlackPeople(String name,String color){
        super(name,color);
    }
    public void fly(){
        System.out.println(name+" just fly!");
    }
}

class PeopleDriver{
    public static void main(String[] args){
        People whitePeople = new WhitePeople("bush","白色");
        whitePeople.run();

        People blackPeople = new BlackPeople("obama","黑色");
        blackPeople.run();

        /*
        People people = new People("person","red") {
            @Override
            public void run() {
                System.out.println();
            }
        };
        */

    }
}
