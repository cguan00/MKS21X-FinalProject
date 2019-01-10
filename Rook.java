import java.util.ArrayList;

public class Rook extends Piece{
  private Board board;
  //stores the game board. must have access to Squares

  private String color;
  //player color: either white or black

  private Square location;
  //location of the Piece on the board

  private boolean moved;
  //keeps tracks of if the piece was moved or not

  public Rook(Board gameBoard, Player playerColor, Square loc){
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

    //add valid Squares the piece can move to vertically
    for(int i = 0; i < 7; i++){
      if(i != row){//can't move a Piece to the Square it's already on
        if(board.getSquare(i, col).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
        }
        if(board.getSquare(i, col).getPiece() != null){//if this Square has a piece...
          if(!board.getSquare(i, col).getPiece().getColor().equals(color))//...and this piece is not part of your own pieceSet (different color)
            validSquares.add(board.getSquare(i, col));//add this Square to list of possible Squares
        }
      }
    }

    //add valid Squares the piece can move to horizontally
    for(int j = 0; j < 7; j++){
      if(j != col){//can't move a Piece to the Square it's already on
        if(board.getSquare(row, j).getPiece() == null){//check if this Square is empty
          validSquares.add(board.getSquare(row, j));//add this Square to list of possible Squares
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



  public String toString(){
    if(color.equals("white")){
      return "R";//white pieces are capitalized
    } else{
      return "r";//black pieces are lowercase
    }
  }

}
