package pe.accounting.conways;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import pe.accounting.conways.ui.TerminalRepresenter;

public class GameOfLifeImplTest {

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

	@Test
	public void testAddListener_GivenObserver_PrivateListContainsThat() {
		Observable game = new GameOfLifeImpl(new int[][] {});
		Observer representer = mock(TerminalRepresenter.class);
		game.subscribe(representer);

		@SuppressWarnings("unchecked")
		final List<Observer> observers = (List<Observer>) Whitebox.getInternalState(game,
				"observers");

		assertTrue(observers.contains(representer));
	}

	@Test
	public void testUpdate_GivenObserver_BeUpdates() {
		Observable game = new GameOfLifeImpl(new int[][] {});
		Observer representer = mock(TerminalRepresenter.class);
		game.subscribe(representer);

		game.notifyObservsers();

		verify(representer, times(1)).update((GameOfLife) game);
	}

	@Test
	public void testGetGeneration_GivenGame_SucessfullyReturnGenerationNumber() {
		GameOfLife game = new GameOfLifeImpl(new int[][] { {} });
		game.update();

		assertEquals(2, game.getGeneration());
	}

}
