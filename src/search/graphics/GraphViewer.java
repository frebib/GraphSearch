package search.graphics;

import ilist.IList;
import search.Coordinate;
import search.graph.Graph;
import search.graph.Node;

import javax.swing.JFrame;

/**
 * Displays and traverses a Path on a map in a {@link JFrame}
 *
 * @author Kelsey McKenna
 * @author frebib
 */
public class GraphViewer {
	/**
	 * Creates a new {@link JFrame} with a {@link View}, displays the {@link Graph}, traverses the path with a delay between the {@link Node}{@code s} then closes the {@link JFrame}
	 *
	 * @param path Path to Traverse
	 * @param nodeDelay Time in ms between {@link Node}{@code s} in the Path
	 */
	public static void traversePath(IList<Node<Coordinate>> path, int nodeDelay) {
		Traverser traverser = new Traverser();
		View v = new View(traverser);

		JFrame frame = new JFrame("Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600);
		frame.add(v);
		frame.setVisible(true);

		traverser.runTraversal(path, nodeDelay);
		try {
			Thread.sleep(nodeDelay * 2);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.setVisible(false);
		frame.dispose();
	}
}
