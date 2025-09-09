package Felipe.Q2;

import java.util.Scanner;

/**
 * Ein Taschenrechner Programm zum Addieren von zwei Zahlen.
 * @author Felípe
 */
public class Calculator {

    /**
     * Addiert zwei ganze Zahlen.
     * @param a erste Zahl
     * @param b zweite Zahl
     * @return Summe von a und b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Einstiegspunkt des Programms.
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Gib zwei Zahlen ein:");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int sum = calc.add(x, y);
        System.out.println("Die Summe ist: " + sum);

        sc.close();
    }
}
