package pe.accounting.conways;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import pe.accounting.conways.common.Consts;
import pe.accounting.conways.game.GameOfLife;
import pe.accounting.conways.game.GameOfLifeImpl;
import pe.accounting.conways.ui.SwingRepresentation;
import pe.accounting.conways.utils.LifeRules;

public class ConwaysTest {

	@Test
	public void testUpdateTest_GivenBoard_SucesfullyUpdate() {
		int[][] input = { //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 1, 0, 0 }, //
				{ 0, 0, 1, 0, 1, 0, 0 }, //
				{ 0, 0, 0, 1, 1, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 } };

		int[][] expected = { //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 1, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 1, 1, 0 }, //
				{ 0, 0, 0, 1, 1, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0 } };

		GameOfLife game = new GameOfLifeImpl(input);
		game.update();

		assertArrayEquals(expected, game.getBoard());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAddListener_GivenObserver_PrivateListContainsThat() {
		Observable game = new GameOfLifeImpl(new int[][] {});
		Observer representer = mock(SwingRepresentation.class);
		game.subscribe(representer);

		final List<Observer> observers = (List<Observer>) Whitebox.getInternalState(game, "observers");

		assertTrue(observers.contains(representer));
	}

	@Test
	public void testUpdate_GivenObserver_BeUpdates() {
		Observable game = new GameOfLifeImpl(new int[][] {});
		Observer representer = mock(SwingRepresentation.class);
		game.subscribe(representer);

		game.notifyObservsers();

		verify(representer, times(1)).update((GameOfLife) game);
	}

	@Test
	public void Consts_SuccessfullyInitialize() {
		assertNotNull(new Consts());
	}

	@Test
	public void LifeRules_SuccessfullyInitialize() {
		assertNotNull(new LifeRules());
	}

}
