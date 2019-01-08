public class Bishop extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Bishop(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation) throws IllegalArgumentException{
    //assign variables to hold int values of rows and cols to avoid repetitive code
    int currentRow = location.getRow();
    int currentCol = location.getCol();
    int newRow = newLocation.getRow();
    int newCol = newLocation.getCol();

    //if the Square is not part of the 8x8 board, throw exception
    if(newRow < 0 || newRow >= 9 || newCol < 0 || newCol >= 9){
      throw new IllegalArgumentException();
    }

    int rowDiff = newRow - currentRow;

    //if not moving diagonally. not moving same number of squares verically as horizontally
    if(!(newCol == currentCol + rowDiff || newCol == currentCol - rowDiff)){
      return false;
    }
    return true;
  }

  public String toString(){
    if(color.equals("white")){
      return "B";//white pieces are capitalized
    }else{
      return "b";//black pieces are lowercase
    }
  }

}
