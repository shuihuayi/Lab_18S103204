package Chess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Chess {
	
	ArrayList<String> list= new ArrayList<String>();

    /**
     * @param args
     */

	public void start(){
		Board gameBoard = new Board();
        String color = "white";
        boolean drawAvailable = false;
        System.out.println(gameBoard);
	}
	

    public void play(){
        // TODO Auto-generated method stub

        Board gameBoard = new Board();
        String color = "white";

        boolean drawAvailable = false;

        while(true){

            System.out.println(gameBoard);

            System.out.println(color + " make a move: ");
            Scanner sc = new Scanner(System.in);
            String move = sc.nextLine();
            list.add(color+":"+move);

            if(drawAvailable){
                if(move.contains("draw")){
                    System.out.println("The game is a draw.");
                    return;
                }else{
                    drawAvailable = false;
                }
            }

            if(move.contains("resign")){
                System.out.println(color + " resigns");
                System.out.println(colorToggle(color) + " wins the game!");
                return;
            }
            
            if(move.contains("end")){
                System.out.println("game is over\n");
                int size = list.size();
                for(int i=0;i<size;i++){
                	 System.out.println(list.get(i)+"\n");
                }
                System.out.println(colorToggle(color) + " wins the game!");
                return;
            }


            try {
                gameBoard.performMove(move, color, true);
            } catch (IOException e) {
                // Ask for user input again
                System.out.println("Invalid input!");
                continue;
            }

            Piece[][] oldBoard = gameBoard.board.clone();

            if(!gameBoard.canAnyPieceMakeAnyMove(colorToggle(color))){
                if(gameBoard.isInCheck(colorToggle(color))){
                    System.out.println("Checkmate. " + color + " wins");
                    System.out.println("Game over!");
                }else{
                    System.out.println("Stalemate!");
                }
                return;
            }

            gameBoard.board = oldBoard;

            if(gameBoard.isInCheck(colorToggle(color))){
                System.out.println(colorToggle(color) + " is in check.");
            }

            if(move.contains("draw?")){
                drawAvailable = true;
            }

            //Now I have to check to see if either player is in check or checkmate
            //I also have to see if there is a stalemate

            color = colorToggle(color);

        }

    }
    

    public static String colorToggle(String color){
        if(color.equals("white")){
            return "black";
        }

        return "white";
    }

}
