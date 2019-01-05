public abstract class Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public abstract boolean checkValidMove();

  public Piece(Player playerColor, Square loc){
    color = playerColor;
    location = loc;
  }

  public Player getColor(){
    return color;
  }

  public Square getLocation(){
    return location;
  }

}
