public abstract class Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Piece(Board gameBoard, Player playerColor, Square loc){
    board = gameBoard;//the board the game is played on
    color = playerColor;//keeps track of Player color, either black or white
    location = loc;//keeps track of which Square the Piece is located on
    moved = false;//just created the piece, so hasn't moved yet
  }

  public Player getColor(){
    return color;//returns the Player color, either white or black
  }

  public Square getLocation(){
    return location;//returns the Square the Piece is located at
  }

  public abstract boolean checkValidMove(Square newLocation);


}
