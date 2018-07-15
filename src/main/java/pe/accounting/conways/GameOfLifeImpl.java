package pe.accounting.conways;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import pe.accounting.conways.utils.LifeRules;
import pe.accounting.conways.utils.NeighboursCounter;

public class GameOfLifeImpl implements GameOfLife, Observable, Runnable {

	private @Getter int[][] board;
	private @Getter int generation;
	private List<Observer> observers;

	public GameOfLifeImpl(final int[][] board) {
		this.board = board;
		this.observers = new LinkedList<>();
		generation++;
	}

	@Override
	public void update() {
		int[][] next = new int[board.length][board[0].length];

		for (int i = 0; i < next.length; i++) {

			for (int j = 0; j < next[0].length; j++) {

				int currentState = board[i][j];
				int liveNeighbours = NeighboursCounter.countNeighbours(board, i, j);
				int nextState = LifeRules.getNewState(currentState, liveNeighbours);
				next[i][j] = nextState;

			}

		}

		board = next;
		generation++;
		
		this.notifyObservsers();
	}

	@Override
	public void subscribe(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservsers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	@Override
	public void run() {
		while (true) {
			this.update();
		}
	}

}
