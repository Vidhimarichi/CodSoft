package CodeSoft;
import java.util.Scanner;
import java.util.Random;
class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 7;

        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + rangeStart + " and " + rangeEnd + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); 
                    continue;
                }

                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + (maxAttempts - attemptsLeft) + " attempts.");
                    guessedCorrectly = true;
                    totalAttempts += (maxAttempts - attemptsLeft);
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("You're out of attempts! The number was " + numberToGuess + ".");
                }
            }

            roundsPlayed++;

            // Ask if the user wants to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);

        if (roundsWon > 0) {
            double averageAttempts = (double) totalAttempts / roundsWon;
            System.out.printf("Average attempts per win: %.2f\n", averageAttempts);
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}
