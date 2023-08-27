import java.util.Scanner;

public class TicTacToe {
    public static int turnNum = 1; 


 /** Prints out the state of the gameboard after each successful move
     * by the player 
     * gameBoard the current locations of the peices on the gameboard after a move
     */
    public static void gameBoardPrint(String[][] gameBoard){
        int boardNum = 3;
        char[] boardChar = {'a','b','c'};
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard[i].length; j++){
                if(gameBoard[i][j] == null){
                    System.out.print("__ ");
                }
                else{
                System.out.print(gameBoard[i][j]);
                }// there is a peice on the board
            }// end inner for (the row)
            System.out.print(" " + boardNum);
                boardNum--; 
                System.out.println();
        }// end outer for (the column)
        for(int i = 0; i < boardChar.length; i++){
            System.out.print(" " + boardChar[i]+ " ");
        }// end for loop for letters at end of board
        System.out.println();
        System.out.println();


    }// end gameBoardPrint



    


     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[][] gameBoard = new String[3][3];
        // game board is set fully null because there are no "peices" in it until the first move it made
        gameBoardPrint(gameBoard);
        sc.close();

     }// end main
}// end class TicTacToe
