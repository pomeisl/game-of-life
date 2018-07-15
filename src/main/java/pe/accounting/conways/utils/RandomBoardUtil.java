package pe.accounting.conways.utils;

import static pe.accounting.conways.common.Consts.ALIVE;
import static pe.accounting.conways.common.Consts.DEAD;

import java.util.Random;

/**
 * Random generation board provider to first step.
 * 
 * @author pomeisl
 *
 */
public class RandomBoardUtil {

	private static final Random rnd = new Random();

	/**
	 * Return a random seeds generation.
	 * 
	 * @return
	 */
	public static int[][] randomBoard(int minWidth, int maxWidth, int minHeight, int maxHeight) {

		int rows = nextInt(minWidth, maxWidth);
		int cols = nextInt(minHeight, maxHeight);
		int[][] board = new int[rows][cols];

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = nextInt(DEAD, ALIVE);
			}

		}

		return board;
	}

	private static int nextInt(int min, int max) {
		return rnd.nextInt(max - min + 1) + min;
	}

}
