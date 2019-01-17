import java.util.ArrayList;

public class Knight extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Knight(Board gameBoard, Player playerColor, Square loc){
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

    //check Square marked #1 on diagram
    int row1 = row - 1;//one square up...
    int col1 = col - 2;//...and one square to the right
    if(row1 > -1 && col1 > -1){//avoid index out of bounds exception
      if(board.getSquare(row1, col1).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row1, col1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row1, col1).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row1, col1).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row1, col1));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #2 on diagram
    int row2 = row - 2;//one square up...
    int col2 = col - 1;//...and one square to the right
    if(row2 > -1 && col2 > -1){//avoid index out of bounds exception
      if(board.getSquare(row2, col2).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row2, col2));//add this Square to list of possible Squares
      }
      if(board.getSquare(row2, col2).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row2, col2).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row2, col2));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #3 on diagram
    int row3 = row - 2;//one square up...
    int col3 = col + 1;//...and one square to the right
    if(row3 > -1 && col3 < 8){//avoid index out of bounds exception
      if(board.getSquare(row3, col3).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row3, col3));//add this Square to list of possible Squares
      }
      if(board.getSquare(row3, col3).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row3, col3).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row3, col3));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #4 on diagram
    int row4 = row - 1;//one square up...
    int col4 = col + 2;//...and one square to the right
    if(row4 > -1 && col4 < 8){//avoid index out of bounds exception
      if(board.getSquare(row4, col4).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row4, col4));//add this Square to list of possible Squares
      }
      if(board.getSquare(row4, col4).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row4, col4).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row4, col4));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #5 on diagram
    int row5 = row + 1;//one square up...
    int col5 = col + 2;//...and one square to the right
    if(row5 < 8 && col5 < 8){//avoid index out of bounds exception
      if(board.getSquare(row5, col5).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row5, col5));//add this Square to list of possible Squares
      }
      if(board.getSquare(row5, col5).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row5, col5).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row5, col5));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #6 on diagram
    int row6 = row + 2;//one square up...
    int col6 = col + 1;//...and one square to the right
    if(row6 < 8 && col6 < 8){//avoid index out of bounds exception
      if(board.getSquare(row6, col6).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row6, col6));//add this Square to list of possible Squares
      }
      if(board.getSquare(row6, col6).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row6, col6).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row6, col6));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #7 on diagram
    int row7 = row + 2;//one square up...
    int col7 = col - 1;//...and one square to the right
    if(row7 < 8 && col7 > -1){//avoid index out of bounds exception
      if(board.getSquare(row7, col7).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row7, col7));//add this Square to list of possible Squares
      }
      if(board.getSquare(row7, col7).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row7, col7).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row7, col7));//add this Square to list of possible Squares
        }
      }
    }

    //check Square marked #8 on diagram
    int row8 = row + 1;//one square up...
    int col8 = col - 2;//...and one square to the right
    if(row8 < 8 && col8 > -1){//avoid index out of bounds exception
      if(board.getSquare(row8, col8).getPiece() == null){//no piece to the Square in
        validSquares.add(board.getSquare(row8, col8));//add this Square to list of possible Squares
      }
      if(board.getSquare(row8, col8).getPiece() != null){//if there is piece in the Square...
        if(!board.getSquare(row8, col8).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row8, col8));//add this Square to list of possible Squares
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
      return "N";//white pieces are capitalized
    } else {
      return "n";//black pieces are lowercase
    }
  }

}
