import java.util.ArrayList;

public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    Square[][] squares = new Square[8][8];
    Piece[][] pieces = new Piece[2][16];
    Player color = new Player("black");
    PieceSet pieceSet = new PieceSet(color);
    pieceSet.initialPieces(this);
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        pieces[i][x] = pieceSet.getPiece(x);
      }
      color = new Player("white");  
    }
  }

  //returns the pieceSets
  public Piece[][] getPieceSets() {
    return pieceSets;
  }

  //return a piece
  public Piece getPiece(int row, int col) {
    return pieceSets[row][col];
  }

  //return the square
  public Square getSquare(int row, int col){
    return squares[row][col];
  }

}
