package pe.accounting.conways;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(runnableGame, 0, 10L, TimeUnit.MILLISECONDS);

	}

}
