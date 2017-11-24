public class CalculatorDriver {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        calculator.init(2,3,'*');
        calculator.calculate();
    }
}
