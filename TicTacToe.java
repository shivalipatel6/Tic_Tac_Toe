import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TicTacToe {
    public static int turnNum = 1; 
    public static int XWins = 0;
    public static int OWins = 0;
    public static int Ties = 0;


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


    public static int MakeMove(String[][] gameBoard, boolean turn, String input) {
    // method returns turnCondition at the end if inputs are valid
    int turnCondition = 1;
    if (input.equals("resign")) {
        if (turn){
            System.out.println("O's wins");
            OWins++;
        } 
        else{
             System.out.println("X's wins");
             XWins++;
        }
        return 2;
    }// resign condition


    if(turnNum < 5){
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
}// this is before any win condition is possible
else if(turnNum <= 9){
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
        return 0;
        }// repeat answer

        if(turn){
          for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i][0] != null && gameBoard[i][1] != null && gameBoard[i][2] != null){
            if(gameBoard[i][0].equals("X") && gameBoard[i][1].equals("X") && gameBoard[i][2].equals("X") ){
                gameBoardPrint(gameBoard);
                System.out.println("X Wins!");
                XWins++;
                return 2;
            }// row win condition
             }// checking for null values before comparison
          }// loop through the rows checking for a row win for X
       
            
            for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[0][i] != null && gameBoard[1][i] != null && gameBoard[2][i] != null){    
            if(gameBoard[0][i].equals("X") && gameBoard[1][i].equals("X") && gameBoard[2][i].equals("X") ){
                gameBoardPrint(gameBoard);
                System.out.println("X Wins!");
                XWins++;
                return 2;
            }// column win condition
            }// checking for null values
          }// loop through the columns checking for a row win for X
        

        if(gameBoard[0][0] != null && gameBoard[1][1] != null && gameBoard[2][2] != null ){
        if(gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][2].equals("X") ){
                 gameBoardPrint(gameBoard);
                System.out.println("X Wins!");
                XWins++;
                return 2;
            }// diagonal win condition
        }// checking for null values

        if(gameBoard[2][0] != null && gameBoard[1][1] != null && gameBoard[0][2] != null){
            if(gameBoard[2][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[0][2].equals("X") ){
                 gameBoardPrint(gameBoard);
                System.out.println("X Wins!");
                XWins++;
                return 2;
            }// diagonal win condition
        }// checking for null values.

        }//checking for X win conditions based off of current input.
        else{

            for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i][0] != null && gameBoard[i][1] != null && gameBoard[i][2] != null){    
            if(gameBoard[i][0].equals("O") && gameBoard[i][1].equals("O") && gameBoard[i][2].equals("O") ){
                 gameBoardPrint(gameBoard);
                System.out.println("O Wins!");
                OWins++;
                return 2;
            }// row win condition
          }// loop through the rows checking for a row win for O
        }// checking for null values first
            
            for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[0][i] != null && gameBoard[1][i] != null && gameBoard[2][i] != null){    
            if(gameBoard[0][i].equals("O") && gameBoard[1][i].equals("O") && gameBoard[2][i].equals("O") ){
                 gameBoardPrint(gameBoard);
                System.out.println("O Wins!");
                OWins++;
                return 2;
            }// coulmn win condition
            }// checking for null values
          }// loop through the cloumns checking for a row win for O

          if(gameBoard[0][0] != null && gameBoard[1][1] != null && gameBoard[2][2] != null){
        if(gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][2].equals("O") ){
                 gameBoardPrint(gameBoard);
                System.out.println("O Wins!");
                OWins++;
                return 2;
            }// diagonal win condition
        }// checking for null values

        if(gameBoard[2][0] != null && gameBoard[1][1] != null && gameBoard[0][2] != null){
            if(gameBoard[2][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[0][2].equals("O") ){
                 gameBoardPrint(gameBoard);
                System.out.println("O Wins!");
                OWins++;
                return 2;
            }// diagonal win condition
        }// checking for null values

        }//checking for O win conditions based off of current input.
    }// end if input is 2 charaters
    else{
        return 0;
    }// end the input condition
// the peice will be placed check for win condition.


}// turns 5-9 to check for win conditions

if(turnNum == 9 ){
        gameBoardPrint(gameBoard);
        System.out.println("Tie");
        Ties++;
        turnCondition = 2;
}// goes into here if the turnNum is 9 and there isn't a win condition. returns 2.


   // either returns 1 (regular turn) or 2 (draw offered)
   return turnCondition;
    }//end MakeMove



     public static void main(String args[]) {
        try{        
            Scanner scn = new Scanner(new File("../Tic_Tac_Toe/data/gamedata.txt"));
            if(!scn.hasNext()) {
                System.out.println("File Empty");
                scn.close();
                return;
            }// scanner is empty
            XWins = Integer.parseInt(scn.nextLine());
            OWins = Integer.parseInt(scn.nextLine());
            Ties = Integer.parseInt(scn.nextLine());
            scn.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error: Missing File");
        }
// loading in previous game staticstics from other games. 


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
                validity = MakeMove(gameBoard, turn, xMove);
                while (validity == 0) {
                    System.out.println("Illegal move, try again");
                    System.out.print("X's move: ");
                    xMove = sc.nextLine();
                    validity = MakeMove(gameBoard, turn, xMove);
                }
                turnNum = turnNum + 1;
                turn = false;
            }// X's turn
            else{
                    System.out.print("O's move: ");
                    String oMove = sc.nextLine();
                    validity = MakeMove(gameBoard, turn, oMove);
    
                    // checks validity of move and switches turn if valid
                    while (validity == 0) {
                        System.out.println("Illegal move, try again");
                        System.out.print("O's move: ");
                        oMove = sc.nextLine();
                        validity = MakeMove(gameBoard, turn, oMove);
                    }
                    turnNum = turnNum +1; 
                    turn = true;
                }// O's move
                if (validity == 2) gameOver = true;

        }// end game play
        System.out.println("Game Stats:");
        System.out.print("X Wins:" + XWins );
        System.out.print("  O Wins:" + OWins );
        System.out.print("  Ties:" + Ties );
        
        try {
            FileWriter fw = new FileWriter("../Tic_Tac_Toe/data/gamedata.txt");
            String returnString = XWins + "\n" + OWins + "\n" + Ties;
            fw.write(returnString);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: Missing File");
        }

        sc.close();
     }// end main
}// end class TicTacToe
