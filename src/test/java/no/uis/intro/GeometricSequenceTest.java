package test.java.no.uis.intro;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.no.uis.intro.*;
import main.java.autograder.Score;

public class GeometricSequenceTest {

	// 1,2,4,8,16,32
	private int r = 2, a = 1;
	private SearchableSequence geometric;

	private static Score getelementscore, sumscore, productscore,
			findelementinscore, sumexceptionscore, sumexception2score,
			productexceptionscore, productexception2score;

	@Before
	public void setUp() throws Exception {
		geometric = new GeometricSequence(r, a);
	}

	@BeforeClass
	public static void setUpResults() {
		Score.SetGlobalSecret("4483146ac34ac38ab4fe22326b19b487");
		getelementscore = new Score("Geometric - testGetElement", 1, 9);
		sumscore = new Score("Geometric - testSum", 1, 5);
		productscore = new Score("Geometric - testProduct", 1, 7);
		findelementinscore = new Score("Geometric - testFindElementIn", 1, 11);
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
		sumexceptionscore.PrintJSON();
		sumexception2score.PrintJSON();
		productexceptionscore.PrintJSON();
		productexception2score.PrintJSON();
	}

	@Test
	public void testGetElement() {
		assertEquals(0, geometric.getElement(-5));
		getelementscore.Inc();
		assertEquals(0, geometric.getElement(-1));
		getelementscore.Inc();
		assertEquals(0, geometric.getElement(0));
		getelementscore.Inc();
		assertEquals(1, geometric.getElement(1));
		getelementscore.Inc();
		assertEquals(2, geometric.getElement(2));
		getelementscore.Inc();
		assertEquals(4, geometric.getElement(3));
		getelementscore.Inc();
		assertEquals(8, geometric.getElement(4));
		getelementscore.Inc();
		assertEquals(16, geometric.getElement(5));
		getelementscore.Inc();
		assertEquals(32, geometric.getElement(6));
		getelementscore.Inc();
	}

	@Test
	public void testSum() {
		assertEquals(1, geometric.sum(1));
		sumscore.Inc();
		assertEquals(1 + r, geometric.sum(2));
		sumscore.Inc();
		assertEquals(1 + r + r * r, geometric.sum(3));
		sumscore.Inc();
		assertEquals(1 + r + r * r + r * r * r, geometric.sum(4));
		sumscore.Inc();
		assertEquals(1 + r + r * r + r * r * r + r * r * r * r,
				geometric.sum(5));
		sumscore.Inc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSumException() {
		geometric.sum(0);
		sumexceptionscore.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Sum metode ved n < 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSumException2() {
		geometric.sum(-1);
		sumexception2score.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Sum metode ved n < 1");
	}

	@Test
	public void testProduct() {
		// 1,2,4,8,16,32
		assertEquals(1, geometric.product(1));
		productscore.Inc();
		assertEquals(2, geometric.product(2));
		productscore.Inc();
		assertEquals(2 * 4, geometric.product(3));
		productscore.Inc();
		assertEquals(2 * 4 * 8, geometric.product(4));
		productscore.Inc();
		assertEquals(2 * 4 * 8 * 16, geometric.product(5));
		productscore.Inc();
		assertEquals(2 * 4 * 8 * 16 * 32, geometric.product(6));
		productscore.Inc();
		assertEquals(2 * 4 * 8 * 16 * 32 * 64, geometric.product(7));
		productscore.Inc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductException() {
		geometric.product(0);
		productexceptionscore.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Product metode ved n < 1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testProductException2() {
		geometric.product(-1);
		productexception2score.Dec();
		System.out
				.println("Manglende IllegalArgumentException fra Product metode ved n < 1");
	}

	@Test
	public void testFindElementIn() {
		// 1,2,4,8,16,32
		// position, element in sequence, max bound
		assertEquals(1, geometric.findElementIn(1, 20));
		findelementinscore.Inc();
		assertEquals(2, geometric.findElementIn(2, 20));
		findelementinscore.Inc();
		assertEquals(3, geometric.findElementIn(4, 20));
		findelementinscore.Inc();
		assertEquals(4, geometric.findElementIn(8, 20));
		findelementinscore.Inc();
		assertEquals(5, geometric.findElementIn(16, 20));
		findelementinscore.Inc();
		assertEquals(6, geometric.findElementIn(32, 20));
		findelementinscore.Inc();
		assertEquals(7, geometric.findElementIn(64, 20));
		findelementinscore.Inc();
		assertEquals(-1, geometric.findElementIn(3, 20));
		findelementinscore.Inc();
		assertEquals(-1, geometric.findElementIn(5, 20));
		findelementinscore.Inc();
		assertEquals(-1, geometric.findElementIn(6, 20));
		findelementinscore.Inc();
		assertEquals(-1, geometric.findElementIn(7, 20));
		findelementinscore.Inc();
	}

}
