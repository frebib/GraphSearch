package search.datastructures;

import java.util.ArrayDeque;

public class SearchQueue<A> extends ArrayDeque<A> implements DataStructure<A> {

	private static final long serialVersionUID = -3176829228207481830L;

	@Override
	public A getHead() {
		// TODO Auto-generated method stub
		return poll();
	}
}
