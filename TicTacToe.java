import java.util.Scanner;

public class TicTacToe {
	
	private static Board board = new Board() ;
	private static Symbol symbol = new Symbol() ;

	private static boolean isDiagonalRightWin() {
		int i = 0 , countRight = 0;
			while(i < Board.getSize()) {
					if(board.getBoard()[i][i] == Symbol.getCurrentSymbol()) {
						countRight++;
						if(countRight == Board.getNumberOfSameCharacterToWin()) { return true ;	}
					}else {
						countRight = 0 ;
					}
					i++;
				}
		return false ;
    }

	private static boolean isDiagonalLeftWin() {
		int i = Board.getSize()-1 , j = 0 , countLeft = 0;
		
		while(i >= 0) {
			if(board.getBoard()[i][j] == symbol.getCurrentSymbol()){ 
				countLeft++;
				if(countLeft == Board.getNumberOfSameCharacterToWin()) { return true ; }
			}else {
				countLeft = 0 ;
			}	
			i--; j++;
		}
		return false ;
    }

	private static boolean isColumnsWin() {
		int countColumn = 0 ;
		for(int i = 0 ; i < Board.getSize() ; i++) {
			for(int j = 0 ; j < Board.getSize() ; j++) {
				if(board.getBoard()[j][i] == symbol.getCurrentSymbol()) {
					countColumn++;
					if(countColumn == Board.getNumberOfSameCharacterToWin()) {
						return true ;
					}
				}
			}
			countColumn = 0 ;
		}
		return false;
	}

	private static boolean isRowsWin() {
		int countRow = 0 ;
		for(int i = 0 ; i < Board.getSize() ; i++) {
			for(int j = 0 ; j < Board.getSize() ; j++) {
				if(board.getBoard()[i][j] == symbol.getCurrentSymbol()) {
					countRow++;
					if(countRow == Board.getNumberOfSameCharacterToWin()) {
						return true ;
					}
				}
			}
			countRow = 0 ;
		}
		return false;
	}

	public static boolean isWin() {
		return (isRowsWin() || isColumnsWin() || isDiagonalRightWin() || isDiagonalLeftWin());
	}
}
