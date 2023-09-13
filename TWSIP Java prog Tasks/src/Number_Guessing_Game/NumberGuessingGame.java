package Number_Guessing_Game;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + (attempts + 1) + " attempts.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've exhausted all attempts. The correct number was " + randomNumber);
        }

        scanner.close();
    }
}

