/**
 *
 * @author Son
 */


import java.util.Scanner;

public class Referee {
    
    public static void main(String[] agrs){
    Player player1 = new AiPlayer();
    Player player2 = new HumanPlayer();

    GameSquenece game = new GameSquenece(player1, player2);
    game.round();
    
    System.out.println("Types play to start the game!!! ");
    Scanner input1 = new Scanner(System.in);
    
   String start= input1.next();
   
   if(start.equals("play")){
       
   }
    
    
    }
   
    
}