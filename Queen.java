import java.util.ArrayList;

public class Queen extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Queen(Board gameBoard, Player playerColor, Square loc){
    // super(gameBoard, playerColor, loc);
    super();
    board = gameBoard;//the board the game is played on
    color = playerColor.getColor();//keeps track of Player color, either black or white
    location = loc;//keeps track of which Square the Piece is located on
    moved = false;//just created the piece, so hasn't moved yet
  }

  public boolean checkValidMove(Square newLocation){
    //store the current location of the Piece
    int row = location.getRow();
    int col = location.getCol();

    //store the possible locations the Piece can move to
    ArrayList<Square> validSquares = new ArrayList<>();

    //VERTICAL AND HORIZONTAL MOVES - SAME AS ROOK
    //add valid Squares the piece can move to vertically
    for(int x = 0; x < 7; x++){
      if(x != row){//can't move a Piece to the Square it's already on
        if(board.getSquare(x, col).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(x, col));//add this Square to list of possible Squares
        }
      }
    }

    //add valid Squares the piece can move to horizontally
    for(int y = 0; y < 7; y++){
      if(y != col){//can't move a Piece to the Square it's already on
        if(board.getSquare(row, y).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(row, y));//add this Square to list of possible Squares
        }
      }
    }

    //POSSIBLE DIAGONAL MOVES - SAME AS BISHOP
    for(int i = row; i < 7; i++){
      if(board.getSquare(row + i, col + i).getPiece() == null){//no piece to the Square in bottom right
        validSquares.add(board.getSquare(row + i, col + i));
      }
      if(board.getSquare(row + i, col - i).getPiece() == null){//no piece to the Square in upper right
        validSquares.add(board.getSquare(row + i, col - i));
      }
    }
    for(int i = row; i > 0; i--){
      if(board.getSquare(row - i, col + i).getPiece() == null){//no piece to the Square in bottom left
        validSquares.add(board.getSquare(row - i, col + i));
      }
      if(board.getSquare(row - i, col - i).getPiece() == null){//no piece to the Square in upper left
        validSquares.add(board.getSquare(row - i, col - i));
      }
    }

    //if the new location is in list of valid Squares you can move to, return true
    //otherwise, it is not a valid move, so return false
    if(validSquares.contains(newLocation)){
      return true;
    }
    return false;
  }

  // public boolean checkValidMove(Square newLocation) throws IllegalArgumentException{
  //   //assign variables to hold int values of rows and cols to avoid repetitive code
  //   int currentRow = location.getRow();
  //   int currentCol = location.getCol();
  //   int newRow = newLocation.getRow();
  //   int newCol = newLocation.getCol();
  //
  //   //if the Square is not part of the 8x8 board, throw exception
  //   if(newRow < 0 || newRow > 7 || newCol < 0 || newCol > 7){
  //     throw new IllegalArgumentException();
  //   }
  //
  //   int rowDiff = newRow - currentRow;
  //
  //   //if not moving diagonally. not moving same number of squares verically as horizontally
  //   if(!(newCol == currentCol + rowDiff || newCol == currentCol - rowDiff)){
  //     return false;
  //   }
  //   return true;
  // }

  public String toString(){
    if(color.equals("white")){
      return "Q";//white pieces are capitalized
    } else {
      return "q";//black pieces are lowercase
    }
  }

}
