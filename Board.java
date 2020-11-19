
public class Board {
	
	private static char[][] board ;

	private static byte size=0;

	private static byte numberOfSameCharacterToWin=0;

	public static void initialBoardsize(byte b){board=new char [b][b];}

	public static void initialSize(){size= (byte) board.length; }

	public static byte getSize(){return size; }

	public static byte getNumberOfSameCharacterToWin(){return numberOfSameCharacterToWin;}

	public static void initialNumberOfSameCharacterToWin(byte b){numberOfSameCharacterToWin=b;}

	public static char[][] getBoard() {
		return board;
	}

	public static void setBoard(char[][] board) {
		Board.board = board;
	}

	public static void initialBoard() {
		for (int i = 0; i < Board.getSize(); i++) {
			for (int j = 0; j < Board.getSize(); j++) {
				board[i][j] = '-';
			}
		}
	}

	public boolean isFull() {
		boolean full = true;
		for (int i = 0; i < Board.getSize(); i++) {
			for (int j = 0; j < Board.getSize(); j++) {
				if (board[i][j] == '-') {
					full = false;
				}
			}
		}
		return full;
	}

	public String toString() {
		String temp = "" ;
		for (int i = 0; i < Board.getSize()+1 ; i++) {
			temp += String.format("%d   ", i) ;
		}
		temp += "\n" ;
		for (int i = 0; i < Board.getSize(); i++) {
			temp += String.format("%d | ", i+1);
			for (int j = 0; j < Board.getSize(); j++) {
				temp += String.format("%c | ", board[i][j]);
			}
			temp += "\n" ;
		}
		return temp ;
	}
}
