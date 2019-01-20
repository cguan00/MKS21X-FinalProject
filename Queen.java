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
    //moving vertically up
    boolean validUp = true;
    int i = row - 1;//one row above
    while(validUp && i > -1){
      if(board.getSquare(i, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(i, col).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(i, col).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validUp = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(i, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
          validUp = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      i--;
    }

    //moving vertically down
    boolean validDown = true;
    int b = row + 1;//one row below
    while(validDown && b < 8){
      if(board.getSquare(b, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(b, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(b, col).getPiece() != null){//if this Square has a piece...
        if(board.getSquare(b, col).getPiece().getColor().equals(color)){//...and this piece is part of your own pieceSet
          validDown = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(b, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(b, col));//add this Square to list of possible Squares
          validDown = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      b++;
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


    //POSSIBLE DIAGONAL MOVES - SAME AS BISHOP
    //check squares to bottom right
    boolean validBottomRight = true;//variable to keep checking for valid moves
    int row1 = row + 1;//one square down...
    int col1 = col + 1;//... and one square to the right
    while(validBottomRight && row1 < 8 && col1 < 8){//avoid index out of bounds exception
      if(board.getSquare(row1, col1).getPiece() == null){//no piece to the Square in bottom right
        validSquares.add(board.getSquare(row1, col1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row1, col1).getPiece() != null){//if there is piece in the Square in bottom right...
        if(board.getSquare(row1, col1).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validBottomRight = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row1, col1).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row1, col1));//add this Square to list of possible Squares
          validBottomRight = false;//break out of the while loop. cannot keep moving past opponent's piece
        }
      }
      row1++;
      col1++;
    }

    //check squares to upper right
    boolean validUpperRight = true;//variable to keep checking for valid moves
    int row2 = row - 1;//one square up...
    int col2 = col + 1;//...and one square to the right
    while(validUpperRight && row2 > -1 && col2 < 8){//avoid index out of bounds exception
      if(board.getSquare(row2, col2).getPiece() == null){//no piece to the Square in upper right
        validSquares.add(board.getSquare(row2, col2));//add this Square to list of possible Squares
      }
      if(board.getSquare(row2, col2).getPiece() != null){//if there is piece in the Square in upper right...
        if(board.getSquare(row2, col2).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validUpperRight = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row2, col2).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row2, col2));//add this Square to list of possible Squares
          validUpperRight = false;//break out of the while loop. cannot jump over opponent's piece
        }
      }
      row2--;
      col2++;
    }

    //check squares to upper left
    boolean validUpperLeft = true;//variable to keep checking for valid moves
    int row3 = row - 1;//one square up...
    int col3 = col - 1;//...and one square to the left
    while(validUpperLeft && row3 > -1 && col3 > -1){//avoid index out of bounds exception
      if(board.getSquare(row3, col3).getPiece() == null){//no piece to the Square in upper left
        validSquares.add(board.getSquare(row3, col3));//add this Square to list of possible Squares
      }
      if(board.getSquare(row3, col3).getPiece() != null){//if there is piece in the Square in upper left...
        if(board.getSquare(row3, col3).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validUpperLeft = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row3, col3).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row3, col3));//add this Square to list of possible Squares
          validUpperLeft = false;//break out of the while loop. cannot jump over opponent's piece
        }
      }
      row3--;
      col3--;
    }

    //check squares to bottom left
    boolean validBottomLeft = true;//variable to keep checking for valid moves
    int row4 = row + 1;//one square down...
    int col4 = col - 1;//and one square to the left
    while(validBottomLeft && row4 < 8 && col4 > -1){//avoid index out of bounds exception
      if(board.getSquare(row4, col4).getPiece() == null){//no piece to the Square in bottom left
        validSquares.add(board.getSquare(row4, col4));//add this Square to list of possible Squares
      }
      if(board.getSquare(row4, col4).getPiece() != null){//if there is piece in the Square in bottom left...
        if(board.getSquare(row4, col4).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validBottomLeft = false;//break out of the while loop. cannot jump over your own piece
        }
        if(!board.getSquare(row4, col4).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row4, col4));//add this Square to list of possible Squares
          validBottomLeft = false;//break out of the while loop. cannot jump over opponent's piece
        }
      }
      row4++;
      col4--;
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
      return "Q";//white pieces are capitalized
    } else {
      return "q";//black pieces are lowercase
    }
  }

}
