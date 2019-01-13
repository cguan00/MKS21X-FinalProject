public class Move {
  private Square start;
  private Square end;
  private Piece pieceCaptured;
  private Piece pieceMoved;

  public Move(Board board, Player color, String current, String destination) {
    // start = current;
    // end = destination;
    String columns = "ABCDEFGH";
    String rows = "12345678";
    int currentColumn = columns.indexOf(current.charAt(0));
    int currentRow = rows.indexOf(current.charAt(1));
    int newColumn = columns.indexOf(destination.charAt(0));
    int newRow = rows.indexOf(destination.charAt(1));
    Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece();
    currentPiece.setLocation(board.getSquare(currentRow,currentColumn));
    board.getSquare(currentRow,currentColumn).storePiece(null);
    board.getSquare(newRow, newColumn).storePiece(currentPiece);
    // current.storePiece(null);
    // destination.storePiece(currentPiece);
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
