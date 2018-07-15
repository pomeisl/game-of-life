package pe.accounting.conways;

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
	
	int getGeneration();

}
