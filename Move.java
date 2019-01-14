public class Move {
  private int currentRow;
  private int currentColumn;
  private int newRow;
  private int newColumn;
  private Piece currentPiece;

  public Move(Board board, Player color, String current, String destination) {
    String columns = "ABCDEFGH";
    String rows = "12345678";
    currentRow = rows.indexOf(current.charAt(1)); //the original row is stored
    currentColumn = columns.indexOf(current.charAt(0)); //the original column is stored
    newRow = rows.indexOf(destination.charAt(1)); //the new row is stored
    newColumn = columns.indexOf(destination.charAt(0)); //the new column is stored
    currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
    board.getSquare(currentRow,currentColumn).storePiece(null); //the original square now doesn't have a piece
    board.getSquare(newRow,newColumn).storePiece(currentPiece); //the new square now gets the piece
  }

  public Move(Board board, Player color, Square currentLoc, Square newLoc) {
    currentPiece = currentLoc.getPiece(); //the piece to be moved is stored
    currentLoc.storePiece(null); //the original square now doesn't have a piece
    newLoc.storePiece(currentPiece); //the new square now gets the piece
    currentPiece.setLocation(newLoc); //sets the location of the piece to the new square
  }

}
