public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    squares = new Square[8][8];
    pieceSets = new Piece[4][16]; //what should the dimensions be?
  }

  //returns the pieceSets
  public Piece[][] getPieceSets() {
    return pieceSets;
  }

  //return the square
  public Square getSquare(int row, int col){
    return squares[row][col];
  }

}
