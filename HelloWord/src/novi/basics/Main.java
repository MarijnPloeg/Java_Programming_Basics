package novi.basics;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        boolean hasPlayerWon = false;
        // Create scanner
        Scanner userInput = new Scanner(System.in);

        // Generate random number
        Random randomizer = new Random();
        int number = randomizer.nextInt(10);

        while (hasPlayerWon == false) {
            // Display random number to user
            System.out.println("Give to integers that add up to the number: " + number);
            int userNumber_1 = userInput.nextInt();
            int userNumber_2 = userInput.nextInt();

            // Check if numbers are correct
            if (userNumber_1 + userNumber_2 == number) {
                hasPlayerWon = true;
                break;
            }
            else {
                System.out.println("Your input is incorrect!");
            }
            System.out.println("You won!");
        }
    }
}
