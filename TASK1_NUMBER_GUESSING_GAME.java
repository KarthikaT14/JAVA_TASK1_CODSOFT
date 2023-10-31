import java.util.Random;
import java.util.Scanner;
class Task1_NumberGuessingGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int min = 1;
        int max = 100;
        int max_Attempts = 10;
        int score = 0;

        System.out.println("This is the Number Guessing Game!!");
        System.out.println("There are certain scoring criteria which are as follows:");
        System.out.println("100 points are alloted for every round in the game and you lose a point for every incorrect attempt.");
        while (true)
        {
            int actual = rd.nextInt(max - min + 1) + min;
            int attempts = 0;

            System.out.println("A number has been selected between " + min + " and " + max + ". Start Guessing!");

            while (true)
            {
                System.out.print("Enter your guess number: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess < min || guess > max)
                {
                    System.out.println("The number is not present in our specified range. Please enter a number again.");
                }
                else if (guess == actual)
                {
                    System.out.println("Congratulations! You've guessed the number accurately in " + attempts + " attempts.");
                    score += evaluateScore(attempts);
                    break;
                }
                else if (attempts >= max_Attempts)
                {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + actual + ".");
                    break;
                }
                else if (guess < actual)
                {
                    System.out.println("The number is too low! Try again.");
                } 
                else
                {
                    System.out.println("The number is too high! Try again.");
                }
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes"))
            {
                System.out.println("Your final score is: " + score);
                System.out.println("Thank you for playing!");
                break;
            }
        }

        sc.close();
    }

    private static int evaluateScore(int attempts)
    {
        return 100 - attempts;
    }

    @Override
    public String toString() {
        return "Task1_NumberGuessingGame []";
    }
}
