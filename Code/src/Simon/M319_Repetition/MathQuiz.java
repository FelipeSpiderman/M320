package Simon.M319_Repetition;

import java.util.*;

public class MathQuiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random randomNumber = new Random();
        int correct = 0;

        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) x{
            int a = randomNumber.nextInt(10) + 1;
            int b = randomNumber.nextInt(10) + 1;
            int result = a + b;
            System.out.print("Aufgabe " + i + ": " + a + " + " + b + " = ");
            int answer = in.nextInt();
            if (answer == result) correct++;
        }
        long end = System.currentTimeMillis();

        System.out.println("Richtig: " + correct + "/10");
        System.out.println("Zeit: " + (end - start) / 1000 + " Sekunden");
    }
}
