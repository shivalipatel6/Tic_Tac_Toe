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


/**
     *  Takes in user input and translates it into array positions.
     * returns null if inputs are out of array.
     * move - movement directions from player inputted at the beginning of the turn.
     * int[] - int array with the translated coordinates for the gameboard.
     */
    public static int[] TranslateMove(String move) {
        if (move.length() != 2) return null;
        // incorrect input
        int position[] = new int[2];
        String[] strPos = move.split("");
            
            switch (strPos[0]) {
            case "a": position[1] = 0;
            break;
            case "b": position[1] = 1;
            break;
            case "c": position[1] = 2;
            break;
             // returns null for any other type of value
            default: return null;
            }// end first switch case
            switch (strPos[1]) {
                case "1": position[0] = 2;
                break;
                case "2": position[0] = 1;
                break;
                case "3": position[0] = 0;
                break;
                // returns null for any other type of value
                default: return null;
            }// end second switch case   

        return position;
    }// end TranslateMove


     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[][] gameBoard = new String[3][3];
        // game board is set fully null because there are no "peices" in it until the first move it made
        gameBoardPrint(gameBoard);
        sc.close();
        boolean turn = true;
        boolean gameOver = false;
        int validity = 1;



        
     }// end main
}// end class TicTacToe
