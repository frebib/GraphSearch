package search;

import maybe.Predicate;

import java.util.Map;

public class NicksGraph {
	public static void main(String args[]) {
		Graph<Coordinate> nicksGraph = getNicksGraph();
		// Create the start node and end node
		Node<Coordinate> start = nicksGraph.nodeWith(new Coordinate(0, 0));
		final Node<Coordinate> end = nicksGraph.nodeWith(new Coordinate(8, 6));
		final Node<Coordinate> inaccessableNode = nicksGraph.nodeWith(new Coordinate(4, 0));

		Predicate<Coordinate> p1 = a -> a == end.getContents();
		Predicate<Coordinate> p2 = a -> a == inaccessableNode.getContents();

		// Assert that the findNodeFrom methods work correctly
		assert (BreadthFirst.findNodeFrom(start, p1).has(end));
		assert (DepthFirst.findNodeFrom(start, p1).has(end));
		assert (BreadthFirst.findNodeFrom(start, p2).isNothing());
		assert (DepthFirst.findNodeFrom(start, p2).isNothing());
	}

	public static void printGraph(Graph<Coordinate> graph) {
		for (Map.Entry<Coordinate, Node<Coordinate>> e : graph.nodes().entrySet()) {
			Coordinate c = e.getKey();
			Node<Coordinate> node = e.getValue();

			assert (c.equals(node.getContents()));

			System.out.print(c + "): ");
			for (Node<Coordinate> s : node.getSuccessors())
				System.out.print(s.getContents() + "), ");
			System.out.println();
		}
	}

	public static Graph<Coordinate> parseGraph(int[][] values) {
		Graph<Coordinate> graph = new Graph<Coordinate>();

		for (int[] element : values) {
			assert (element.length >= 2);       // (1) // What we are going to do relies on
			assert (element.length % 2 == 0);   // (2) // the two following facts about graph

			int x = element[0];					// Can't get array out of bounds
			int y = element[1]; 				// because of assertion (1).
			Coordinate c = new Coordinate(x, y);

			// Find or create node:
			Node<Coordinate> node = graph.nodeWith(c);

			for (int i = 2; i < element.length; i += 2) {	// And next add the node's successors. We rely on assertion
				int sx = element[i];							// (2) again to avoid array out of bounds. Now we start from
				int sy = element[i + 1];						// position 2, as positions 0 and 1 have already been looked at
				Coordinate sc = new Coordinate(sx, sy);			// (they are x and y). Notice that we need to increment by 2.
				Node<Coordinate> s = graph.nodeWith(sc);
				node.addSuccessor(s);							// Find or create successor node, and then add it
			}
		}

		return graph;
	}

	public static Graph<Coordinate> getNicksGraph() {
		return parseGraph(getNicksValues());
	}
	private static int[][] getNicksValues() {
		return new int[][] {
			{ 0, 0, 1, 0, 0, 1 },
			{ 0, 1, 0, 0, 1, 1, 0, 2 },
			{ 0, 2, 0, 3, 0, 1 },
			{ 0, 3, 0, 2, 0, 4 },
			{ 0, 4, 0, 3, 0, 5 },
			{ 0, 5, 0, 6, 1, 5, 0, 4 },
			{ 0, 6, 1, 6, 0, 5 },
			{ 1, 0, 0, 0, 1, 1, 2, 0 },
			{ 1, 1, 1, 2, 2, 1, 1, 0, 0, 1 },
			{ 1, 2, 2, 2, 1, 1, 1, 3 },
			{ 1, 3, 1, 2, 1, 4, 2, 3 },
			{ 1, 4, 2, 4, 1, 5, 1, 3 },
			{ 1, 5, 1, 4, 2, 5, 1, 6, 0, 5 },
			{ 1, 6, 0, 6, 1, 5, 2, 6 },
			{ 2, 0, 3, 0, 2, 1, 1, 0 },
			{ 2, 1, 2, 2, 1, 1, 2, 0, 3, 1 },
			{ 2, 2, 1, 2, 2, 1, 2, 3, 3, 2 },
			{ 2, 3, 2, 2, 2, 4, 3, 3, 1, 3 },
			{ 2, 4, 1, 4, 2, 5, 2, 3, 3, 4 },
			{ 2, 5, 2, 4, 1, 5, 2, 6, 3, 5 },
			{ 2, 6, 3, 6, 2, 5, 1, 6 },
			{ 3, 0, 2, 0, 3, 1 },
			{ 3, 1, 3, 0, 4, 1, 2, 1, 3, 2 },
			{ 3, 2, 2, 2, 4, 2, 3, 1 },
			{ 3, 3, 2, 3, 3, 4 },
			{ 3, 4, 2, 4, 3, 3 },
			{ 3, 5, 3, 6, 2, 5, 4, 5 },
			{ 3, 6, 2, 6, 3, 5 },
			{ 4, 0 },
			{ 4, 1, 4, 2, 5, 1, 3, 1 },
			{ 4, 2, 4, 1, 5, 2, 3, 2 },
			{ 4, 3 },
			{ 4, 4 },
			{ 4, 5, 5, 5, 3, 5 },
			{ 4, 6 },
			{ 5, 0 },
			{ 5, 1, 4, 1, 5, 2, 6, 1 },
			{ 5, 2, 4, 2, 5, 1, 6, 2 },
			{ 5, 3 },
			{ 5, 4 },
			{ 5, 5, 4, 5, 6, 5 },
			{ 5, 6 },
			{ 6, 0, 7, 0, 6, 1 },
			{ 6, 1, 6, 0, 5, 1, 6, 2, 7, 1 },
			{ 6, 2, 5, 2, 6, 1, 7, 2 },
			{ 6, 3, 7, 3, 6, 4 },
			{ 6, 4, 6, 3, 7, 4 },
			{ 6, 5, 5, 5, 6, 6, 7, 5 },
			{ 6, 6, 7, 6, 6, 5 },
			{ 7, 0, 6, 0, 7, 1, 8, 0 },
			{ 7, 1, 8, 1, 7, 0, 6, 1, 7, 2 },
			{ 7, 2, 7, 3, 8, 2, 6, 2, 7, 1 },
			{ 7, 3, 6, 3, 7, 2, 7, 4, 8, 3 },
			{ 7, 4, 7, 3, 8, 4, 6, 4, 7, 5 },
			{ 7, 5, 8, 5, 7, 6, 7, 4, 6, 5 },
			{ 7, 6, 6, 6, 7, 5, 8, 6 },
			{ 8, 0, 8, 1, 7, 0, 9, 0 },
			{ 8, 1, 8, 2, 9, 1, 7, 1, 8, 0 },
			{ 8, 2, 8, 1, 7, 2, 8, 3 },
			{ 8, 3, 8, 2, 7, 3, 8, 4 },
			{ 8, 4, 8, 5, 8, 3, 7, 4 },
			{ 8, 5, 9, 5, 8, 4, 7, 5, 8, 6 },
			{ 8, 6, 8, 5, 7, 6, 9, 6 },
			{ 9, 0, 9, 1, 8, 0 },
			{ 9, 1, 8, 1, 9, 2, 9, 0 },
			{ 9, 2, 9, 1, 9, 3 },
			{ 9, 3, 9, 2, 9, 4 },
			{ 9, 4, 9, 5, 9, 3 },
			{ 9, 5, 8, 5, 9, 4, 9, 6 },
			{ 9, 6, 9, 5, 8, 6 } };
	}
}
