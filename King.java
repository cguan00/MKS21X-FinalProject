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
    return true;
  }

  // public boolean checkValidMove(Square newLocation) throws IllegalArgumentException{
  //   //assign variables to hold int values of rows and cols to avoid repetitive code
  //   int currentRow = location.getRow();
  //   int currentCol = location.getCol();
  //   int newRow = newLocation.getRow();
  //   int newCol = newLocation.getCol();
  //
  //   //if the Square is not part of the 8x8 board, throw exception
  //   if(newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7){
  //     throw new IllegalArgumentException();
  //   }
  //
  //   //use variables to store how far the piece is trying to move in either direction
  //   int rowDiff = Math.abs(newRow - currentRow);
  //   int colDiff = Math.abs(newCol - currentCol);
  //
  //   if(rowDiff == 1 && colDiff == 0 ){//move one row up or down
  //     return true;
  //   }
  //   if(colDiff == 1 && rowDiff == 0){//move one col to left or right
  //     return true;
  //   }
  //   if(colDiff == 1 && rowDiff == 1){//move diagonally by one square
  //     return true;
  //   }
  //   return false;
  // }

  public String toString(){
    if(color.equals("white")){
      return "K";//white pieces are capitalized
    } else{
      return "k";//black pieces are lowercase
    }
  }

}
