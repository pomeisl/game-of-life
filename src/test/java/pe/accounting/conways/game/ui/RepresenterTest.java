package pe.accounting.conways.game.ui;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import pe.accounting.conways.GameOfLife;
import pe.accounting.conways.GameOfLifeImpl;
import pe.accounting.conways.Observable;
import pe.accounting.conways.Observer;
import pe.accounting.conways.ui.TerminalRepresenter;

public class RepresenterTest {

	@Test
	public void TesrminalRepresenter_GivenGame_SuceffulyWriteToPrintStream()
			throws UnsupportedEncodingException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);

		int[][] input = { //
				{ 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 1, 0 }, //
				{ 0, 1, 0, 1, 0 }, //
				{ 0, 0, 1, 1, 0 }, //
				{ 0, 0, 0, 0, 0 } };

		Observable observable = new GameOfLifeImpl(input);
		Observer subject = new TerminalRepresenter(out);
		observable.subscribe(subject);
		GameOfLife game = (GameOfLife) observable;
		game.update();

		String expected = "     \r\n  *  \r\n   **\r\n  ** \r\n     \r\n";

		String result = new String(baos.toByteArray());
		assertEquals(expected, result);
	}

}
