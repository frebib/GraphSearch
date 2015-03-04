package search;

import ilist.IList;
import search.graph.Graph;
import search.graph.NicksGraph;
import search.graph.Node;
import search.graphics.GraphViewer;

/**
 * A class to test the Search methods on a graph
 * 
 * @author Jack Hair
 */

public class Test {
	public static void main(String[] args) {
		final Graph<Coordinate> nicksGraph = NicksGraph.getGraph();
		final Node<Coordinate> start = nicksGraph.nodeWith(new Coordinate(0, 0));
		final Node<Coordinate> goal = new Node<Coordinate>(new Coordinate(9, 6));
		final Node<Coordinate> inaccessable = new Node<Coordinate>(new Coordinate(4, 0));

		// Assert that the findNodeFrom methods work correctly
		assert (BreadthFirst.findNodeFrom(start, goal).has(goal));
		assert (DepthFirst.findNodeFrom(start, goal).has(goal));
		assert (BreadthFirst.findNodeFrom(start, inaccessable).isNothing());
		assert (DepthFirst.findNodeFrom(start, inaccessable).isNothing());

		IList<Node<Coordinate>> bf = BreadthFirst.findPathFrom(start, goal).fromMaybe();
		IList<Node<Coordinate>> df = DepthFirst.findPathFrom(start, goal).fromMaybe();
		IList<Node<Coordinate>> as = AStar.findPathFrom(start, goal, SearchFunction.manhattan, SearchFunction.euclidean).fromMaybe();
		System.out.println(bf + "\n" + df + "\n" + as);

		GraphViewer.traversePath(bf, 350);
	}

	@SuppressWarnings("unused")
	private static Node<Coordinate> getTestGraph() {
		Node<Coordinate> n1 = new Node<Coordinate>(new Coordinate(0, 0));	//         0,0
		Node<Coordinate> n2 = new Node<Coordinate>(new Coordinate(1, 1));	//       /     \
		Node<Coordinate> n3 = new Node<Coordinate>(new Coordinate(1, 2));	//    1,1       1,2
		Node<Coordinate> n4 = new Node<Coordinate>(new Coordinate(2, 3));	//   /   \     /   \
		Node<Coordinate> n5 = new Node<Coordinate>(new Coordinate(2, 4));	// 2,3  2,4   2,6  2,7
		Node<Coordinate> n6 = new Node<Coordinate>(new Coordinate(2, 6));
		Node<Coordinate> n7 = new Node<Coordinate>(new Coordinate(2, 7));

		n3.addSuccessor(n6);
		n3.addSuccessor(n7);

		n2.addSuccessor(n4);
		n2.addSuccessor(n5);

		n1.addSuccessor(n2);
		n1.addSuccessor(n3);

		return n1;
	}
}