package application;

import java.util.Scanner;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Colored shell (y/n)? ");
		char shell = sc.next().charAt(0);

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces(), shell);

		sc.close();
	}

}
