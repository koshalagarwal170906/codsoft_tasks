import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        // Secure scanner init
       Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRoundsWon = 0;
        int totalAttemptsTaken = 0;
        int roundNumber = 1;
        boolean playAgain = true;

        System.out.println("====== WELCOME TO THE NUMBER GAME! ======");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Generates 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + roundNumber + " ---");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear invalid token
                    continue;
                }

                attempts++;
                totalAttemptsTaken++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again. (Attempts left: " + (maxAttempts - attempts) + ")");
                } else {
                    System.out.println("Too low! Try again. (Attempts left: " + (maxAttempts - attempts) + ")");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Game Over for this round! The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            } else {
                roundNumber++;
            }
        }

        // Display Final Score
        System.out.println("\n====== FINAL SCOREBOARD ======");
        System.out.println("Total Rounds Played: " + roundNumber);
        System.out.println("Rounds Won         : " + totalRoundsWon);
        System.out.println("Total Guesses Made : " + totalAttemptsTaken);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}