package search.datastructures;

import java.util.ArrayDeque;

/**
 * Stores a {@code Collection} of items in a Queue {@link search.datastructures.DataStructure}
 *
 * @author Jack Hair
 * @param <A> @inheritDoc
 */
public class SearchQueue<A> extends ArrayDeque<A> implements DataStructure<A> {

	private static final long serialVersionUID = -3176829228207481830L;

	@Override
	public A getHead() {
		// TODO Auto-generated method stub
		return poll();
	}
}
