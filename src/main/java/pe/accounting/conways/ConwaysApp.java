package pe.accounting.conways;

import pe.accounting.conways.game.GameOfLife;
import pe.accounting.conways.game.RandomGameOfLifeProxy;
import pe.accounting.conways.ui.SwingRepresentation;

public class ConwaysApp {

	public static void main(String[] args) {

		Observable observableGame = new RandomGameOfLifeProxy();
		GameOfLife game = (GameOfLife) observableGame;
		Observer window = new SwingRepresentation(game.getBoard().length, game.getBoard()[0].length);
		observableGame.subscribe(window);

		Runnable runnableGame = (Runnable) observableGame;
		runnableGame.run();

	}

}
