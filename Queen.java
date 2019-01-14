import java.util.ArrayList;

public class Queen extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Queen(Board gameBoard, Player playerColor, Square loc){
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

    //VERTICAL AND HORIZONTAL MOVES - SAME AS ROOK
    //add valid Squares the piece can move to vertically
    for(int x = 0; x < 7; x++){
      if(x != row){//can't move a Piece to the Square it's already on
        if(board.getSquare(x, col).getPiece() == null){//if this Square is empty
          validSquares.add(board.getSquare(x, col));//add this Square to list of possible Squares
        }
        if(board.getSquare(x, col).getPiece() != null){//if this Square is NOT empty...
          if(!board.getSquare(x, col).getPiece().getColor().equals(color)){//and this piece is opponent's piece
            validSquares.add(board.getSquare(x, col));//add this Square to list of possible Squares
          }
        }
      }
    }

    //add valid Squares the piece can move to horizontally
    for(int y = 0; y < 7; y++){
      if(y != col){//can't move a Piece to the Square it's already on
        if(board.getSquare(row, y).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(row, y));//add this Square to list of possible Squares
        }
        if(board.getSquare(row, y).getPiece() != null){//if this Square is NOT empty...
          if(!board.getSquare(row, y).getPiece().getColor().equals(color)){//and this piece is opponent's piece
            validSquares.add(board.getSquare(row, y));//add this Square to list of possible Squares
          }
        }
      }
    }

    //POSSIBLE DIAGONAL MOVES - SAME AS BISHOP
    for(int i = row; i < 7; i++){
      if(board.getSquare(row + i, col + i).getPiece() == null){//no piece to the Square in bottom right
        validSquares.add(board.getSquare(row + i, col + i));
      }
      if(board.getSquare(row + i, col + i).getPiece() != null){//if bottom right Square is NOT empty...
        if(!board.getSquare(row + i, col + i).getPiece().getColor().equals(color)){//and this piece is opponent's piece
          validSquares.add(board.getSquare(row + i , col + i));//add this Square to list of possible Squares
        }
      }
      if(board.getSquare(row + i, col - i).getPiece() == null){//no piece to the Square in upper right
        validSquares.add(board.getSquare(row + i, col - i));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + i, col - i).getPiece() == null){//if there is piece to the Square in upper right
        if(!board.getSquare(row + i, col - i).getPiece().getColor().equals(color)){//and this piece is opponent's piece
          validSquares.add(board.getSquare(row + i , col - i));//add this Square to list of possible Squares
        }
      }
    }


    for(int i = row; i > 0; i--){
      if (row - i >= 0 && col + i < 8) {
        if(board.getSquare(row - i, col + i).getPiece() == null){//no piece to the Square in bottom left
          validSquares.add(board.getSquare(row - i, col + i));
        }
        if(board.getSquare(row - i, col + i).getPiece() != null){//if there is piece to the Square in bottom left
          if(!board.getSquare(row - i, col + i).getPiece().getColor().equals(color)){//and this piece is opponent's piece
            validSquares.add(board.getSquare(row - i , col + i));//add this Square to list of possible Squares
          }
        }
      }
      if (row - i >= 0 && col - i >= 0) {
        if(board.getSquare(row - i, col - i).getPiece() == null){//no piece to the Square in upper left
          validSquares.add(board.getSquare(row - i, col - i));
        }
        if(board.getSquare(row - i, col - i).getPiece() != null){//if there is piece to the Square in upper left
          if(!board.getSquare(row - i, col - i).getPiece().getColor().equals(color)){//and this piece is opponent's piece
            validSquares.add(board.getSquare(row - i , col - i));//add this Square to list of possible Squares
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

  public Square getLocation() {
    return location;
  }

  public void setLocation(Square newLocation){
    location = newLocation;//sets its location to the new one
  }

  public String getColor(){
    return color;//returns the Player color, either white or black
  }

  public String toString(){
    if(color.equals("white")){
      return "Q";//white pieces are capitalized
    } else {
      return "q";//black pieces are lowercase
    }
  }

}
