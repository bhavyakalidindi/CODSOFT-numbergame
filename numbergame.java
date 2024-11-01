import java.util.*;

public class numbergame {
    public static void main(String args[])
     {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;

        while (true) {
            int attempts = 0;
            int limit = 5;
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            boolean hasWon = false;

            System.out.println("Round " + (rounds + 1) + ":");
            System.out.println("You have " + limit + " attempts to guess the number!");

            while (attempts < limit) {
                System.out.print("Enter your guess: ");
                int playerGuess = in.nextInt();
                attempts++;

                if (playerGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasWon = true;
                    break;
                } else if (playerGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (hasWon) {
                int roundScore = (limit - attempts + 1) * 10;
                totalScore += roundScore;
                System.out.println("You won this round with a score of: " + roundScore);
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
            }

            rounds++;
            System.out.println("Total score after " + rounds + " round(s): " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playagain = in.next();

            if (!playagain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! Your final score is: " + totalScore);
                break;
            }
        }

        in.close();
    }
}
