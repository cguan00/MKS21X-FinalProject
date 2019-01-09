public class Rook extends Piece{
  private Player player;
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
    if(newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7){
      throw new IllegalArgumentException();
    }

    if(currentRow != newRow && currentCol != newCol){
      return false;//can't change row and col at the same time. would be moving diagonally
    }
    if(currentCol == newCol && currentRow != newRow){//moving vertically
      if(player.getColor().equals("white")){
        if(newRow > currentRow){
          return false;//white rook trying to move backward. not valid move
        }
      }
      if(player.getColor().equals("black")){
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
    if(player.getColor().equals("white")){
      return "R";//white pieces are capitalized
    } else{
      return "r";//black pieces are lowercase
    }
  }

}
