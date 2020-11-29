package novi.basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welkom bij het spel boter, kaas en eieren");

        //Stap 1: Maak een bord
        Field[] board = new Field[9];

        for (int i = 0; i < 9; i++) {
            board[i] = new Field(Integer.toString(i));
        }

        printBoard(board);

        Player playerA = new Player("Marijn", "X");
        Player playerB = new Player("Hendrik", "O");

        Game game = new Game(playerA, playerB);

        boolean hasWon = false;

        while (hasWon == false) {
            //Stap 2: Geef de speler de mogelijkheid om een move te zetten
            System.out.println("/\n" + game.getCurrentPlayer().getName() + " kies waar je jou " + game.getCurrentPlayer().getToken() + " wil zetten: ");
            int selectedField = userInput.nextInt();

            String currentPlayerToken = game.getCurrentPlayer().getToken();

            board[selectedField].setToken((currentPlayerToken));
            //Toon het board
            printBoard(board);

            //kijk of een speler heeft gewonnen
            hasWon = game.hasPlayerWon(board);
            if (hasWon) {
                game.getCurrentPlayer().setScore(1);
            }
            game.switchPlayer();
        }

        System.out.println("\nSpeler " + playerA.getName() + " heeft een score van " + playerA.getScore());
        System.out.println("Speler " + playerB.getName() + " heeft een score van " + playerB.getScore());
    }

    public static void printBoard(Field[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i].getToken());

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isEndOfField = i == 8;

            if (isEndOfRow == false) {
                System.out.print(" | ");
            }
            if (isEndOfRow && !isEndOfField) {
                System.out.println("\n________");
            }
        }
    }
}