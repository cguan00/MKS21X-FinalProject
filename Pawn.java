public class Pawn extends Piece{
  private Player color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public boolean promoted;
  //set to true if the Pawn has been promoted

  public Piece promoteTo;
  //if promoted, keep track of which Piece the Pawn has been changed to

  public Pawn(Player playerColor, Square loc){
    super(playerColor, loc);
  }

  public boolean checkValidMove(Square newLocation) throws IllegalArgumentException {
    //assign variables to hold int values of rows and cols to avoid repetitive code
    int currentRow = location.getRow();
    int currentCol = location.getCol();
    int newRow = newLocation.getRow();
    int newCol = newLocation.getCol();

    //if the Square is not part of the 8x8 board, throw exception
    if(newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7){
      throw new IllegalArgumentException();
    }

    //if white Pawn is trying to move backwards, not valid move, so return false
     if(color.equals("white")){
       if(newRow > currentRow){
         return false;
       }
     }
     //if black Pawn is trying to move backwards, not valid move, so return false
     if(color.equals("black")){
       if(newRow < currentRow){
         return false;
       }
     }
     return true;
  }

  public String toString(){
    if(color.equals("white")){
      return "P";//white pieces are capitalized
    } else{
      return "p";//black pieces are lowercase
    }
  }


}
