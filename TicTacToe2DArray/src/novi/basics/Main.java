package novi.basics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welkom bij het spel boter, kaas en eieren");

        //Stap 1: Maak een bord
        String[] board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = Integer.toString(i);
        }

        Scanner userInput = new Scanner(System.in);
        printBoard(board);

        String currentPlayer = "X";
        boolean hasWon = false;

        while (hasWon == false){
            //Stap 2: Geef de speler de mogelijkheid om een move te zetten
            System.out.println("\nKies een getal waar je jou " + currentPlayer + " wil zetten: ");
            int selectedField = userInput.nextInt();

            board[selectedField] = currentPlayer;
            //Toon het board
            printBoard(board);

            //kijk of een speler heeft gewonnen
            hasWon = hasPlayerWon(board, currentPlayer);

            //Wissel van speler
            currentPlayer = switchPlayer(currentPlayer);
        }

        System.out.println("\nGefeliciteerd, je hebt gewonnen! " + currentPlayer);

        //Stap 3: Kijk of een speler heeft gewonnen

        //Stap 4: Geef de speler de mogelijkheid om een O te zetten

        //Stap 5: Kijk of een speler heeft gewonnen

        //Herhaal stap 2 t/m 5

    }

    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);

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

    public static String switchPlayer(String currentPlayer) {
        if (currentPlayer == "X") {
            return "O";
        } else {
            return "X";
        }
    }

    public static boolean hasPlayerWon(String[] board, String currentPlayer){
        //Horizontale opties om te winnen
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer){
            return true;
        }
        else if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer){
            return true;
        }
        else if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        //Verticale opties om te winnen
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        else if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer){
            return true;
        }
        else if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        //Diagonale opties om te winnen
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        else if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        return false;
    }
}
