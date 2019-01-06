public class Move {
  private Square start;
  private Square end;
  private Piece pieceCaptured;
  private Piece pieceMoved;

  public Move(Piece currentPiece, Square current, Square destination) {
    start = current;
    end = destination;
    pieceMoved = currentPiece;
    //pieceMoved.checkValidMove();
    //pieceCaptured - what happens to this?
  }
}
