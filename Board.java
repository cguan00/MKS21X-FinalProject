import java.util.ArrayList;

public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    squares = new Square[8][8]; //sets up an 8 by 8 array of squares
    pieceSets = new Piece[2][16]; //sets up a 2 by 16 array of pieces, one row for each player
  }

  public void setPieceSets(PieceSet blackPieces, PieceSet whitePieces) {
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        if (i == 0) {
          pieceSets[i][x] = blackPieces.getPiece(x); //copies over the black pieces
        }
        if (i == 1) {
          pieceSets[i][x] = whitePieces.getPiece(x);
        }
      }
    }
  }

  public void setSquares(PieceSet blackPieces, PieceSet whitePieces) {
    System.out.println(blackPieces.getPiece(0));
    int row = 0;
    for (int i = 0; i < 16; i++) {
      for (int x = 0; x < 8; x++) {
        squares[row][x].storePiece(blackPieces.getPiece(i%8));
      }
      row = 1;
    }
    row = 7;
    for (int i = 0; i < 16; i++) {
      for (int x = 0; x < 8; x++) {
        squares[0][x].storePiece(whitePieces.getPiece(i%8));
      }
      row = 6;
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

  //prints out the array
  public String toString() {
    String ans = "";
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        ans += (pieceSets[i][x]).toString() + " ";
      }
    }
    return ans;
  }

  public static void main(String[] args) {

  }

}
