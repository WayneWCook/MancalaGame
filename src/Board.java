/*Board of Mancala Game
 * Wayne Cook
 * 15 February 2023
 * Purpose:
 *      Take care of all things concerning Mancala Board
 */
public class Board {
    private final int[] stonesReset = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
    private int[] stones = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};

    private void printLine(int number, boolean newLine) {
        for (int i = 0; i < number; i++) {
            System.out.print('*');
        }
        if (newLine) System.out.println();
    }

    private void printDots(int number, boolean newLine) {
        for (int i = 0; i < number; i++) {
            System.out.print("*    ");
        }
        if (newLine) System.out.println('*');
    }

    public void printBoard(Player[] players) {
        System.out.println("            Mancala Board!");
        System.out.println("     " + players[2].name + "'s side");
        System.out.print("        ");               // Line 0
        for (int j = 12; j > 6; j--) System.out.printf("%4d ", j);
        System.out.println();
        System.out.print("   ");                    // Line 1
        printLine(41, true);
        System.out.print("   ");                    // Line 2
        printDots(8, true);
        System.out.print("   *    ");              // Line 3
        for (int j = 12; j > 6; j--) System.out.printf("*%3d ", stones[j]);
        printDots(1, true);
        System.out.print("   ");                    // Line 4
        printDots(8, true);
        System.out.print("M2 ");                    // Line 5
        System.out.printf("*%3d ", stones[13]);
        printLine(30, false);
        System.out.printf("*%3d ", stones[6]);
        printDots(1, false);
        System.out.println("M1");
        System.out.print("   ");                    // Line 6
        printDots(8, true);
        System.out.print("   *    ");              // Line 7
        for (int j = 0; j < 6; j++) System.out.printf("*%3d ", stones[j]);
        printDots(1, true);
        System.out.print("   ");                    // Line 8
        printDots(8, true);
        System.out.print("   ");                    // Line 9
        printLine(41, true);
        System.out.print("        ");               // Line 10
        for (int j = 0; j < 6; j++) System.out.printf("%4d ", j);
        System.out.println();
        System.out.println("     " + players[1].name + "'s side");
    }

    // Be able to reset the stones at the start of a game.
    void resetStones() {
        for (int i = 0; i < stones.length ; i++) {
            stones[i] = stonesReset[i];
        }
    }

    // Do the moves
    int doMoves(int plyr, int choice) {
        plyr = (plyr == 1?2:1);
        int count = stones[choice];
        return plyr;

    }
}
