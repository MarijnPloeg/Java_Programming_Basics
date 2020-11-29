package novi.basics;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int firstDigit;
        int secondDigit;
        int thirdDigit;

        Random randomizer = new Random();

        int maxGetal = 9;

        firstDigit = randomizer.nextInt(maxGetal) + 1;
        secondDigit = randomizer.nextInt(maxGetal) + 1;
        thirdDigit = randomizer.nextInt(maxGetal) + 1;

        int sumOfDigits = firstDigit + secondDigit + thirdDigit;
        int productOfDigits = firstDigit * secondDigit * thirdDigit;

        System.out.println("Som: " + sumOfDigits);
        System.out.println("Product: " + productOfDigits);

        int maxTimesToPlay = 3;

        while (true) {

            boolean hasPlayerWon = false;
            while (hasPlayerWon == false) {

                System.out.println("Voer achter elkaar drie getallen in: ");


                int userChoice1 = userInput.nextInt();
                int userChoice2 = userInput.nextInt();
                int userChoice3 = userInput.nextInt();

                System.out.println("Je hebt de volgende getallen ingevuld:  ");
                System.out.println("getal 1: " + userChoice1);
                System.out.println("getal 2: " + userChoice2);
                System.out.println("getal 3: " + userChoice3);

                int userChoiceSumOfDigits = firstDigit + secondDigit + thirdDigit;
                int userChoiceProductOfDigits = firstDigit * secondDigit * thirdDigit;

                hasPlayerWon = userChoiceSumOfDigits == sumOfDigits && userChoiceProductOfDigits == productOfDigits;

                if (hasPlayerWon) {
                    System.out.println("Gefeliciteerd! Je hebt gewonnen");
                } else {
                    System.out.println("Helaas, je hebt niet gewonnen...");
                }
            }

            boolean continuePlaying = true;

            // Keuzemenu
            System.out.println("Wil je het spel nogmaals spelen? Toets y/n");
            String continuePlayingUserChoice = userInput.next();
            switch (continuePlayingUserChoice) {
                case "y": {
                    System.out.println("Je hebt ervoor gekozen nogmaals te spelen");
                    continuePlaying = true;
                    break;
                }
                case "n": {
                    System.out.println("Je hebt ervoor gekozen te stoppen");
                    continuePlaying = false;
                    break;
                }
                default: {
                    System.out.println("Je hebt geen geldige waarde ingevoerd!");
                    break;
                }
            }
            if (continuePlaying == false) break;
        }
    }
}
