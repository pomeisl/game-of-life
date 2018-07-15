package pe.accounting.conways;

import static pe.accounting.conways.common.Consts.MAX_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MAX_BOARD_WIDTH;
import static pe.accounting.conways.common.Consts.MIN_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MIN_BOARD_WIDTH;

import pe.accounting.conways.ui.SwingRepresenter;
import pe.accounting.conways.utils.RandomBoardUtil;

public class ConwaysApp {

	public static void main(String[] args) {

		int[][] board = RandomBoardUtil.randomBoard(MIN_BOARD_WIDTH, MAX_BOARD_WIDTH,
				MIN_BOARD_HEIGHT, MAX_BOARD_HEIGHT);

		Observable observable = new GameOfLifeImpl(board);
		observable.subscribe(new SwingRepresenter(board.length, board[0].length));

		Runnable game = (Runnable) observable;
		game.run();

	}

}
