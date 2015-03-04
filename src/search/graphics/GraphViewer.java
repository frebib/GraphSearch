package search.graphics;

import ilist.IList;
import search.Coordinate;
import search.graph.Node;

import javax.swing.JFrame;

public class GraphViewer {
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
