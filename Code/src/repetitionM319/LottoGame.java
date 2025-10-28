package repetitionM319;

import java.util.Random;
import java.util.Scanner;

public class LottoGame {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private int[] generateWinningNumbers() {
        int[] winningNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = random.nextInt(42) + 1;
        }
        return winningNumbers;
    }

    private int countMatches(int[] userNumbers, int[] winningNumbers) {
        int matches = 0;
        for (int userNum : userNumbers) {
            for (int winNum : winningNumbers) {
                if (userNum == winNum) {
                    matches++;
                    break;
                }
            }
        }
        return matches;
    }

    private void printNumbers(int[] numbers, String label) {
        System.out.print(label + ": ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        boolean playAgain;

        do {
            System.out.println("Lotto-Spiel: Geben Sie Ihre 6 Zahlen (1-42) ein");

            int[] userNumbers = new int[6];
            for (int i = 0; i < 6; i++) {
                System.out.print("Zahl " + (i + 1) + ": ");
                userNumbers[i] = game.scanner.nextInt();
                if (userNumbers[i] < 1 || userNumbers[i] > 42) {
                    System.out.println("Ungültige Zahl. Bitte eine Zahl zwischen 1 und 42 eingeben.");
                    i--;
                }
            }

            int[] winningNumbers = game.generateWinningNumbers();

            game.printNumbers(userNumbers, "Ihre Zahlen");
            game.printNumbers(winningNumbers, "Gewinnzahlen");

            int matches = game.countMatches(userNumbers, winningNumbers);
            System.out.println("Sie haben " + matches + " Treffer!");

            if (matches >= 3) {
                System.out.println("Glückwunsch! Sie haben mindestens 3 Treffer!");
            } else {
                System.out.println("Leider weniger als 3 Treffer. Versuchen Sie es erneut!");
            }

            System.out.print("Nochmal spielen? (true/false): ");
            playAgain = game.scanner.nextBoolean();
        } while (playAgain);

        System.out.println("Danke fürs Spielen!");
        game.scanner.close();
    }
}