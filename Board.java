public class Board{
  private Square[][] squares;
  private Piece[][] pieceSets;

  public Board(){
    squares = new Square[8][8];
    pieceSets = new Piece[2][16];
  }

  //stores the pieces in Piece[][] by taking in a white and black PieceSet object
  public void setPieceSets(PieceSet blackPieces, PieceSet whitePieces) {
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 16; x++) {
        if (i == 0) {
          pieceSets[i][x] = blackPieces.getPiece(x); //copies over the black pieces
        }
        if (i == 1) {
          pieceSets[i][x] = whitePieces.getPiece(x); //copies over the white pieces
        }
      }
    }
  }

  //initializes the squares that havce pieces and stores the pieces in those squares
  public void setSquares(PieceSet blackPieces, PieceSet whitePieces) {
    int row = 0;
    int pieceIndex = 0;
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 8; x++) {
        squares[row][x] = new Square(row, x); //initializes the square
        squares[row][x].storePiece(blackPieces.getPiece(pieceIndex)); //the square then stores the correct piece
        pieceIndex += 1; //index increases to get the next piece
      }
      row = 1; //the next row of squares will now go through the same process
    }
    row = 7; //jumps over the rows that will not have pieces
    pieceIndex = 0; //resets because now we're taking in a n
    for (int i = 0; i < 2; i++) {
      for (int x = 0; x < 8; x++) {
        squares[row][x] = new Square(row, x); //initializes the square
        squares[row][x].storePiece(whitePieces.getPiece(pieceIndex)); //stores the piece from the white PieceSet
        pieceIndex += 1; //index increases
      }
      row = 6; //pawns are on the inside
    }
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
