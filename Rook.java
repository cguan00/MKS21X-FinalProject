import java.util.ArrayList;

public class Rook extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Rook(Board gameBoard, Player playerColor, Square loc){
    super(gameBoard, playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation){
    //store the current location of the Piece
    int row = location.getRow();
    int col = location.getCol();

    //store the possible locations the Piece can move to
    ArrayList<Square> validSquares = new ArrayList<>();

    //add valid Squares the piece can move to vertically
    for(int i = 0; i < 7; i++){
      if(i != row){//can't move a Piece to the Square it's already on
        // if(board.getSquare(i, col).isEmpty()){//check if this Square is empty
        //   validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
        // }
      }
    }
    
    //add valid Squares the piece can move to horizontally
    for(int j = 0; j < 7; j++){
      if(j != col){//can't move a Piece to the Square it's already on
      // if(board.getSquare(row, j).isEmpty()){//check if this Square is empty
      //   validSquares.add(board.getSquare(row, j));//add this Square to list of possible Squares
      // }
      }
    }

    //if the new location is in list of valid Squares you can move to, return true
    //otherwise, it is not a valid move, so return false
    if(validSquares.contains(newLocation)){
      return true;
    }
    return false;
  }

  // public boolean checkValidMove(Square newLocation){
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
  //   if(currentRow != newRow && currentCol != newCol){
  //     return false;//can't change row and col at the same time. would be moving diagonally
  //   }
  //   if(currentCol == newCol && currentRow != newRow){//moving vertically
  //     if(color.equals("white")){
  //       if(newRow > currentRow){
  //         return false;//white rook trying to move backward. not valid move
  //       }
  //     }
  //     if(color.equals("black")){
  //       if(newRow < currentRow){
  //         return false;//black rook trying to move backward. not valid move
  //       }
  //     }
  //   }
  //   if(currentCol != newCol && currentRow == newRow){//moving horizontally
  //     return true;
  //   }
  //   return true;
  // }

  public String toString(){
    if(color.equals("white")){
      return "R";//white pieces are capitalized
    } else{
      return "r";//black pieces are lowercase
    }
  }

}
