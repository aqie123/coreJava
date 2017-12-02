public class Computer implements CPU,Displayer{
    public static final int x = 10;
    public void calculate(){}
    public void display(){}
}

interface CPU{
    int x = 1;

    public void calculate();
}

interface Displayer{
    void display();
}

class ComputerDriver{
    public static void main(String[] args){
        System.out.println("computer");
    }
}