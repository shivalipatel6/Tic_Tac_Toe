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
                System.out.print(" " +gameBoard[i][j] + " ");
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


    public static int MakeMove(String[][] gameBoard, boolean turn, String input, int drawOffered) {
    // method returns turnCondition at the end if inputs are valid
    int turnCondition = 1;
    if (input.equals("resign")) {
        if (turn) System.out.println("O's wins");
        else System.out.println("X's wins");
        return 2;
    }// resign condition

    if (input.equals("draw") && drawOffered > 3) return 2;
    if (input.equals("draw") && drawOffered <= 3) return 0;
    if (input.equals("draw?")) {
        turnCondition = 4;
    }//  Starting a draw

    if(input.length() == 2){
    int placePiece[] = TranslateMove(input);
    if (placePiece == null) return 0;
        if(gameBoard[placePiece[0]][placePiece[1]] == null){
            if(turn){
                gameBoard[placePiece[0]][placePiece[1]] = "X";
            }// X's turn, place an X
            else{
                gameBoard[placePiece[0]][placePiece[1]] = "O";

            }// O's turn, place an O
        }
        else{
        turnCondition = 0;
        }// repeat answer
    }
    else{
        turnCondition = 0;
    }
   




   // either returns 1 (regular turn) or 2 (draw offered)
   return turnCondition;
    }//end MakeMove



     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[][] gameBoard = new String[3][3];
        // game board is set fully null because there are no "peices" in it until the first move it made


        boolean turn = true;
            // true = X's and false = O's 
        boolean gameOver = false;
        int validity = 1;
        while (!gameOver) {
             gameBoardPrint(gameBoard);
            if (turn) {
                System.out.print("X's move: ");
                String xMove = sc.nextLine();
                validity = MakeMove(gameBoard, turn, xMove, validity);
                while (validity == 0) {
                    System.out.println("Illegal move, try again");
                    System.out.print("X's move: ");
                    xMove = sc.nextLine();
                    validity = MakeMove(gameBoard, turn, xMove, validity);
                }
                turnNum = turnNum + 1;
                turn = false;
            }// X's turn
            else{
                    System.out.print("O's move: ");
                    String oMove = sc.nextLine();
                    validity = MakeMove(gameBoard, turn, oMove, validity);
    
                    // checks validity of move and switches turn if valid
                    while (validity == 0) {
                        System.out.println("Illegal move, try again");
                        System.out.print("O's move: ");
                        oMove = sc.nextLine();
                        validity = MakeMove(gameBoard, turn, oMove, validity);
                    }
                    turnNum = turnNum +1; 
                    turn = true;
                }// O's move
                if (validity == 2) gameOver = true;

        }// end game play

        sc.close();
     }// end main
}// end class TicTacToe
