package search;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;
import SearchDataStructures.SearchDataStructure;

public class Search {
	// DFS
	public static <A> Maybe<Node<A>> findNodeFromDepthFirst(Node<A> start, Predicate<Node<A>> p){
		// Use an array dequeue in order to act like a stack (java documentation states that this should be used in preference to a stack)
		// This will be the frontier that holds all nodes that are waiting to be expanded
		ArrayDeque<Node<A>>frontier = new ArrayDeque<Node<A>>();
		// Create a set to store visited nodes
		Set<Node<A>> vstd = new HashSet<Node<A>>();
		// Create a node to represent the node currently being expanded
		Node<A> node;
		// Push the starting node to the frontier
		frontier.push(start);
		// While there are still nodes to be expanded
		while(!frontier.isEmpty()){
			// Remove the node on the top of the frontier stack and store it as the node to be expanded
			node = frontier.pop();
			// Check that the node hasn't already been expanded
			if(!vstd.contains(node)){
				// If the node is the node being searched for
				if(p.holds(node)){
					// Return "just" the node
					return new Just<Node<A>>(node);
				}
				else{
					vstd.add(node);
					// If the node wasn't the one being searched for add it to the visited set and push all of it's successors to the stack
					for(Node<A> suc : node.successors()){
						frontier.push(suc);
					}
				}
			}
		}
		// If none of the connected nodes satisfy the predicate return "nothing"
		return new Nothing<Node<A>>();
	}
	
	// BFS
	public static <A> Maybe<Node<A>> findNodeFromBreadthFirst(Node<A> start, Predicate<Node<A>> p){
		// Uses a double ended queue to act as a queue that stores all of the nodes that need to be expanded
		Queue<Node<A>> frontier = new ArrayDeque<Node<A>>();
		// Create a set to store visited nodes
		Set<Node<A>> vstd = new HashSet<Node<A>>();
		// Create a node to represent the node currently being expanded
		Node<A> node;
		// Add the starting node to the frontier
		frontier.add(start);
		// While there are still nodes that need to be expanded
		while(!frontier.isEmpty()){
			// Retrieve and remove the head of the queue for expansion
			node = frontier.poll();
			if(!vstd.contains(node)){
				// If the node satisfies the predicate
				if(p.holds(node))
				{
					// Return "just" the node
					return new Just<Node<A>>(node);
				}
				else{
					vstd.add(node);
					// If the node isn't the one being searched for add all of its connected nodes to the frontier queue and visited set if they have not already been visited
					for(Node<A> suc : node.successors()){
						frontier.add(suc);
					}
				}
			}
		}
		// If no node could be found that satisfies the predicate return "nothing"
		return new Nothing<Node<A>>();
	}
	
	// Any structure
	// Does not yet work for priority queues as Node must implement comparable in order to be sorted in the priority queue
	public static <A,B extends SearchDataStructure<Node<A>>> Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<Node<A>> p, B dataStructure){
		// Works the same as the other two methods but uses a datastructure that has been passed in
		SearchDataStructure<Node<A>> frontier = dataStructure;
		Set<Node<A>> vstd = new HashSet<Node<A>>();
		Node<A> node;
		// Adds the node to the frontier in the manner specified by the data structure
		frontier.add(x);
		// Checks if the data structure is not empty
		while(!frontier.isEmpty()){
			// Get and remove the first element in the manner specified by the data structure
			node=frontier.getHead();
			if(p.holds(node))
				return new Just<Node<A>>(node);
			else{
				for(Node<A> suc : node.successors()){
					if(!vstd.contains(suc)){
						frontier.add(suc);
						vstd.add(suc);
					}
				}
			}	
		}
		return new Nothing<Node<A>>();
	}
}
