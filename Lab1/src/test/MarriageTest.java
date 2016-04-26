package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class MarriageTest {
	
	@Test
	public void MarriageTest() {
		R r = new R();
		String s1 =r.read("output.txt") ;
		String s2 =r.read("sm-illiad.out.txt") ;
		assertEquals(s1,s2);
		
	

	}

}
