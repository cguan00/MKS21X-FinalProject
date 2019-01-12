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

    if(row < 6 && col < 6){
      //checking the Square marked #4 on project prototype diagram
      if(board.getSquare(row - 1 , col + 2).getPiece() == null){//no piece to the Square in this square
        validSquares.add(board.getSquare(row - 1, col + 2));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 1, col + 2).getPiece() != null){//if there is piece in the Square in upper left...
        if(!board.getSquare(row - 1, col + 2).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row - 1, col + 2));//add this Square to list of possible Squares
        }
      }

      //checking the Square marked #3 on project prototype diagram
      if(board.getSquare(row - 2, col + 1).getPiece() == null){//no piece to the Square in this square
        validSquares.add(board.getSquare(row - 2, col + 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 2, col + 1).getPiece() != null){//if there is piece in the Square in this square
        if(!board.getSquare(row - 2, col + 1).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row - 2, col + 1));//add this Square to list of possible Squares
        }
      }
    }

    if(row > 1 && col > 1){
      //checking the Square marked #2 on project prototype diagram
      if(board.getSquare(row - 2 , col - 1).getPiece() == null){//no piece to the Square in this square
        validSquares.add(board.getSquare(row - 1, col - 1));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 2, col - 1).getPiece() != null){//if there is piece in this Square...
        if(!board.getSquare(row - 2, col - 1).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row - 2, col - 1));//add this Square to list of possible Squares
        }
      }

      //checking the Square marked #1 on project prototype diagram
      if(board.getSquare(row - 1, col - 2).getPiece() == null){//no piece to the Square in this square
        validSquares.add(board.getSquare(row - 1, col - 2));//add this Square to list of possible Squares
      }
      if(board.getSquare(row - 1, col - 2).getPiece() != null){//if there is piece in the Square in upper left...
        if(!board.getSquare(row - 1, col - 2).getPiece().getColor().equals(color)){//...and this piece is an opponent's piece (different color)
          validSquares.add(board.getSquare(row - 1, col - 2));//add this Square to list of possible Squares
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

  public String toString(){
    if(color.equals("white")){
      return "N";//white pieces are capitalized
    } else {
      return "n";//black pieces are lowercase
    }
  }

}
