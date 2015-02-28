package search.datastructures;

import java.util.PriorityQueue;

public class SearchPriorityQueue<A> extends PriorityQueue<A> implements DataStructure<A> {

	private static final long serialVersionUID = 2623101708315097645L;

	@Override
	public A getHead() {
		return poll();
	}
}
