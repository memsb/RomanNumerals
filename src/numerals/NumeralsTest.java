package numerals;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumeralsTest {

	@Test
	public void testConvertOne()  {	
		assertEquals(1, new Roman("I").intValue());
	}
	
	@Test
	public void testConvertManyOnes()  {
		assertEquals(2, new Roman("II").intValue());
	}
	
	@Test
	public void testConvertFive()  {
		assertEquals(5, new Roman("V").intValue());
	}
	
	@Test
	public void testConvertTen()  {
		assertEquals(10, new Roman("X").intValue());
	}
	
	@Test
	public void testConvertMixedValues()  {
		assertEquals(16, new Roman("XVI").intValue());
	}
	
	@Test
	public void testConvertlowerCase()  {
		assertEquals(16, new Roman("xvi").intValue());
	}
	
	@Test
	public void testPrefixModifiers()  {
		assertEquals(4, new Roman("IV").intValue());
		assertEquals(9, new Roman("IX").intValue());
		assertEquals(40, new Roman("XL").intValue());
		assertEquals(90, new Roman("XC").intValue());
		assertEquals(99, new Roman("IC").intValue());
		assertEquals(400, new Roman("CD").intValue());
		assertEquals(490, new Roman("XD").intValue());
		assertEquals(499, new Roman("ID").intValue());
		assertEquals(900, new Roman("CM").intValue());
		assertEquals(990, new Roman("XM").intValue());
		assertEquals(999, new Roman("IM").intValue());
	}
	
	@Test
	public void testAlternativeRepresentationsOfSameNumber() {
		assertEquals(1999, new Roman("MDCCCCLXXXXVIIII").intValue());
		assertEquals(1999, new Roman("MCMXCIX").intValue());
		assertEquals(1999, new Roman("MIM").intValue());
	}
	
	@Test
	public void testInvalidNumerals() {
		assertEquals(0, new Roman("qwerty1234!!£$%^").intValue());
	}
	
	@Test
	public void testEquality(){
		assertTrue(new Roman("I").equals(new Roman("I")));
		assertFalse(new Roman("II").equals(new Roman("I")));
		

		assertTrue(new Decimal(1).equals(new Decimal(1)));
		assertFalse(new Decimal(1).equals(new Decimal(2)));
		

		assertTrue(new Roman("I").equals(new Decimal(1)));
		assertFalse(new Roman("I").equals(new Decimal(2)));
	}
	
	@Test
	public void testDecimalAddition(){
		Value one = new Decimal(1);
		Value total = one.plus(one);
		assertEquals(new Decimal(2), total);
	}
	
	@Test
	public void testRomanAddition(){
		Value one = new Roman("I");
		Value total = one.plus(one);
		assertEquals(new Roman("II"), total);
	}
	
	@Test
	public void testMixedAddition(){
		Value one = new Roman("I");
		Value two = new Decimal(2);
		Value total = one.plus(two);
		assertEquals(3, total.intValue());
	}
	
	@Test
	public void testRomanToRoman(){
		Value one = new Roman("I");
		assertEquals("I", one.romanValue());
	}
	
	@Test
	public void testDecimalToRoman(){
		assertEquals("I", new Decimal(1).romanValue());
		assertEquals("II", new Decimal(2).romanValue());
		assertEquals("IV", new Decimal(4).romanValue());
		assertEquals("V", new Decimal(5).romanValue());
		assertEquals("VI", new Decimal(6).romanValue());
		assertEquals("IX", new Decimal(9).romanValue());
		assertEquals("X", new Decimal(10).romanValue());
		assertEquals("XL", new Decimal(40).romanValue());
		assertEquals("XC", new Decimal(90).romanValue());
		assertEquals("CD", new Decimal(400).romanValue());
		assertEquals("XD", new Decimal(490).romanValue());
		assertEquals("CM", new Decimal(900).romanValue());
		assertEquals("XM", new Decimal(990).romanValue());
		assertEquals("IM", new Decimal(999).romanValue());
		assertEquals("MIM", new Decimal(1999).romanValue());
	}

	@Test
	public void testRomanAdditionToRoman(){
		assertEquals("II", new Roman("I").plus(new Roman("I")).romanValue());
		assertEquals("IV", new Roman("I").plus(new Roman("III")).romanValue());
		assertEquals("IX", new Roman("I").plus(new Roman("VIII")).romanValue());
		assertEquals("MM", new Roman("I").plus(new Roman("MIM")).romanValue());
	}
	
	@Test
	public void testDecimalAdditionToRoman(){
		assertEquals("II", new Decimal(1).plus(new Decimal(1)).romanValue());
		assertEquals("IV", new Decimal(1).plus(new Decimal(3)).romanValue());
		assertEquals("IX", new Decimal(1).plus(new Decimal(8)).romanValue());
	}
	
	@Test
	public void testMixedAdditionToRoman(){
		assertEquals("II", new Decimal(1).plus(new Roman("I")).romanValue());
		assertEquals("IV", new Decimal(1).plus(new Roman("III")).romanValue());
		assertEquals("IX", new Roman("I").plus(new Decimal(8)).romanValue());
	}

}
