/**
 * 
 */
package com.virtusa.tictactoe;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;


public class FinalClassTest {

	@Test
	public void test() {      //to see whether random is generating random values or not 
		Random r = new Random();
		int first = r.nextInt(3);       //3 is upper bound
		int second = r.nextInt(3);
		assertNotEquals(first, second);
		
	}

}
