public abstract class Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Piece(){

  }

  public Piece(Board gameBoard, Player playerColor, Square loc){
    board = gameBoard;//the board the game is played on
    color = playerColor.getColor();//keeps track of Player color, either black or white
    location = loc;//keeps track of which Square the Piece is located on
    moved = false;//just created the piece, so hasn't moved yet
  }

  public String getColor(){
    return color;//returns the Player color, either white or black
  }

  public Square getLocation(){
    return location;//returns the Square the Piece is located at
  }

  public void isMoved() {
    moved = true;
  }

  public void setLocation(Square newLocation){
    location = newLocation;//sets its location to the new one
  }

  public abstract boolean checkValidMove(Square newLocation);

  public abstract boolean isPawn();

  //returns true or false depending on if the Pawn can be promoted
  public boolean promote(){
    if(this.isPawn()){//check if you are a pawn
      //store the current location of the Piece
      int row = location.getRow();

      if(color.equals("white") && row == 0){//white pawn has reached the top of the board
        return true;
      }
      if(color.equals("black") && row == 7){//black pawn has reached the bottom of the board
        return true;
      }
      return false;
    }
    return false;//if not a Pawn, cannot promote
  }


}
