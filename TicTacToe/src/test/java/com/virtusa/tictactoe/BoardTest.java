package com.virtusa.tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class BoardTest {

	@Test
	public void testIsGameOver() { // if any of the player won then game should be over
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 1), Board.PLAYER_O);
		b.placeAMove(new Point(0, 2), Board.PLAYER_X);
		b.placeAMove(new Point(1, 0), Board.PLAYER_X);
		b.placeAMove(new Point(1, 1), Board.PLAYER_X);
		b.placeAMove(new Point(1, 2), Board.PLAYER_O);
		b.placeAMove(new Point(2, 0), Board.PLAYER_O);
		b.placeAMove(new Point(2, 1), Board.PLAYER_X);
		b.placeAMove(new Point(2, 2), Board.PLAYER_O);
		assertTrue(b.isGameOver());

	}

	@Test
	public void testMinMax() { // if computer wins than minmax method should return 1
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		assertEquals(1, b.minimax(0, Board.PLAYER_X));

	}

	@Test
	public void testHasComputerWon() { // to check whether computer won or not
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 1), Board.PLAYER_X);
		b.placeAMove(new Point(0, 2), Board.PLAYER_X);
		assertTrue(b.hasPlayerWon(Board.PLAYER_X));
	}

	@Test
	public void testHasHumanWon() { // to check whether human won or not
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_O);
		b.placeAMove(new Point(0, 1), Board.PLAYER_O);
		b.placeAMove(new Point(0, 2), Board.PLAYER_O);
		assertTrue(b.hasPlayerWon(Board.PLAYER_O));
	}

	@Test
	public void bestMove() {
		Board b = new Board(); // if {[X,O,O],[X,X,O],[_,_,_]} then computer should take
								// {[X,O,O],[X,X,O],[X,_,_]} i.e (2,0)
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 1), Board.PLAYER_O);
		b.placeAMove(new Point(0, 2), Board.PLAYER_O);
		b.placeAMove(new Point(1, 0), Board.PLAYER_X);
		b.placeAMove(new Point(1, 1), Board.PLAYER_X);
		b.placeAMove(new Point(1, 2), Board.PLAYER_O);
		b.minimax(0, Board.PLAYER_X);
		Point p = new Point(2, 0);
		assertEquals(p.toString(), b.computerMove.toString());
	}

	@Test
	public void computeMove() { // if {[X,X,_][O,_,_][_,_,_]} then computer should choose {X,X,X} i.e (0,2)
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 1), Board.PLAYER_X);
		b.placeAMove(new Point(1, 0), Board.PLAYER_O);
		b.minimax(0, Board.PLAYER_X);
		Point p = new Point(0, 2);

		assertEquals(p.toString(), b.computerMove.toString());

	}

	@Test
	public void testMoveNull() { // if {[X,O,O],[X,X,O],[_,_,O]} then computer should return no move i.e NULL
		Board b = new Board();
		b.placeAMove(new Point(0, 0), Board.PLAYER_X);
		b.placeAMove(new Point(0, 1), Board.PLAYER_O);
		b.placeAMove(new Point(0, 2), Board.PLAYER_O);
		b.placeAMove(new Point(1, 0), Board.PLAYER_X);
		b.placeAMove(new Point(1, 1), Board.PLAYER_X);
		b.placeAMove(new Point(1, 2), Board.PLAYER_O);
		b.placeAMove(new Point(2, 2), Board.PLAYER_O);
		b.minimax(0, Board.PLAYER_X);
		assertNull(b.computerMove);

	}

}
