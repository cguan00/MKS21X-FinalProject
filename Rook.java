import java.util.ArrayList;

public class Rook extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Rook(Board gameBoard, Player playerColor, Square loc){
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

    //moving vertically up
    boolean validUp = true;
    int h = row - 1;//one row above
    while(validUp && h > -1){
      if(board.getSquare(h, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(h, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(h, col).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(h, col).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validUp = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(h, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(h, col));//add this Square to list of possible Squares
          validUp = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      h--;
    }

    //moving vertically down
    boolean validDown = true;
    int i = row + 1;//one row below
    while(validDown && i < 8){
      if(board.getSquare(i, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(i, col).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(i, col).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validDown = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(i, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
          validDown = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      i++;
    }

    //checking to the left
    boolean validLeft = true;//variable to keep checking for valid moves
    int j = col - 1;//one row to the left
    while(validLeft && j > -1){
      if(board.getSquare(row, j).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row, j));//add this Square to list of possible Squares
      }
      if(board.getSquare(row, j).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(row, j).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validLeft = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row, j).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row, j));//add this Square to list of possible Squares
          validLeft = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      j--;
    }

    //checking to the right
    boolean validRight = true;//variable to keep checking for valid moves
    int k = col + 1;//one row to the left
    while(validRight && k < 8){
      if(board.getSquare(row, k).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row, k));//add this Square to list of possible Squares
      }
      if(board.getSquare(row, k).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(row, k).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validRight = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row, k).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row, k));//add this Square to list of possible Squares
          validRight = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      k++;
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

  public boolean isPawn(){
    return false;
  }

  public String toString(){
    if(color.equals("white")){
      return "R";//white pieces are capitalized
    } else{
      return "r";//black pieces are lowercase
    }
  }

}
