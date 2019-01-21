import java.util.ArrayList;

public class PieceSet{
  public ArrayList<Piece> pieces = new ArrayList<>();
  public Player color;
  private Piece blackKing;
  private Piece whiteKing;
  private ArrayList<Piece> pawns = new ArrayList<>();

  public PieceSet(Player playerColor){
    color = playerColor;
  }

  //adding all the pieces to set up the board
  public void initialPieces(Board board){
    if (color.isBlack()) {
      pieces.add(new Rook(board, color, board.getSquare(0,0)));
      pieces.add(new Knight(board, color, board.getSquare(0,1)));
      pieces.add(new Bishop(board, color, board.getSquare(0,2)));
      pieces.add(new Queen(board, color, board.getSquare(0,3)));
      blackKing = new King(board, color, board.getSquare(0,4)); //this king is stored for later use
      pieces.add(blackKing);
      pieces.add(new Bishop(board, color, board.getSquare(0,5)));
      pieces.add(new Knight(board, color, board.getSquare(0,6)));
      pieces.add(new Rook(board, color, board.getSquare(0,7)));
      for (int i = 0; i < 8; i++) {
        Piece blackPawn = new Pawn(board, color, board.getSquare(1,i));
        pieces.add(blackPawn);
        pawns.add(blackPawn);
      }
    }
    if (color.isWhite()) {
      pieces.add(new Rook(board, color, board.getSquare(7,0)));
      pieces.add(new Knight(board, color, board.getSquare(7,1)));
      pieces.add(new Bishop(board, color, board.getSquare(7,2)));
      pieces.add(new Queen(board, color, board.getSquare(7,3)));
      whiteKing = new King(board, color, board.getSquare(7,4)); //king is stored for later use
      pieces.add(whiteKing);
      pieces.add(new Bishop(board, color, board.getSquare(7,5)));
      pieces.add(new Knight(board, color, board.getSquare(7,6)));
      pieces.add(new Rook(board, color, board.getSquare(7,7)));
      for (int i = 0; i < 8; i++) {
        Piece whitePawn = new Pawn(board, color, board.getSquare(6,i));
        pieces.add(whitePawn);
        pawns.add(whitePawn);
      }
    }
  }

  //returns the Piece at the given index
  public Piece getPiece(int index) {
    return pieces.get(index);
  }

  //adds the piece
  public void addPiece(Piece newPiece) {
    pieces.add(newPiece);
  }

  //remove the piece
  public void remove(Piece piece) {
    pieces.remove(piece);
    pawns.remove(piece);
  }

  //returns the white king
  public Piece getWhiteKing() {
    return whiteKing;
  }

  //returns the black king
  public Piece getBlackKing() {
    return blackKing;
  }

  //returns the pawn
  public Piece getPawn(int index) {
    return pawns.get(index);
  }

  //return the number of pawns in pawns array list
  public int getPawnSize() {
    return pawns.size();
  }

  //size of piece set
  public int size() {
    return pieces.size();
  }

  //returns true if piece is in the set
  //returns false if the piece is not in the set
  public boolean hasPiece(Piece piece) {
    return pieces.contains(piece);
  }
}
