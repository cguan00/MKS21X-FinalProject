import java.util.ArrayList;

public class King extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public King(Board gameBoard, Player playerColor, Square loc){
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

    //check one square down
    if(row != 7){//avoid IndexOutOfBounds exception
      //check one square up
      if(board.getSquare(row + 1, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row + 1, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + 1, col).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row + 1, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row + 1, col));//add this Square to list of possible Squares
        }
      }
    }

    //check one square up
    if(row != 0){//avoid IndexOutOfBounds exception
      if(board.getSquare(row - 1, col).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row - 1, col));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 1, col).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row - 1, col).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row - 1, col));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the right
    if(col != 7){//avoid IndexOutOfBounds exception
      if(board.getSquare(row, col + 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row, col + 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row, col + 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row, col + 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row, col + 1));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the left
    if(col != 0){//avoid IndexOutOfBounds exception
      if(board.getSquare(row, col - 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row, col - 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row, col - 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row, col - 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row, col - 1));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the upper right
    if(row != 0 && col != 7){//avoid IndexOutOfBounds exception
      if(board.getSquare(row - 1, col + 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row - 1, col + 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 1, col + 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row - 1, col + 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row - 1, col + 1));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the upper left
    if(row != 0 && col != 0){//avoid IndexOutOfBounds exception
      if(board.getSquare(row - 1, col - 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row - 1, col - 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 1, col - 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row - 1, col - 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row - 1, col - 1));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the bottom right
    if(row != 7 && col != 7){//avoid IndexOutOfBounds exception
      if(board.getSquare(row + 1, col + 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row + 1, col + 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + 1, col + 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row + 1, col + 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row + 1, col + 1));//add this Square to list of possible Squares
        }
      }
    }

    //check one square to the bottom left
    if(row != 7 && col != 0){//avoid IndexOutOfBounds exception
      if(board.getSquare(row + 1, col - 1).getPiece() == null){//if this Square is empty
        validSquares.add(board.getSquare(row + 1, col - 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row + 1, col - 1).getPiece() != null){//if this Square has a piece...
        if(!board.getSquare(row + 1, col - 1).getPiece().getColor().equals(color)){//...and this piece is not part of your own pieceSet (different color)
          validSquares.add(board.getSquare(row + 1, col - 1));//add this Square to list of possible Squares
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
      return "K";//white pieces are capitalized
    } else{
      return "k";//black pieces are lowercase
    }
  }

}
