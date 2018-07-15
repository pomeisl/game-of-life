package pe.accounting.conways.utils;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import pe.accounting.conways.utils.NeighboursCounter;

@RunWith(Enclosed.class)
public class NeighboursCounterTest {

	@RunWith(Parameterized.class)
	public static class ParametertizedTest {
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] { //
					{ new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 } }, 1, 1, 2 }, //
					{ new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }, 1, 1, 8 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 1, 1 } }, 1, 1, 7 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 1, 0 } }, 1, 1, 6 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 0 } }, 1, 1, 5 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 0, 0 }, { 1, 1, 0 } }, 1, 1, 5 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 1, 1 }, { 0, 0, 0 } }, 1, 1, 4 }, //
					{ new int[][] { { 1, 1, 1 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1, 3 }, //
					{ new int[][] { { 1, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1, 2 }, //
					{ new int[][] { { 1, 0 }, { 0, 0 }, { 0, 0 } }, 1, 1, 1 }, //
					{ new int[][] { { 1, 0 }, { 0, 0 }, { 0, 0 } }, 0, 0, 0 } //
			});
		}

		@Parameter
		public int[][] inputBoard;

		@Parameter(1)
		public int posX;

		@Parameter(2)
		public int posY;

		@Parameter(3)
		public int expextedLiveNeighbour;

		@Test
		public void test() {
			int actualLiveNeighbour = NeighboursCounter.countNeighbours(inputBoard, posX, posY);
			assertEquals(expextedLiveNeighbour, actualLiveNeighbour);
		}

	}

	public static class NonParameterizedTest {

		@Test(expected = IllegalArgumentException.class)
		public void test() {
			NeighboursCounter.countNeighbours(null, 1, 1);
		}

	}

}
