/* TO-DO: Declare winner in isWinner()
 * TO-DO: display GO in canPeg()
 * @author Son
 */



public class Referee {
    Players playerHuman;
    Players playerAi;
    GameSquence game;
    Board board;


    public Referee(){
        board = new Board();
        playerHuman = new HumanPlayer(board);
        playerAi = new  AiPlayer(board);

        game = new GameSquence(playerHuman, playerAi, board);
    }

    public void start(){
        game.setRef(this);
        game.round();
    }


    //pegging: can they play that 1 card?
    public boolean canPlayCard(Cards a){
        if ((a.valueFinder() + board.getScore()) <= 31) {
            return true;
        } else{
            //display Go
            return false;
        }
    }

    //can they play any card in their hand?
    public boolean canPeg(Players player){
        for (int i = 0; i < player.getHand().size(); i++){
            if (player.getHand().getCard(i).valueFinder() + board.getScore() <= 31){
                return true;
            }
        }
       return false;
    }

    public boolean isWinner(Players p){

        if (p.getScore()<121){
            return false;
        } else{
            //display winner
            return true;
        }

    }
    
    

   
    
}