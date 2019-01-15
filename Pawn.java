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

  public Pawn(Board gameBoard, Player playerColor, Square loc){
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

    if(color.equals("white")){
      //if Square in front is not occupied, you can move forward
      if(row - 1 >= 0){//avoid IndexOutOfBounds Exception
        if(board.getSquare(row - 1, col).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(row - 1, col));//add this Square to list of possible Squares
        }
        if (col + 1 < 8) {
          if(board.getSquare(row - 1, col + 1).getPiece() != null){//can capture diagonal black piece (upper right)
            if(board.getSquare(row - 1, col + 1).getPiece().getColor() == "black"){
              validSquares.add(board.getSquare(row - 1, col + 1));//add this Square to list of possible Squares
            }
          }
        }
        if (col - 1 >= 0) {
          if(board.getSquare(row - 1, col - 1).getPiece() != null){//can capture diagonal black piece (upper left)
            if(board.getSquare(row - 1, col - 1).getPiece().getColor() == "black"){
              validSquares.add(board.getSquare(row - 1, col - 1));//add this Square to list of possible Squares
            }
          }
        }
      }

      //piece has not moved yet, so you can move 2 squares up
      if(!moved){
        if(board.getSquare(row - 2, col).getPiece() == null){
          validSquares.add(board.getSquare(row - 2, col));
        }
      }
    }

    if(color.equals("black")){
      //if Square in front is not occupied, you can move forward
      if(row + 1 <= 7){//avoid IndexOutOfBounds exception
        if(board.getSquare(row + 1, col).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(row + 1, col));//add this Square to list of possible Squares
        }
        if(col + 1 < 8){
          if(board.getSquare(row + 1, col + 1).getPiece() != null){//can capture diagonal white piece (bottom right)
            if(board.getSquare(row + 1, col + 1).getPiece().getColor() == "white"){
              validSquares.add(board.getSquare(row + 1, col + 1));//add this Square to list of possible Squares
            }
          }
        }
        if (col - 1 >= 0 && col != 0 ) {
          if(board.getSquare(row + 1, col - 1).getPiece() != null){//can capture diagonal black piece (bottom left)
            if(board.getSquare(row + 1, col - 1).getPiece().getColor() == "white"){
              validSquares.add(board.getSquare(row + 1, col - 1));//add this Square to list of possible Squares
            }
          }
        }
      }

      //piece has not moved yet, so you can move 2 squares up
      if(!moved){
        if(board.getSquare(row + 2, col).getPiece() == null){
          validSquares.add(board.getSquare(row + 2, col));
        }
      }
    }

    //if the new location is in list of valid Squares you can move to, return true
    //otherwise, it is not a valid move, so return false
    if(validSquares.contains(newLocation)){
      return true;
    }
    return false;
  }

  public String getColor(){
    return color;//returns the Player color, either white or black
  }

  public Square getLocation() {
    return location;
  }

  public void setLocation(Square newLocation){
    location = newLocation;//sets its location to the new one
  }

  public String toString(){
    if(color.equals("white")){
      return "P";//white pieces are capitalized
    } else{
      return "p";//black pieces are lowercase
    }
  }

  public static void main(String[] args){
    Board board = new Board();
    Player p1 = new Player("white");
    // Square s1 = board1.getSquare(0,0);
    Rook test = new Rook(board, p1, board.getSquare(0,0));
    System.out.println(test.getLocation());
  }


}
