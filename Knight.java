public class Knight extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Knight(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation){
    //assign variables to hold int values of rows and cols to avoid repetitive code
    int currentRow = location.getRow();
    int currentCol = location.getCol();
    int newRow = newLocation.getRow();
    int newCol = newLocation.getCol();

    //if you go two rows over and one col up, it creates valid L-shaped move
    if(Math.abs(newRow - currentRow) == 2 && Math.abs(newCol - currentCol) == 1){
      return true;
    }
    //if you go one row over and two cols up, it creates valid L-shaped move
    if(Math.abs(newRow - currentRow) == 1 && Math.abs(newCol - currentCol) == 2){
      return true;
    }

    //if you don't create L-shaped move, return false
    return false;
  }

}
