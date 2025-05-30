package calc;

public class Main {
    public static void main(String[] args) {
        Double resultSum = Calc.sum(23, 8);
        Double resultSubtract = Calc.subtract(47.2, 6);
        Double resultDivide = Calc.divide(6, 2);
        Double resultMultiply = Calc.multiply(6.5, 8.0);


        System.out.print("Сумма = " + resultSum + "\n");
        System.out.print("Разница = " + resultSubtract  + "\n");
        System.out.print("Частное = " + resultDivide + "\n" );
        System.out.print("Произведение = " + resultMultiply + "\n");

    }

}
