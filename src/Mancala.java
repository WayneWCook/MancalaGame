import java.util.Scanner;

/* Mancala.java
 * Wayne Cook
 * 15 February 2023
 * Purpose:
 *      Main method to start Mancala game.
 */
public class Mancala {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner input = new Scanner(System.in);
        Player[] player = new Player[3];
        int pTurn = 1, move = 1;
        // The three player array is create, but each array must be initialized before being used.
        for (int i = 1; i <= 2; i++) {
            player[i] = new Player();               // Initialize each needed member of array.
            System.out.print("What is the name of the " + (i == 1 ? "first" : "second") + " player: ");
            player[i].name = input.nextLine();
            player[i].firstPit = (i - 1) * 7;
            player[i].lastPit = (i - 1) * 7 + 5;
            player[i].mancala = (i - 1) * 7 + 6;
            player[i].playerNumber = i;
        }
        // Make sure the board is set up properly
        board.resetStones();

        while (pTurn != 0) {
            board.printBoard(player);
            boolean badAnswer = true;
            while (badAnswer) {
                System.out.print("It is now " + player[pTurn].name + "'s turn. Choose from pits " +
                        player[pTurn].firstPit + " to " + player[pTurn].lastPit + ": ");
                try {
                    move = input.nextInt();
                    if (move < player[pTurn].firstPit || move > player[pTurn].lastPit) {
                        throw new OutOfRangeException("Number must be between " + player[pTurn].firstPit +
                                " and " + player[pTurn].lastPit);
                    }
                    badAnswer = false;                  // If it makes it here, the choice is good.
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Choose a number between " + player[pTurn].firstPit +
                            " and " + player[pTurn].lastPit);
                    input.reset();
                } finally {
                    input.nextLine();                   // Make sure any line feed is handled
                }
            }
            pTurn = board.doMoves(pTurn, move);
        }
    }
}
