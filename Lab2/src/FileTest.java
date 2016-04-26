import static org.junit.Assert.*;

import org.junit.Test;

public class FileTest {

	@Test
	public void test() {
		TestReader tr = new TestReader();
		String s1 =tr.read("output.txt") ;
		String s2 =tr.read("words-5757-test.out.txt") ;
		assertEquals(s1,s2);
	}

}
