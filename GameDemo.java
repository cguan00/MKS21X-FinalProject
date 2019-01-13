import java.util.ArrayList;

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;


public class GameDemo {
	private Board board;
  private Player turn;
  private ArrayList<Move> moves = new ArrayList<>();
  private PieceSet blackP;
  private PieceSet whiteP;

  public GameDemo() {
    board = new Board();
  }

	public void addMove(String color, String currentLoc, String newLoc) {
    turn = new Player(color);
    String columns = "ABCDEFGH";
    String rows = "12345678";
    int currentRow = rows.indexOf(currentLoc.charAt(1)); //the original row is stored
    int currentColumn = columns.indexOf(currentLoc.charAt(0)); //the original column is stored
    int newRow = rows.indexOf(newLoc.charAt(1)); //the new row is stored
    int newColumn = columns.indexOf(newLoc.charAt(0)); //the new column is stored
    Piece currentPiece = board.getSquare(currentRow,currentColumn).getPiece(); //the piece to be moved is stored
    //System.out.println(currentPiece.checkValidMove(board.getSquare(currentRow, currentColumn), board.getSquare(newRow,newColumn)));
    if (currentPiece.checkValidMove(board.getSquare(newRow,newColumn))) {
      Move newMove = new Move(board, turn, currentLoc, newLoc);
    }
  }

	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}

	public void create() {
    board = new Board();
    moves = new ArrayList<>();
    turn = new Player("white");
    blackP = new PieceSet(turn); //creates a white PieceSet
    turn = new Player("black"); //white goes first
    whiteP = new PieceSet(turn); //creates a black PieceSet
    blackP.initialPieces(board); //all pieces are created at starting position
    whiteP.initialPieces(board);
    board.setPieceSets(blackP, whiteP); //sets up the PieceSets in Board so it'll have access
    board.setSquares(blackP, whiteP); //sets up squares[][] in Board
  }

	public Board getBoard() {
    return board;
  }

	public static void main(String[] args) {


		int x = 0;
		int y = 0;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		size.setRows(8);
		size.setColumns(8);
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;
		Game newGame = new Game();
		newGame.create();
		Player BlackP = new Player("black");
		Player WhiteP = new Player("white");
		Player Playing = BlackP; //player black starts first
		int pressed = 0;
		Square currentLoc = new Square(0,0);
		Square newLoc = new Square(0,0);

		while(running){
			if (pressed == 1) { //if enter is pressed once, the user is choosing the piece to move
				currentLoc = newGame.getBoard().getSquare(x,y); //stores the location of the piece
			}
			if (pressed == 2) { //if enter is pressed again, the user is choosing the destination of the piece
				newLoc = newGame.getBoard().getSquare(x,y);
				newGame.addMove(Playing, currentLoc, newLoc); //a new move is made based on the previous inputs
				pressed = 0; //it's now the other player's turn, the value resets
				if (Playing.isBlack()) { //if black just played, it's white's turn
					Playing = WhiteP;
				}
				else {
					Playing = BlackP; //if white just played, it's black's turn
				}
			}
			//SETTING UP THE BOARD VISUALLY
			//print out the row of letters on top (A to H)
			terminal.moveCursor(0,0);//size.getColumns()-size.getColumns() + 5,5);
			String ans = "";
	    String letter = "ABCDEFGH";
	    for (int r = 0; r < 9; r++) {
	      if (r == 0) { //if it's the first row numbers will be printed on the side
	        terminal.putCharacter(' '); //excluding the first row
	      }
	      else {
	        terminal.moveCursor(0,r);//size.getColumns()-size.getColumns() + 5,5+r);
					ans += r;
					terminal.putCharacter(ans.charAt(0));
					ans = "";
	      }
	      for (int c = 0; c < 9; c++) { //letters are printed above each column
	        if (r == 0) {
	          if (c != 0) { //exlcluding the first column
							terminal.putCharacter(' ');
	            terminal.putCharacter(letter.charAt(c - 1));
	          }
	        }
	        if (r != 0 && c != 0) {
	          //for every empty space that has a piece in the Squares array
	          //prints out the piece that the Square stores
	          if (newGame.getBoard().getSquare(r-1, c-1).getPiece() == null) {
	            terminal.putCharacter(' ');
	          }
	          else {
	            terminal.putCharacter(' ');
							ans += newGame.getBoard().getSquare(r-1,c-1).getPiece();
							terminal.putCharacter(ans.charAt(0));
							ans = "";
	          }
	          }
	        }
	    }

			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}
				if (key.getKind() == Key.Kind.ArrowRight) {

					terminal.exitPrivateMode();
					running = false;
				}
				if (key.getKind() == Key.Kind.Enter) {
					pressed += 1;
				}
			}

			terminal.moveCursor(x,y);
			// terminal.applyBackgroundColor(Terminal.Color.WHITE);
			// terminal.applyForegroundColor(Terminal.Color.BLACK);
			// //applySGR(a,b) for multiple modifiers (bold,blink) etc.
			// terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.setCursorVisible(true);
			// terminal.putCharacter('\u00a4');
			// //terminal.putCharacter(' ');
			// terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			// terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			// terminal.applySGR(Terminal.SGR.RESET_ALL);
			//
			//
			// terminal.moveCursor(size.getColumns()-5,5);
			// terminal.applyBackgroundColor(Terminal.Color.RED);
			// terminal.applyForegroundColor(Terminal.Color.YELLOW);
			// terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter('\u262d');
			// terminal.putCharacter(' ');
			// terminal.moveCursor(size.getColumns()-5,6);
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			// terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			//
			// Key key = terminal.readInput();
			//
			// if (key != null)
			// {
			//
			// 	if (key.getKind() == Key.Kind.Escape) {
			//
			// 		terminal.exitPrivateMode();
			// 		running = false;
			// 	}
			//
			// 	if (key.getKind() == Key.Kind.ArrowLeft) {
			// 		terminal.moveCursor(x,y);
			// 		terminal.putCharacter(' ');
			// 		x--;
			// 	}
			//
			// 	if (key.getKind() == Key.Kind.ArrowRight) {
			// 		terminal.moveCursor(x,y);
			// 		terminal.putCharacter(' ');
			// 		x++;
			// 	}
			//
			// 	if (key.getKind() == Key.Kind.ArrowUp) {
			// 		terminal.moveCursor(x,y);
			// 		terminal.putCharacter(' ');
			// 		y--;
			// 	}
			//
			// 	if (key.getKind() == Key.Kind.ArrowDown) {
			// 		terminal.moveCursor(x,y);
			// 		terminal.putCharacter(' ');
			// 		y++;
			// 	}
			// 	//space moves it diagonally
			// 	if (key.getCharacter() == ' ') {
			// 		terminal.moveCursor(x,y);
			// 		terminal.putCharacter(' ');
			// 		y++;
			// 		x++;
			// 	}
			// 	putString(1,4,terminal,"["+key.getCharacter() +"]");
			// 	putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
			// }

		// 	//DO EVEN WHEN NO KEY PRESSED:
		// 	long tEnd = System.currentTimeMillis();
		// 	long millis = tEnd - tStart;
		// 	putString(1,2,terminal,"Milliseconds since start of program: "+millis);
		// 	if(millis/1000 > lastSecond){
		// 		lastSecond = millis / 1000;
		// 		//one second has passed.
		// 		putString(1,3,terminal,"Seconds since start of program: "+lastSecond);
		//
			}
		//
		//
		// }
	}
}
