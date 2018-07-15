package pe.accounting.conways.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static pe.accounting.conways.common.Consts.MAX_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MAX_BOARD_WIDTH;
import static pe.accounting.conways.common.Consts.MIN_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MIN_BOARD_WIDTH;

import org.junit.Test;

public class RandomBoardUtilTest {

	@Test
	public void testRandomBoard_GenerateBoard_SucessfullyGenerate() {
		int[][] result = RandomBoardUtil.randomBoard(MIN_BOARD_WIDTH, MAX_BOARD_WIDTH,
				MIN_BOARD_HEIGHT, MAX_BOARD_HEIGHT);

		assertNotNull(result);
	}

	@Test
	public void testRandomBoard_GenerateBoard_StayInSize() {

		int[][] result = RandomBoardUtil.randomBoard(MIN_BOARD_WIDTH, MAX_BOARD_WIDTH,
				MIN_BOARD_HEIGHT, MAX_BOARD_HEIGHT);

		assertTrue(result.length <= MAX_BOARD_WIDTH && result.length >= MIN_BOARD_WIDTH
				&& result[0].length <= MAX_BOARD_HEIGHT && result[0].length >= MIN_BOARD_HEIGHT);
	}
}
