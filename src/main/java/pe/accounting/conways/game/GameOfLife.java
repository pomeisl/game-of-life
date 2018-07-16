package pe.accounting.conways.game;

/**
 * Representation of game.
 * 
 * @author pomeisl
 *
 */
public interface GameOfLife {

	/**
	 * Update to new generation.
	 */
	void update();

	int[][] getBoard();

}
