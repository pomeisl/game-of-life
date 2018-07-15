package pe.accounting.conways.ui;

import java.io.PrintStream;

import lombok.RequiredArgsConstructor;
import pe.accounting.conways.GameOfLife;
import pe.accounting.conways.Observer;

/**
 * A concrete implementation of {@link Observer} that is represent the status of
 * game in a {@link PrintStream}.
 * 
 * @author pomeisl
 *
 */
@RequiredArgsConstructor
public class TerminalRepresenter implements Observer, Representer {

	private final PrintStream out;
	private GameOfLife model;

	/**
	 * Representing in the out named {@link PrintStream} object.
	 */
	@Override
	public void update(GameOfLife model) {
		this.model = model;
		this.paint();
	}

	@Override
	public void paint() {
		int[][] cellStates = this.model.getBoard();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cellStates.length; i++) {

			for (int j = 0; j < cellStates[0].length; j++) {
				sb.append(cellStates[i][j] == 0 ? " " : "*");
			}

			sb.append(System.lineSeparator());

		}

		out.print(sb.toString());
	}

}
