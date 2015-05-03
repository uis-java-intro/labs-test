package test.java.no.uis.intro;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.no.uis.intro.*;
import main.java.autograder.Score;

public class ArithmeticSequenceTest {

	// 2,5,8,11,14,17,...
	private int initTerm = 2, diff = 3;

	private SearchableSequence arithmetic;

	private static Score getelementscore, sumscore, productscore,
			findelementinscore, tostringscore, sumexceptionscore,
			sumexception2score, productexceptionscore, productexception2score;

	@Before
	public void setUp() throws Exception {
		arithmetic = new ArithmeticSequence(initTerm, diff);
	}

	@BeforeClass
	public static void setUpResults() {
		Score.SetGlobalSecret("4483146ac34ac38ab4fe22326b19b487");
		getelementscore = new Score("Arithmetic - testGetElement", 1, 7);
		sumscore = new Score("Arithmetic - testSum", 1, 6);
		productscore = new Score("Arithmetic - testProduct", 1, 6);
		findelementinscore = new Score("Arithmetic - testFindElementIn", 1, 11);
		tostringscore = new Score("Arithmetic - testtoString", 1, 1);
		sumexceptionscore = new Score("Arithmetic - testSumException", 1, 1, 1);
		sumexception2score = new Score("Arithmetic - testSumException2", 1, 1,
				1);
		productexceptionscore = new Score("Arithmetic - testProductException",
				1, 1, 1);
		productexception2score = new Score("Arithmetic - testProductException",
				1, 1, 1);
	}

	@AfterClass
	public static void PrintResults() {
		getelementscore.PrintJSON();
		sumscore.PrintJSON();
		productscore.PrintJSON();
		findelementinscore.PrintJSON();
		tostringscore.PrintJSON();
		sumexceptionscore.PrintJSON();
		sumexception2score.PrintJSON();
		productexceptionscore.PrintJSON();
		productexception2score.PrintJSON();
	}

	@Test
	public void testGetElement() {
		assertEquals(-4, arithmetic.getElement(-1));
		getelementscore.Inc();
		assertEquals(-1, arithmetic.getElement(0));
		getelementscore.Inc();
		assertEquals(2, arithmetic.getElement(1));
		getelementscore.Inc();
		assertEquals(5, arithmetic.getElement(2));
		getelementscore.Inc();
		assertEquals(8, arithmetic.getElement(3));
		getelementscore.Inc();
		assertEquals(11, arithmetic.getElement(4));
		getelementscore.Inc();
		assertEquals(14, arithmetic.getElement(5));
		getelementscore.Inc();
	}

	@Test
	public void testSum() {
		assertEquals(2, arithmetic.sum(1));
		sumscore.Inc();
		assertEquals(2 + 5, arithmetic.sum(2));
		sumscore.Inc();
		assertEquals(2 + 5 + 8, arithmetic.sum(3));
		sumscore.Inc();
		assertEquals(2 + 5 + 8 + 11, arithmetic.sum(4));
		sumscore.Inc();
		assertEquals(2 + 5 + 8 + 11 + 14, arithmetic.sum(5));
		sumscore.Inc();
		assertEquals(2 + 5 + 8 + 11 + 14 + 17, arithmetic.sum(6));
		sumscore.Inc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSumException() {
		arithmetic.sum(0);
		sumexceptionscore.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Sum metode ved n < 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSumException2() {
		arithmetic.sum(-1);
		sumexception2score.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Sum metode ved n < 1");
	}

	@Test
	public void testProduct() {
		assertEquals(2, arithmetic.product(1));
		productscore.Inc();
		assertEquals(2 * 5, arithmetic.product(2));
		productscore.Inc();
		assertEquals(2 * 5 * 8, arithmetic.product(3));
		productscore.Inc();
		assertEquals(2 * 5 * 8 * 11, arithmetic.product(4));
		productscore.Inc();
		assertEquals(2 * 5 * 8 * 11 * 14, arithmetic.product(5));
		productscore.Inc();
		assertEquals(2 * 5 * 8 * 11 * 14 * 17, arithmetic.product(6));
		productscore.Inc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductException() {
		arithmetic.product(0);
		productexceptionscore.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Product metode ved n < 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductException2() {
		arithmetic.product(-1);
		productexception2score.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Product metode ved n < 1");
	}

	@Test
	public void testFindElementIn() {
		// 2,5,8,11,14,17,...
		// position, element in sequence, max bound
		assertEquals(1, arithmetic.findElementIn(2, 20));
		findelementinscore.Inc();
		assertEquals(2, arithmetic.findElementIn(5, 20));
		findelementinscore.Inc();
		assertEquals(3, arithmetic.findElementIn(8, 20));
		findelementinscore.Inc();
		assertEquals(4, arithmetic.findElementIn(11, 20));
		findelementinscore.Inc();
		assertEquals(5, arithmetic.findElementIn(14, 20));
		findelementinscore.Inc();
		assertEquals(6, arithmetic.findElementIn(17, 20));
		findelementinscore.Inc();
		assertEquals(-1, arithmetic.findElementIn(1, 20));
		findelementinscore.Inc();
		assertEquals(-1, arithmetic.findElementIn(3, 20));
		findelementinscore.Inc();
		assertEquals(-1, arithmetic.findElementIn(4, 20));
		findelementinscore.Inc();
		assertEquals(-1, arithmetic.findElementIn(6, 20));
		findelementinscore.Inc();
		assertEquals(-1, arithmetic.findElementIn(7, 20));
		findelementinscore.Inc();
	}

	@Test
	public void testToString() {
		// 2,5,8,11,14,17,...
		assertEquals("2, 5, 8, 11, 14, 17, 20, 23, 26, 29, ...",
				arithmetic.toString());
		tostringscore.Inc();
	}

}
