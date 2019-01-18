import java.util.ArrayList;

public class PieceSet{
  public ArrayList<Piece> pieces = new ArrayList<>();
  public Player color;

  public PieceSet(Player playerColor){
    color = playerColor;
  }

  public void initialPieces(Board board){
    if (color.isBlack()) {
      pieces.add(new Rook(board, color, board.getSquare(0,0)));
      pieces.add(new Knight(board, color, board.getSquare(0,1)));
      pieces.add(new Bishop(board, color, board.getSquare(0,2)));
      pieces.add(new Queen(board, color, board.getSquare(0,3)));
      pieces.add(new King(board, color, board.getSquare(0,4)));
      pieces.add(new Bishop(board, color, board.getSquare(0,5)));
      pieces.add(new Knight(board, color, board.getSquare(0,6)));
      pieces.add(new Rook(board, color, board.getSquare(0,7)));
      for (int i = 0; i < 8; i++) {
        pieces.add(new Pawn(board, color, board.getSquare(1,i)));
      }
    }
    if (color.isWhite()) {
      pieces.add(new Rook(board, color, board.getSquare(7,0)));
      pieces.add(new Knight(board, color, board.getSquare(7,1)));
      pieces.add(new Bishop(board, color, board.getSquare(7,2)));
      pieces.add(new Queen(board, color, board.getSquare(7,3)));
      pieces.add(new King(board, color, board.getSquare(7,4)));
      pieces.add(new Bishop(board, color, board.getSquare(7,5)));
      pieces.add(new Knight(board, color, board.getSquare(7,6)));
      pieces.add(new Rook(board, color, board.getSquare(7,7)));
      for (int i = 0; i < 8; i++) {
        pieces.add(new Pawn(board, color, board.getSquare(6,i)));
      }
    }
  }

  public Piece getPiece(int index) {
    return pieces.get(index);
  }

  public void remove(Piece piece) {
    pieces.remove(piece);
  }
}
