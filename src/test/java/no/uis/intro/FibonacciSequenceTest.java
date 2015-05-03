package test.java.no.uis.intro;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.no.uis.intro.*;
import main.java.autograder.Score;

public class FibonacciSequenceTest {

	private SearchableSequence fibonacci;

	private static Score getelementscore, sumscore, productscore,
			findelementinscore, getelementboundsscore, getelementbounds2score;

	@Before
	public void setUp() throws Exception {
		fibonacci = new FibonacciSequence();
	}

	@BeforeClass
	public static void setUpResults() {
		Score.SetGlobalSecret("4483146ac34ac38ab4fe22326b19b487");
		getelementscore = new Score("Fibonacci - testGetElement", 1, 10);
		sumscore = new Score("Fibonacci - testSum", 1, 7);
		productscore = new Score("Fibonacci - testProduct", 1, 7);
		findelementinscore = new Score("Fibonacci - testFindElementIn", 1, 11);
		getelementboundsscore = new Score("Fibonacci - testGetElementBounds",
				1, 1, 1);
		getelementbounds2score = new Score("Fibonacci - testGetElementBounds2",
				1, 1, 1);
	}

	@AfterClass
	public static void PrintResults() {
		getelementscore.PrintJSON();
		sumscore.PrintJSON();
		productscore.PrintJSON();
		findelementinscore.PrintJSON();
		getelementboundsscore.PrintJSON();
		getelementbounds2score.PrintJSON();
	}

	@Test
	public void testGetElement() {
		assertEquals(0, fibonacci.getElement(0));
		getelementscore.Inc();
		assertEquals(1, fibonacci.getElement(1));
		getelementscore.Inc();
		assertEquals(1, fibonacci.getElement(2));
		getelementscore.Inc();
		assertEquals(2, fibonacci.getElement(3));
		getelementscore.Inc();
		assertEquals(3, fibonacci.getElement(4));
		getelementscore.Inc();
		assertEquals(5, fibonacci.getElement(5));
		getelementscore.Inc();
		assertEquals(8, fibonacci.getElement(6));
		getelementscore.Inc();
		assertEquals(13, fibonacci.getElement(7));
		getelementscore.Inc();
		assertEquals(102334155, fibonacci.getElement(40));
		getelementscore.Inc();
		assertEquals(1836311903, fibonacci.getElement(46));
		getelementscore.Inc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetElementBounds() {
		fibonacci.getElement(-1);
		getelementboundsscore.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra GetElementBounds metode ved n < 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetElementBounds2() {
		fibonacci.getElement(47);
		getelementbounds2score.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra GetElementBounds metode ved n < 1");
	}

	@Test
	public void testSum() {
		assertEquals(0 + 1, fibonacci.sum(1));
		sumscore.Inc();
		assertEquals(0 + 1 + 1, fibonacci.sum(2));
		sumscore.Inc();
		assertEquals(0 + 1 + 1 + 2, fibonacci.sum(3));
		sumscore.Inc();
		assertEquals(0 + 1 + 1 + 2 + 3, fibonacci.sum(4));
		sumscore.Inc();
		assertEquals(0 + 1 + 1 + 2 + 3 + 5, fibonacci.sum(5));
		sumscore.Inc();
		assertEquals(0 + 1 + 1 + 2 + 3 + 5 + 8, fibonacci.sum(6));
		sumscore.Inc();
		assertEquals(0 + 1 + 1 + 2 + 3 + 5 + 8 + 13, fibonacci.sum(7));
		sumscore.Inc();
	}

	@Test
	public void testProduct() {
		assertEquals(1, fibonacci.product(1));
		productscore.Inc();
		assertEquals(1 * 1, fibonacci.product(2));
		productscore.Inc();
		assertEquals(1 * 1 * 2, fibonacci.product(3));
		productscore.Inc();
		assertEquals(1 * 1 * 2 * 3, fibonacci.product(4));
		productscore.Inc();
		assertEquals(1 * 1 * 2 * 3 * 5, fibonacci.product(5));
		productscore.Inc();
		assertEquals(1 * 1 * 2 * 3 * 5 * 8, fibonacci.product(6));
		productscore.Inc();
		assertEquals(1 * 1 * 2 * 3 * 5 * 8 * 13, fibonacci.product(7));
		productscore.Inc();
	}

	@Test
	public void testFindElementIn() {
		// position, element in sequence, max bound
		assertEquals(1, fibonacci.findElementIn(1, 20));
		findelementinscore.Inc();
		assertEquals(3, fibonacci.findElementIn(2, 20));
		findelementinscore.Inc();
		assertEquals(4, fibonacci.findElementIn(3, 20));
		findelementinscore.Inc();
		assertEquals(5, fibonacci.findElementIn(5, 20));
		findelementinscore.Inc();
		assertEquals(6, fibonacci.findElementIn(8, 20));
		findelementinscore.Inc();
		assertEquals(7, fibonacci.findElementIn(13, 20));
		findelementinscore.Inc();
		assertEquals(8, fibonacci.findElementIn(21, 20));
		findelementinscore.Inc();
		assertEquals(-1, fibonacci.findElementIn(4, 20));
		findelementinscore.Inc();
		assertEquals(-1, fibonacci.findElementIn(6, 20));
		findelementinscore.Inc();
		assertEquals(-1, fibonacci.findElementIn(7, 20));
		findelementinscore.Inc();
		assertEquals(-1, fibonacci.findElementIn(15, 20));
		findelementinscore.Inc();
	}

}
