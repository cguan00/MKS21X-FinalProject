public class Rook extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Rook(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation){
    //assign variables to hold int values of rows and cols to avoid repetitive code
    int currentRow = location.getRow();
    int currentCol = location.getCol();
    int newRow = newLocation.getRow();
    int newCol = newLocation.getCol();

    //if the Square is not part of the 8x8 board, throw exception
    if(newRow >= 9 || newCol >= 9){
      throw new IllegalArgumentException();
    }

    if(currentRow != newRow && currentCol != newCol){
      return false;//can't change row and col at the same time. would be moving diagonally
    }
    if(currentCol == newCol && currentRow != newRow){//moving vertically
      if(color.equals("white")){
        if(newRow > currentRow){
          return false;//white rook trying to move backward. not valid move
        }
      }
      if(color.equals("black")){
        if(newRow < currentRow){
          return false;//black rook trying to move backward. not valid move
        }
      }
    }
    if(currentCol != newCol && currentRow == newRow){//moving horizontally
      return true;
    }
    return true;
  }

  public String toString(){
    if(color.equals("white")){
      return "R";//white pieces are capitalized
    } else{
      return "r";//black pieces are lowercase
    }
  }

}
