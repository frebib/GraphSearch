package search.graphics;

import search.Coordinate;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * View to display a {@link search.graphics.Traverser} on a {@link javax.swing.JPanel}
 *
 * @author Kelsey McKenna
 */
public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private Traverser traverser;

	/**
	 * Creates a new View
	 *
	 * @param traverser {@link search.graphics.Traverser} to display
	 */
	public View(Traverser traverser) {
		this.traverser = traverser;
		traverser.addObserver(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int width = getWidth();
		int height = getHeight();
		int dx = 10;
		int dy = 7;

		g2.clearRect(0, 0, width, height);
		g2.setColor(Color.BLACK);

		int hy = height / dy;
		for (int i = 1; i < dy; i++)
			g2.drawLine(0, i * hy, width, i * hy);

		int hx = width / dx;
		for (int i = 1; i < dx; i++)
			g2.drawLine(i * hx, 0, i * hx, height);

		// Draw nodes
		double xSpacing = width / dx;
		double ySpacing = height / dy;
		for (int i = 0; i < dx; ++i) {
			double x = i * xSpacing;
			for (int j = 0; j < dy; ++j) {
				Coordinate c = new Coordinate(i, j);
				double y = j * ySpacing;
				Ellipse2D.Double e = new Ellipse2D.Double(x, y, 0.6 * width / dx, 0.6 * height / dy);

				if (traverser.isRunning() && traverser.getCurrentNode().contentsEquals(c)) {
					if (traverser.endReached())
						g2.setColor(Color.red.brighter());
					else
						g2.setColor(Color.green.brighter());

					g2.fill(e);
					g2.setColor(Color.BLACK);
				}

				g2.draw(e);

				g2.drawString(String.format("(%d,%d)", i, j), (int) (x + xSpacing / 5), (int) (y + ySpacing / 3));
			}
		}

		// Draw lines
		g2.setStroke(new BasicStroke(10));
		g2.drawLine((int) (0.8 * xSpacing), (int) (1.9 * ySpacing), (int) (0.8 * xSpacing), (int) (4.8 * ySpacing));
		g2.drawLine((int) (8.8 * xSpacing), (int) (1.9 * ySpacing), (int) (8.8 * xSpacing), (int) (4.8 * ySpacing));

		g2.drawLine((int) (2.8 * xSpacing), (int) (2.9 * ySpacing), (int) (6.8 * xSpacing), (int) (2.9 * ySpacing));
		g2.drawLine((int) (2.8 * xSpacing), (int) (4.9 * ySpacing), (int) (6.8 * xSpacing), (int) (4.9 * ySpacing));
		g2.drawLine((int) (3.8 * xSpacing), (int) (2.9 * ySpacing), (int) (3.8 * xSpacing), (int) (4.9 * ySpacing));
		g2.drawLine((int) (5.8 * xSpacing), (int) (2.9 * ySpacing), (int) (5.8 * xSpacing), (int) (4.9 * ySpacing));

		g2.drawLine((int) (3.8 * xSpacing), 0, (int) (3.8 * xSpacing), (int) (0.8 * ySpacing));
		g2.drawLine((int) (5.8 * xSpacing), 0, (int) (5.8 * xSpacing), (int) (0.8 * ySpacing));
		g2.drawLine((int) (3.8 * xSpacing), (int) (0.8 * ySpacing), (int) (5.8 * xSpacing), (int) (0.8 * ySpacing));

		g2.drawLine((int) (3.8 * xSpacing), height, (int) (3.8 * xSpacing), (int) (0.83 * height));
		g2.drawLine((int) (5.8 * xSpacing), height, (int) (5.8 * xSpacing), (int) (0.83 * height));
		g2.drawLine((int) (3.8 * xSpacing), (int) (0.83 * height), (int) (5.8 * xSpacing), (int) (0.83 * height));
	}
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
