public class Square{
  public int row;
  public int col;
  private Piece piece;

  public Square(int inputRow, int inputCol){
    row = inputRow;//set row to inputted value
    col = inputCol;//set col to inputted value
  }

  public int getRow(){
    return row;//returns int row of the Square
  }

  public int getCol(){
    return col;//returns int col of the Square
  }

  public void storePiece(Piece newPiece) {
    piece = newPiece;
  }

  public Piece getPiece() {
    return piece;
  }

}
