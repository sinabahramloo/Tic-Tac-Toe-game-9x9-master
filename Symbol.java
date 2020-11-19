
public class Symbol {
	
	private static char currentSymbol = 'X';
	private static Board board = new Board() ;
	private static Symbol symbol = new Symbol() ;
	
	public static void initialcurrentSymbol(char c){currentSymbol=c; }

	public static char getCurrentSymbol() {
		return currentSymbol;
	}
	
	public static void setCurrentSymbol(char currentSymbol) {
		Symbol.currentSymbol = currentSymbol;
	}

	public static void changeSymbol() {
		if (currentSymbol == 'X') {
			currentSymbol = 'O';
		} else {
			currentSymbol = 'X';
		}
	}

	public static boolean currentMark(int row, int col) {
		if ((row >= 0) && (row < Board.getSize())) {
			if ((col >= 0) && (col < Board.getSize())) {
				if (board.getBoard()[row][col] == '-') {
					board.getBoard()[row][col] = symbol.getCurrentSymbol();
					return true;
				}
			}
		}
		return false;
	}
	
}