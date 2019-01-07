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

  public Square getStart() {
    return start; //returns the current Square of the piece to be moved
  }

  public Square getEnd() {
    return end; //returns the Square that the piece is going to be moved to
  }

  public Piece getPieceMoved() {
    return pieceMoved; //returns the piece that is to be moved
  }

  public Piece getPieceCaptured() {
    return pieceCaptured; //returns the piece that's captured
  }
}
