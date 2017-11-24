public class Calculator {
    private int num1;
    private int num2;
    private char option;

    public void init(int n1, int n2, char o){
        if(o == '+' ||o == '-'||o == '*' ||o == '/'){
            this.option = o;
        }else{
            option = '+';
        }
        num1 = n1;
        num2 = n2;
    }
    public void calculate(){
        switch(option){
            case '+':
                System.out.println(num1+num2);
                break;
            case '-':
                System.out.println(num1-num2);
                break;
            case '*':
                System.out.println(num1*num2);
                break;
            case '/':
                System.out.println(num1/num2);
                break;
        }
    }
}
