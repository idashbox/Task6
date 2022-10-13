import java.util.Scanner;
//При некоторых заданных x (допустимые значения x – интервал (-R, R)), n и e, определяемых
//        вводом, вычислить:
//        1) сумму n слагаемых заданного вида;
//        2) сумму тех слагаемых, которые по абсолютной величине больше e;
//        3) сумму тех слагаемых, которые по абсолютной величине больше e/10;
//        4) значение функции с помощью методов Math.
//R = 1.


public class Programmm {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();
        System.out.print("Введите значение e: ");
        double e = scanner.nextDouble();
        System.out.printf("Сумма n слагаемых: %f%n", sum1(x, e, n)[0]);
        System.out.printf("Сумма слагаемых, больших e: %f%n", sum1(x, e, n)[1]);
        System.out.printf("Сумма слагаемых, больших e/10: %f%n", sum1(x, e, n)[2]);
        System.out.printf("Значение функции с помощью методов Math: %f%n", sum2(x));
        System.out.println(1/Math.sqrt(2));
    }
    static double[] sum1(double x, double e, int n) {
        double mult = 1;
        double num;
        double sumE1 = 1;
        double sumE2 = 1;
        double sum = 1;
        for (int i = 1; i < n; i += 2) {
            num = -(x * i/(i+1));
            if (Math.abs(mult) > e){
                sumE1 += mult;
            }
            if (Math.abs(mult) > e/10){
                sumE2 += mult;
            }
            sum += mult * num;
            mult = mult * num;
        }
        return new double[] {sum, sumE1, sumE2};
    }
    static double sum2(double x) {
        double mult = 1;
        double num;
        double sum = 1;
        final double EPS = 0.1 * Math.pow(10, -15);
        for (int i = 1; ; i++) {
            double multPred = mult;
            num = (-x * i / (i + 1));
            sum += mult * num;
            mult = mult * num;
            if (Math.abs(mult - multPred) < EPS) {
                break;
            }
        }
        return sum;
    }
}


