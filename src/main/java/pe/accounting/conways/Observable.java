package pe.accounting.conways;

/**
 * Interface to handle changes.
 * @author pomeisl
 *
 */
public interface Observable {

	/**
	 * Subscribe.
	 * @param observer
	 */
	void subscribe(Observer observer);
	
	/**
	 * Update all observers.
	 */
	void notifyObservsers();

}
