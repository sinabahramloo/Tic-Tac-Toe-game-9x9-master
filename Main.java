import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InputMismatchException {
		
		Scanner scan = new Scanner(System.in);
		
		Board board = new Board() ;
		TicTacToe game = new TicTacToe() ;
		Symbol symbol = new Symbol() ;
		System.out.println("Please enter number of rows and columns of game");
		while (true) {
			byte number = scan.nextByte();
			if(number>2 && number%2==1){
				Board.initialBoardsize(number);
				Board.initialSize();
				break;
			}
			System.out.println("Please enter  a odd number and greater than 2");
		}
		System.out.println("Please enter number of same cells beside togheter to win game");
		while (true) {
			byte number = scan.nextByte();
			if(number<=Board.getSize()&&number>2){
				Board.initialNumberOfSameCharacterToWin(number);
				break;
			}
			System.out.println("Please enter   number less or equel number of rows and columns");
		}
		Board.initialSize();
		System.out.println("Plese enter X or O character no strat game turn with");
		while (true){
			String s=scan.next();
		if(s.equals("X")){
			Symbol.initialcurrentSymbol('X');
			break;
		}
		else if(s.equals("O")){
			Symbol.initialcurrentSymbol('O');
				break;
			}
		else
			System.out.println("Please enter a valid character to start ");
		}
		board.initialBoard() ;
		System.out.print(board.toString());

		while (!board.isFull()) {

			if (symbol.getCurrentSymbol() == 'X') {
				System.out.println("Player X's turn.");
			} else {
				System.out.println("Player O's turn.");
			}
			System.out.print("Please select row: ");
			int row = scan.nextInt();
			while (!(row <=Board.getSize())) {
				System.out.print("You can't place on that row: ");
				System.out.print("Please select row: ");
				row = scan.nextInt();
			}
			System.out.print("Please select col: ");
			int col = scan.nextInt();

			while (!(col <=Board.getSize())) {
				System.out.print("You can't place on that col: ");
				System.out.print("Please select col: ");
				 col = scan.nextInt();
			}

			while (Board.getBoard()[row-1][col-1] != '-') {
				System.out.println("\n\n\nYou can't place on that cell.");
				System.out.print("Please select row: ");
				row = scan.nextInt();
				System.out.print("Please select col: ");
				col = scan.nextInt();
			}

			symbol.currentMark(row - 1, col - 1);
			System.out.println();
			System.out.printf("You placed %s on (%d, %d)\n", symbol.getCurrentSymbol(), row, col);
			System.out.print(board.toString()) ;
			if (game.isWin()) {
				if (symbol.getCurrentSymbol() == 'X') {
					System.out.println("Player'1 win.");
				} else {
					System.out.println("Player'2 win.");
				}
				break;
			}
			symbol.changeSymbol();
			if(board.isFull()){
				System.out.println("game is draw enter Y to play egain");
				String s=scan.next();
				if(s.equals("Y")){
					board.initialBoard() ;
					System.out.print(board.toString());
				}
			}
		}
	}
}
