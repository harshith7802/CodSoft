
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalAttempts = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            System.out.println("Round " + rounds);

            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            int attempts = 0;
            int guess;

            do {
                System.out.print("Enter your guess (1-100): ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You have guessed correctly.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            } while (guess != randomNumber && attempts < 10);

            totalAttempts += attempts;

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Total rounds played: " + rounds);
        System.out.println("Average number of attempts per round: " + (double) totalAttempts / rounds);
    }
}