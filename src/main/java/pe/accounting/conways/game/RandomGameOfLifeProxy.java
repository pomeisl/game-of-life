package pe.accounting.conways.game;

import static pe.accounting.conways.common.Consts.ALIVE;
import static pe.accounting.conways.common.Consts.DEAD;
import static pe.accounting.conways.common.Consts.MAX_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MAX_BOARD_WIDTH;
import static pe.accounting.conways.common.Consts.MIN_BOARD_HEIGHT;
import static pe.accounting.conways.common.Consts.MIN_BOARD_WIDTH;

import java.util.Random;

import pe.accounting.conways.Observable;
import pe.accounting.conways.Observer;

/**
 * Random generation board provider to first step.
 * 
 * @author pomeisl
 *
 */
public class RandomGameOfLifeProxy implements GameOfLife, Observable, Runnable {

	private static final Random rnd = new Random();

	private final GameOfLife REAL_SUBJECT;

	public RandomGameOfLifeProxy() {
		int[][] randomBoard = generateRandomBoard();
		this.REAL_SUBJECT = new GameOfLifeImpl(randomBoard);
	}

	@Override
	public void subscribe(Observer observer) {
		Observable observable = (Observable) REAL_SUBJECT;
		observable.subscribe(observer);
	}

	@Override
	public void notifyObservsers() {
		Observable observable = (Observable) REAL_SUBJECT;
		observable.notifyObservsers();
	}

	@Override
	public void update() {
		REAL_SUBJECT.update();
	}

	@Override
	public int[][] getBoard() {
		return REAL_SUBJECT.getBoard();
	}

	@Override
	public void run() {
		Runnable runnable = (Runnable) REAL_SUBJECT;
		runnable.run();
	}

	/**
	 * Return a random seeds generation.
	 * 
	 * @return
	 */
	public int[][] generateRandomBoard() {

		int rows = nextInt(MIN_BOARD_WIDTH, MAX_BOARD_WIDTH);
		int cols = nextInt(MIN_BOARD_HEIGHT, MAX_BOARD_HEIGHT);
		int[][] board = new int[rows][cols];

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = nextInt(DEAD, ALIVE);
			}

		}

		return board;
	}

	private int nextInt(int min, int max) {
		return rnd.nextInt(max - min + 1) + min;
	}

}
