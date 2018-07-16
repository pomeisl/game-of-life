package pe.accounting.conways.utils;

import static org.junit.Assert.assertEquals;
import static pe.accounting.conways.common.Consts.ALIVE;
import static pe.accounting.conways.common.Consts.DEAD;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class LifeRulesTest {

	@RunWith(Parameterized.class)
	public static class AllRulesTest {

		@Parameters(name = "{index}, Status: {0}, Neighbours: {1}, Expected status: {2}")
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] { //
					// 1. Any live cell with fewer than two live neighbors dies, as if by under
					// population.
					{ ALIVE, 0, DEAD }, { ALIVE, 1, DEAD },
					// 2. Any live cell with two or three live neighbors lives on to the next
					// generation.
					{ ALIVE, 2, ALIVE }, { ALIVE, 3, ALIVE },
					// 3. Any live cell with more than three live neighbors dies, as if by
					// overpopulation.
					{ ALIVE, 4, DEAD }, { ALIVE, 5, DEAD }, { ALIVE, 6, DEAD }, { ALIVE, 7, DEAD }, { ALIVE, 8, DEAD },
					// 4. Any dead cell with exactly three live neighbors becomes a live cell, as if
					// by reproduction.
					{ DEAD, 0, DEAD }, { DEAD, 1, DEAD }, { DEAD, 2, DEAD }, { DEAD, 3, ALIVE }, { DEAD, 4, DEAD }, { DEAD, 5, DEAD }, { DEAD, 6, DEAD },
					{ DEAD, 7, DEAD }, { DEAD, 8, DEAD } });
		}

		@Parameter
		public int currentState;

		@Parameter(1)
		public int liveNeighbors;

		@Parameter(2)
		public int expected;

		@Test
		public void testGetNewState_GivenCell_SucessfullyReturnNewState() {
			assertEquals(expected, LifeRules.getNewState(currentState, liveNeighbors));
		}

	}

	@RunWith(Parameterized.class)
	public static class ExpetionBranchesTest {

		@Parameters(name = "{index}, Status: {0}, Neighbours: {1}")
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] { { -1, 0 }, { 2, 0 }, { -1, 2 }, { 2, 2 }, { -1, 1 }, { 2, 1 }, { -1, 3 }, { 2, 3 }, { -1, 4 }, { 2, 4 },
					{ -1, 5 }, { 2, 5 }, { -1, 6 }, { 2, 6 }, { -1, 7 }, { 2, 7 }, { -1, 8 }, { 2, 8 }, { 0, 9 }, { 0, -1 }, { 1, 9 }, { 1, -1 } });
		}

		@Parameter
		public int currentState;

		@Parameter(1)
		public int liveNeighbors;

		@Test(expected = IllegalArgumentException.class)
		public void testGetNewState_GivenCell_Throws() {
			LifeRules.getNewState(currentState, liveNeighbors);
		}

	}

}
