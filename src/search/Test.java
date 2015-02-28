package search;

import java.awt.Point;

import maybe.Predicate;
import SearchDataStructures.SearchStack;

public class Test {

	public static void main(String[] args) {
		// All testing done on things that are not nicks graph
		
		// TODO Auto-generated method stub
		Node<Point> n1 = new Node<Point>(new Point(0, 0));
		Node<Point> n2 = new Node<Point>(new Point(1, 1));
		Node<Point> n3 = new Node<Point>(new Point(1, 2));
		Node<Point> n4 = new Node<Point>(new Point(2, 3));
		Node<Point> n5 = new Node<Point>(new Point(2, 4));
		Node<Point> n6 = new Node<Point>(new Point(2, 6));
		Node<Point> n7 = new Node<Point>(new Point(2, 7));
		
		n3.addSuccessor(n6);
		n3.addSuccessor(n7);
		
		n2.addSuccessor(n4);
		n2.addSuccessor(n5);
		
		n1.addSuccessor(n2);
		n1.addSuccessor(n3);
		
		 Predicate<Node<Point>> p1 = new Predicate<Node<Point>>() {
				@Override
				public boolean holds(Node<Point> a) {
					return a.contents().y == 4;
				}
		 	};
		 
		System.out.println(Search.findNodeFrom(n1,p1, new SearchStack<Node<Point>>()));
		System.out.println();
		System.out.println(Search.findNodeFromDepthFirst(n1,p1));
	}

}
