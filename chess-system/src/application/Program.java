package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ChessMatch chessMatch = new ChessMatch();

		if (System.getenv().get("TERM") == null) {
			System.out.println("Use in a terminal that supports ANSI escape codes");
		}

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
			} catch (ChessException e) {
				System.err.println(e.getMessage());
				System.out.println("press \"Enter\" to continue...");
				sc.nextLine();				
			} catch (InputMismatchException e) {
				System.err.println(e.getMessage());
				System.out.println("press \"Enter\" to continue...");
				sc.nextLine();
			}
		}
	}

}
