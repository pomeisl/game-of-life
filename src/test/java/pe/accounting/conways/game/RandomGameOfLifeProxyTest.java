package pe.accounting.conways.game;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static pe.accounting.conways.common.Consts.MAX_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MAX_BOARD_WIDTH;
import static pe.accounting.conways.common.Consts.MIN_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MIN_BOARD_WIDTH;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import pe.accounting.conways.game.GameOfLife;
import pe.accounting.conways.game.RandomGameOfLifeProxy;

public class RandomGameOfLifeProxyTest {

	@Test
	public void initialize_GivenGameOfLifeImplementation_SucessfullyInitialize() {
		GameOfLife game = new RandomGameOfLifeProxy();
		GameOfLife realSubject = (GameOfLife) Whitebox.getInternalState(game, "REAL_SUBJECT");

		assertNotNull(game);
		assertNotNull(realSubject);
	}

	@Test
	public void testGenerateRandomBoard_GenerateBoard_SucessfullyGenerate() {
		int[][] result = new RandomGameOfLifeProxy().generateRandomBoard();

		assertNotNull(result);
	}

	@Test
	public void testGenerateRandomBoard_GenerateBoard_StayInSize() {
		int[][] result = new RandomGameOfLifeProxy().generateRandomBoard();

		assertTrue(result.length <= MAX_BOARD_WIDTH && result.length >= MIN_BOARD_WIDTH && result[0].length <= MAX_BOARD_HEIGHT
				&& result[0].length >= MIN_BOARD_HEIGHT);
	}

}
