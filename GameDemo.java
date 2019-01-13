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
import java.util.ArrayList;

//API : http://mabe02.github.io/lanterna/apidocs/2.1/


public class GameDemo {
	private Board board;
  private Player turn;
  private ArrayList<Move> moves = new ArrayList<>();
  private PieceSet blackP;
  private PieceSet whiteP;

  public GameDemo() {
    board = new Board();
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
    turn = new Player("black");
    blackP = new PieceSet(turn); //creates a black PieceSet
    turn = new Player("white");
    whiteP = new PieceSet(turn); //creates a white PieceSet
    blackP.initialPieces(board); //all pieces are created at starting position
    whiteP.initialPieces(board);
    board.setPieceSets(blackP, whiteP); //sets up the PieceSets in Board so it'll have access
    board.setSquares(blackP, whiteP); //sets up squares[][] in Board
  }


	public static void main(String[] args) {


		int x = 0;
		int y = 0;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		while(running){
			//SETTING UP THE BOARD VISUALLY
			//print out the row of letters on top (A to H)
			terminal.moveCursor(size.getColumns()-size.getColumns() + 5,5);
			terminal.putCharacter('A');
			terminal.putCharacter(' ');
			terminal.putCharacter('B');
			terminal.putCharacter(' ');
			terminal.putCharacter('C');
			terminal.putCharacter(' ');
			terminal.putCharacter('D');
			terminal.putCharacter(' ');
			terminal.putCharacter('E');
			terminal.putCharacter(' ');
			terminal.putCharacter('F');
			terminal.putCharacter(' ');
			terminal.putCharacter('G');
			terminal.putCharacter(' ');
			terminal.putCharacter('H');
			//print out the column of numbers to the left (1 to 8)
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,6);
			terminal.putCharacter('1');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,7);
			terminal.putCharacter('2');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,8);
			terminal.putCharacter('3');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,9);
			terminal.putCharacter('4');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,10);
			terminal.putCharacter('5');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,11);
			terminal.putCharacter('6');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,12);
			terminal.putCharacter('7');
			terminal.moveCursor(size.getColumns()-size.getColumns() + 3,13);
			terminal.putCharacter('8');




			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}
			}


	    // String letter = "ABCDEFGH";
	    // for (int r = 0; r < 9; r++) {
			// 	terminal.moveCursor(size.getColumns()-size.getColumns() + 5,5);
	    //   if (r == 0) { //if it's the first row numbers will be printed on the side
	    //     terminal.putCharacter(letter.charAt(r));; //excluding the first row
			// 		terminal.putCharacter(' ');//space between letters to make it look nicer
	    //   }
	    //   else {
	    //     terminal.putCharacter(' ');
	    //   }
	    //   for (int c = 0; c < 9; c++) { //letters are printed above each column
	    //     if (r == 0) {
	    //       if (c != 0) { //exlcluding the first column
	    //         terminal.putCharacter(letter.charAt(c - 1));
	    //       }
	    //     }
	    //     if (r != 0 && c != 0 && board.getSquare(r-1, c-1) != null) {
	    //       //for every empty space that has a piece in the Squares array
	    //       //prints out the piece that the Square stores
	    //         ans += " " + board.getSquare(r-1,c-1).getPiece();
	    //       }
	    //     }
	    // }


			// terminal.moveCursor(x,y);
			// terminal.applyBackgroundColor(Terminal.Color.WHITE);
			// terminal.applyForegroundColor(Terminal.Color.BLACK);
			// //applySGR(a,b) for multiple modifiers (bold,blink) etc.
			// terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
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
