package pe.accounting.conways.ui;

import static pe.accounting.conways.common.Consts.ALIVE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pe.accounting.conways.Observer;
import pe.accounting.conways.game.GameOfLife;

public class SwingRepresentation extends JPanel implements Observer, Representation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2304825463957134158L;

	private JFrame jFrame;
	private GameOfLife model;

	public SwingRepresentation(int width, int height) {
		jFrame = new JFrame("Game of Life");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.getContentPane().add(this);
		jFrame.setPreferredSize(new Dimension(width * 2, height * 2));
		jFrame.pack();
		jFrame.setLocationByPlatform(true);
		jFrame.setVisible(true);
	}

	@Override
	public void update(GameOfLife model) {
		this.model = model;
		this.paint();
	}

	@Override
	public void paint() {
		this.revalidate();
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (model == null) {
			return;
		}

		int width = getWidth();
		int height = getHeight();

		int[][] board = this.model.getBoard();
		int SIDE_X = board.length;
		int SIDE_Y = board[0].length;

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				Color c = board[i][j] == ALIVE ? Color.GREEN : Color.BLACK;
				g.setColor(c);

				int x = (i * width) / SIDE_X;
				int y = (j * height) / SIDE_Y;
				int w = ((i + 1) * width) / SIDE_X - x;
				int h = ((j + 1) * height) / SIDE_Y - y;
				g.fillRect(x, y, w, h);
			}

		}
	}

}
