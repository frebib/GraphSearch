package search;

import search.graph.Node;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class DepthFirst {
	public static <A> Maybe<Node<A>> findNodeFrom(Node<A> start, Predicate<A> p) {
		// Use an array dequeue in order to act like a stack (java documentation states that this should be used in preference to a stack)
		// This will be the frontier that holds all nodes that are waiting to be expanded
		ArrayDeque<Node<A>> frontier = new ArrayDeque<Node<A>>();
		// Create a set to store visited nodes
		Set<Node<A>> vstd = new HashSet<Node<A>>();
		// Create a node to represent the node currently being expanded
		Node<A> node;
		// Push the starting node to the frontier
		frontier.push(start);
		// While there are still nodes to be expanded
		while (!frontier.isEmpty()) {
			// Remove the node on the top of the frontier stack and store it as the node to be expanded
			node = frontier.pop();
			// Check that the node hasn't already been expanded
			if (!vstd.contains(node))
				// If the node is the node being searched for
				if (p.holds(node.getContents()))
					// Return "just" the node
					return new Just<Node<A>>(node);
				else {
					vstd.add(node);
					// If the node wasn't the one being searched for add it to the visited set and push all of it's successors to the stack
					for (Node<A> suc : node.getSuccessors())
						frontier.push(suc);
				}
		}
		// If none of the connected nodes satisfy the predicate return "nothing"
		return new Nothing<Node<A>>();
	}
}