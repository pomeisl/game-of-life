package pe.accounting.conways.utils;

import static pe.accounting.conways.common.Consts.ALIVE;
import static pe.accounting.conways.common.Consts.DEAD;;

public class LifeRules {

	public static int getNewState(final int currentState, final int liveNeighbors) throws IllegalArgumentException {

		if (currentState > 1 || currentState < 0 || liveNeighbors > 8 || liveNeighbors < 0) {
			throw new IllegalArgumentException();
		}

		switch (currentState) {
		case ALIVE:
			if (liveNeighbors < 2 || liveNeighbors > 3) {
				return DEAD;
			}
			break;
		case DEAD:
			if (liveNeighbors == 3) {
				return ALIVE;
			}
			break;
		}

		return currentState;
	}

}
