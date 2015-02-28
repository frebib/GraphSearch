package SearchDataStructures;

import java.util.PriorityQueue;

public class SearchPriorityQueue<A> extends PriorityQueue<A> implements
		SearchDataStructure<A> {
	
	private static final long serialVersionUID = 2623101708315097645L;

	public A getHead() {
		return this.poll();
	}
}
