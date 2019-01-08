public class Queen extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Queen(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation){
    return true;
  }

  public String toString(){
    if(color.equals("white")){
      return "Q";//white pieces are capitalized
    } else {
      return "q";//black pieces are lowercase
    }
  }

}
