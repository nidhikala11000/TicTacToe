package com.virtusa.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {                 //to see whether  pobj creates an object or not
		Point pObj = new Point(1,2);
		Object oObj= pObj;
		assertEquals(oObj, pObj);
	}

}
