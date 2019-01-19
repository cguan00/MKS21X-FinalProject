import java.util.ArrayList;

public class Bishop extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Bishop(Board gameBoard, Player playerColor, Square loc){
    // super(gameBoard, playerColor, loc);
    super();
    board = gameBoard;//the board the game is played on
    color = playerColor.getColor();//keeps track of Player color, either black or white
    location = loc;//keeps track of which Square the Piece is located on
    moved = false;//just created the piece, so hasn't moved yet
  }

  public boolean checkValidMove(Square newLocation){
    //store the current location of the Piece
    int row = location.getRow();
    int col = location.getCol();

    //store the possible locations the Piece can move to
    ArrayList<Square> validSquares = new ArrayList<>();

    for(int i = row; i < 7; i++){
      if(board.getSquare(row + i, col + i).getPiece() == null){//no piece to the Square in bottom right
        validSquares.add(board.getSquare(row + i, col + i));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + i, col + i).getPiece() != null){//if there is piece in the Square in bottom right...
        if(!board.getSquare(row + i, col + i).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row + i, col + i));//add this Square to list of possible Squares
        }
      }

      if(board.getSquare(row + i, col - i).getPiece() == null){//no piece to the Square in upper right
        validSquares.add(board.getSquare(row + i, col - i));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + i, col - i).getPiece() != null){//if there is piece in the Square in upper right...
        if(!board.getSquare(row + i, col - i).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row + i, col - i));//add this Square to list of possible Squares
        }
      }
    }
    for(int i = row; i > 0; i--){
      if (row - i >= 0 && col + i < 8) {
        if(board.getSquare(row - i, col + i).getPiece() == null){//no piece to the Square in bottom left
          validSquares.add(board.getSquare(row - i, col + i));//add this Square to list of possible Squares
        }
        if(board.getSquare(row - i, col + i).getPiece() != null){//if there is piece in the Square in bottom left...
          if(!board.getSquare(row - i, col + i).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
            validSquares.add(board.getSquare(row - i, col + i));//add this Square to list of possible Squares
          }
        }
      }
      if (row - i >= 0 && col - i >= 0) {
        if(board.getSquare(row - i, col - i).getPiece() == null){//no piece to the Square in upper left
          validSquares.add(board.getSquare(row - i, col - i));//add this Square to list of possible Squares
        }
        if(board.getSquare(row - i, col - i).getPiece() != null){//if there is piece in the Square in upper left...
          if(!board.getSquare(row - i, col - i).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
            validSquares.add(board.getSquare(row - i, col - i));//add this Square to list of possible Squares
          }
        }
      }
    }

    //if the new location is in list of valid Squares you can move to, return true
    //otherwise, it is not a valid move, so return false
    if(validSquares.contains(newLocation)){
      return true;
    }
    return false;
  }

  public String getColor(){
    return color;//returns the Player color, either white or black
  }

  public Square getLocation() {
    return location;
  }

  public void setLocation(Square newLocation){
    location = newLocation;//sets its location to the new one
  }

  public boolean isPawn(){
    return false;
  }

  public String toString(){
    if(color.equals("white")){
      return "B";//white pieces are capitalized
    }else{
      return "b";//black pieces are lowercase
    }
  }

}
