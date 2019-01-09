import java.util.ArrayList;

public class Pawn extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public boolean promoted;
  //set to true if the Pawn has been promoted

  public Piece promoteTo;
  //if promoted, keep track of which Piece the Pawn has been changed to

  public Pawn(Board gameBoard, String playerColor, Square loc){
    // super(gameBoard, playerColor, loc);
    super();
    board = gameBoard;//the board the game is played on
    color = playerColor;//keeps track of Player color, either black or white
    location = loc;//keeps track of which Square the Piece is located on
    moved = false;//just created the piece, so hasn't moved yet
  }

  public boolean checkValidMove(Square newLocation){
    //store the current location of the Piece
    int row = location.getRow();
    int col = location.getCol();

    //store the possible locations the Piece can move to
    ArrayList<Square> validSquares = new ArrayList<>();

    if(color.equals("white")){
      // //if Square in front is not occupied, you can move forward
      // //must add this Board method first, or else file will not compile
      // if(board.getSquare(row - 1, col).isEmpty()){//check if this Square is empty
      //   validSquares.add(board.getSquare(row - 1, col));//add this Square to list of possible Squares
      // }

      //piece has not moved yet, so you can move 2 squares up
      if(!moved){
        // if(board.getSquare(row - 2, col).isEmpty()){
        //   validSquares.add(board.getSquare(row - 2, col));
        // }
      }
    }

    if(color.equals("black")){
      // //if Square in front is not occupied, you can move forward
      // //must add this Board method first, or else file will not compile
      // if(board.getSquare(row + 1, col).isEmpty()){//check if this Square is empty
      //   validSquares.add(board.getSquare(row + 1, col));//add this Square to list of possible Squares
      // }

      //piece has not moved yet, so you can move 2 squares up
      if(!moved){
        // if(board.getSquare(row + 2, col).isEmpty()){
        //   validSquares.add(board.getSquare(row + 2, col));
        // }
      }
    }

    //if the new location is in list of valid Squares you can move to, return true
    //otherwise, it is not a valid move, so return false
    if(validSquares.contains(newLocation)){
      return true;
    }
    return false;
  }

  // public boolean checkValidMove(Square newLocation) throws IllegalArgumentException {
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
  //   //if white Pawn is trying to move backwards, not valid move, so return false
  //    if(color.equals("white")){
  //      if(newRow > currentRow){
  //        return false;
  //      }
  //    }
  //    //if black Pawn is trying to move backwards, not valid move, so return false
  //    if(color.equals("black")){
  //      if(newRow < currentRow){
  //        return false;
  //      }
  //    }
  //    return true;
  // }

  public String toString(){
    if(color.contains("white")){
      return "P";//white pieces are capitalized
    } else{
      return "p";//black pieces are lowercase
    }
  }

  public static void main(String[] args){
    Board board1 = new Board();
    String p1 = "white";
    // Square s1 = board1.getSquare(0,0);
    Square s1 = new Square(0,0);
    Pawn pawn1 = new Pawn(board1, p1, s1);
    System.out.println(pawn1);
  }


}
