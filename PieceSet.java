import java.util.ArrayList;

public class PieceSet{
  public ArrayList<Piece> pieces = new ArrayList<>();
  public Player color;

  public PieceSet(Player playerColor){
    color = playerColor;
  }

  public void initialPieces(Board board){
      // pieces.add(new Rook(color, board.getSquare(0,0);
      // pieces.add(new Knight(color, new Square(0,1)));
      // pieces.add(new Bishop(color, new Square(0,2)));
      // pieces.add(new Queen(color, new Square(0,3)));
      // pieces.add(new King(color, new Square(0,4)));
      // pieces.add(new Bishop(color, new Square(0,5)));
      // pieces.add(new Knight(color, new Square(0,6)));
      // pieces.add(new Rook(color, new Square(0,7)));
  }
}
