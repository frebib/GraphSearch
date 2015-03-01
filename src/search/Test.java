package search;

import maybe.Predicate;
import search.datastructures.SearchQueue;
import search.datastructures.SearchStack;
import search.graph.Coordinate;
import search.graph.Node;

public class Test {

	public static void main(String[] args) {
		// All testing done on things that are not nicks graph

		Node<Coordinate> n1 = new Node<Coordinate>(new Coordinate(0, 0));
		Node<Coordinate> n2 = new Node<Coordinate>(new Coordinate(1, 1));
		Node<Coordinate> n3 = new Node<Coordinate>(new Coordinate(1, 2));
		Node<Coordinate> n4 = new Node<Coordinate>(new Coordinate(2, 3));
		Node<Coordinate> n5 = new Node<Coordinate>(new Coordinate(2, 4));
		Node<Coordinate> n6 = new Node<Coordinate>(new Coordinate(2, 6));
		Node<Coordinate> n7 = new Node<Coordinate>(new Coordinate(2, 7));

		n3.addSuccessor(n6);
		n3.addSuccessor(n7);

		n2.addSuccessor(n4);
		n2.addSuccessor(n5);

		n1.addSuccessor(n2);
		n1.addSuccessor(n3);

		Predicate<Coordinate> p1 = p -> p.y == 4;
		Predicate<Coordinate> p2 = p -> p.y == 0;

		System.out.println(Search.findNodeFrom(n1, p2, new SearchQueue<Node<Coordinate>>()));
		System.out.println(BreadthFirst.findNodeFrom(n1, p1) + "\n");
		System.out.println(Search.findNodeFrom(n1, p1, new SearchStack<Node<Coordinate>>()));
		System.out.println(DepthFirst.findNodeFrom(n1, p1));
		System.out.println(Search.findPathFrom(n1, p1, new SearchStack<Node<Coordinate>>()));
		System.out.println(Search.findPathFrom(n1, p2, new SearchStack<Node<Coordinate>>()));
	}
}