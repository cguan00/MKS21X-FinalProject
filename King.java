public class King extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public King(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation){
    return true;
  }

  public String toString(){
    if(color.equals("white")){
      return "K";//white pieces are capitalized
    }
    if(color.equals("black")){
      return "k";//black pieces are lowercase
    }
  }

}
