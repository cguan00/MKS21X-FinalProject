import java.util.ArrayList;

public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    Square[][] squares = new Square[8][8]; //sets up an 8 by 8 array of squares
    Piece[][] pieces = new Piece[2][16]; //sets up a 2 by 16 array of pieces, one row for each player
    Player color = new Player("black"); //uses this to initialize the pieces
    PieceSet pieceSet = new PieceSet(color);
    pieceSet.initialPieces(this);
    for (int i = 0; i < 2; i++) { //creates a black pieceSet and copies over the Pieces
      for (int x = 0; x < 16; x++) {
        pieces[i][x] = pieceSet.getPiece(x);
      }
      color = new Player("white");
      pieceSet = new PieceSet(color); //now create a white pieceSet
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
