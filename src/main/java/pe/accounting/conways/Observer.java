package pe.accounting.conways;

/**
 * Observer interface to update representers.
 * 
 * @author pomeisl
 *
 */
public interface Observer {
	
	/**
	 * Notify the listener about the state of the game.
	 * 
	 * @param model
	 */
	void update(GameOfLife model);
	
}