package com.virtusa.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * console user interface for tic tac toe
 */

public class FinalClass {
	public static final Random RANDOM = new Random();

	public static void main(String[] args) {
		Board b = new Board();
		int choice = 0, x = 0, y = 0, again = 0;
		String exit = null;
		Scanner scanner = new Scanner(System.in);
		b.dsiplayBoard(); // to display board initially
		do {
			System.out.println("Select turn:\n1. Computer (X) / 2. User(O) :");
			System.out.println("Enter Exit at any Time to Close");

			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				exit = scanner.nextLine();
				if (exit.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				// System.out.println(e);
			}
			do {
				if ((choice == Board.PLAYER_O) || (choice == Board.PLAYER_X)) {
					break;
				} else {
					System.out.println("Wrong Value Entered Please Try Again.");
					try {
						choice = scanner.nextInt();
					} catch (Exception e) {
						exit = scanner.nextLine();
						if (exit.equalsIgnoreCase("exit")) {
							System.exit(0);
						}
						// System.out.println(e);
					}
				}
			} while ((choice != Board.PLAYER_O) && (choice != Board.PLAYER_X)); 
			if (choice == Board.PLAYER_X) {
				Point p = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
				b.placeAMove(p, Board.PLAYER_X);
				b.dsiplayBoard();

			}
			while (!b.isGameOver()) {     // until game is over
				boolean moveOk = true;

				do {
					if (!moveOk) {
						System.out.println("Cell Already filled !");
					}
					System.out.println("Your Move ( you have to enter position as eg: 1 2 )");
					do {
						try {
							x = scanner.nextInt();
							y = scanner.nextInt();
							if ((x > 0) && (x < 4) && (y > 0) && (y < 4)) {
								x -= 1;
								y -= 1;
							} else {
								System.out.println("Please Enter Correct Values!");
							}
						} catch (Exception e) {
							exit = scanner.nextLine();
							if (exit.equalsIgnoreCase("exit")) {
								System.exit(0);
							}
							System.out.println("Please Enter Correct Values!");
							x = Integer.MAX_VALUE;

						}
					} while ((x < 0) || (x > 2) || (y < 0) || (y > 2));
					Point userMove = new Point(x, y);
					moveOk = b.placeAMove(userMove, Board.PLAYER_O);
					
				} while (!moveOk);

				b.dsiplayBoard();

				if (b.isGameOver())
					break;

				b.minimax(0, Board.PLAYER_X);
				System.out.println("Computer Choose position : " + b.computerMove);
				b.placeAMove(b.computerMove, Board.PLAYER_X);
				b.dsiplayBoard();
			}
			if (b.hasPlayerWon(Board.PLAYER_X))
				System.out.println("You Lost");
			
			else if (b.hasPlayerWon(Board.PLAYER_O))
				System.out.println("You Win !");
			
			else
				System.out.println("Draw !");
			System.out.println("Do You Want to try Again ?");
			System.out.println("Press 1 for restart and any other value for Exit");
			try {
				again = scanner.nextInt();
				b = new Board();
			} catch (Exception e) {
				scanner.nextLine();
				again = 0;
			}
		} while (again == 1);
	}
}
