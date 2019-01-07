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
    int currentRow = location.getRow();
    int currentCol = location.getCol();
    int newRow = newLocation.getRow();
    int newCol = newLocation.getCol();
    if(currentRow != newRow && currentCol != newCol){
      return false;//can't change row and col at the same time. would be moving diagonally
    }
  }

  public String toString(){
    if(color.equals("white")){
      return "R";//white pieces are capitalized
    }
    if(color.equals("black")){
      return "r";//black pieces are lowercase
    }
  }

}
