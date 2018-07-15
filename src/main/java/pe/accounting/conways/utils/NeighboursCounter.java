package pe.accounting.conways.utils;

import static pe.accounting.conways.common.Consts.ALIVE;

public final class NeighboursCounter {

	public static int countNeighbours(int[][] board, int x, int y) {

		if (board == null) {
			throw new IllegalArgumentException();
		}

		int count = 0;

		for (int i = x - 1; i <= x + 1; i++) {

			if (i >= 0 && i < board.length) { // fixed here
				for (int j = y - 1; j <= y + 1; j++) {

					if (j >= 0 && j < board[i].length) { // fixed here
						if (i != x || j != y) {
							if (board[i][j] == ALIVE) {
								count++;
							}
						}
					}

				}
			}

		}

		return count;
	}

}
