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
				UI.PrintMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

			} catch (ChessException e) {
				System.err.println(e.getMessage());
				System.out.print("press \"Enter\" to continue... ");
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.err.println(e.getMessage());
				System.out.print("press \"Enter\" to continue... ");
				sc.nextLine();
			}
		}
	}

}
