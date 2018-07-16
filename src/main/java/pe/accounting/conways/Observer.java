package pe.accounting.conways;

import pe.accounting.conways.game.GameOfLife;

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