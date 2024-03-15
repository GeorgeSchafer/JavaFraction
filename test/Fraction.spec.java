import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
	
	@Test
	public void constructorTest() {
		Fraction x = new Fraction();
		
		assertEquals(0, x.getNum());
		assertEquals(0, x.getDen());
		
		Fraction y = new Fraction(12,10);
		assertEquals(6, y.getNum());
		assertEquals(5, y.getDen());

		assertTrue(6 == y.getNum());
		assertTrue(5 == y.getDen());
		
		assertTrue(0 == x.getNum());
		assertTrue(0 == x.getDen());
		assertFalse(12 == x.getNum());
		
		Fraction z = new Fraction(0,12);
		assertTrue(0==z.getNum());
		assertTrue(12 == z.getDen());
	}
	
	@Test
	public void multiplyTest(){
		Fraction x = new Fraction(2,2);
		Fraction y = new Fraction(3,2);
		
		Fraction a = x.multiply(y);
		Fraction b = x.divide(y);
		
		assertEquals(3,a.getNum());
		assertEquals(2,a.getDen());
		
		assertEquals(2,b.getNum());
		assertEquals(3,b.getDen());
		
		// 1/4 * 3/16
		
		Fraction p = new Fraction(1, 4);
		Fraction q = new Fraction(3,16);
		
		String ans = "3 / 64";
		String test = p.multiply(q).toString();
		
		assertTrue(ans.equals(test));
		
		// 1/4 * -1/1
		
		Fraction r = new Fraction(-1,1);
		
		String ans2 = "-1 / 4";
		String test2 = p.multiply(r).toString();
		
		assertTrue(ans2.equals(test2));
		
		Fraction s = new Fraction(1,-1);
		
		String ans3 = "-1 / 4";
		String test3 = p.multiply(s).toString();
		
		assertTrue(ans3.equals(test3));
		
		
	}
	
	@Test
	public void additionTest(){
		Fraction a = new Fraction(3,5);
		Fraction b = new Fraction(1,5);
		Fraction c = a.add(b);
		Fraction d = a.subtract(b);
		Fraction e = b.subtract(a);
		
		assertEquals(4,c.getNum());
		assertEquals(5,c.getDen());
		
		assertEquals(2,d.getNum());
		assertEquals(5,d.getDen());
		
		assertEquals(-2,e.getNum());
		assertEquals( 5,e.getDen());
		
		
		Fraction x = new Fraction(1,2);
		Fraction y = new Fraction(1,4);
		Fraction z = x.subtract(y);
		
		assertEquals(1,z.getNum());
		assertEquals(4,z.getDen());
		
	}
	
	@Test
	public void outputTests(){
		
		Fraction a = new Fraction(-22,7);
		
		String frac = "-22 / 7";
		String ratio = "-22 : 7";
		String asFrac = a.toString();
		String asRatio = a.toRatio();
		
		assertTrue(frac.equals(asFrac));
		assertTrue(ratio.equals(asRatio));
		
	}

	
	@Test
	public void exceptionTest(){
		try {
			   Fraction a = new Fraction(5,0); 
			   assertTrue(a.getDen() == 0);
			   fail();
		} catch (Exception IllegalArgumentException) {
			   System.out.println("Illegal Argument Exception: \n Denominator cannot be zero unless numerator is also zero");
		} 
	}
	
	@Test
	public void reduceTest(){
		Fraction a = new Fraction(4,8);
		
		String ans = "1 / 2";
		String result = a.toString();
		
		assertTrue(ans.equals(result));
		
	}

	@Test
	public void constantTest(){
		System.out.println( (double) Math.PI );
		
		Fraction pi = new Fraction("pi");
		
		System.out.println( pi.toDouble() );
		System.out.println( pi.toFloat());
	}
	
}
