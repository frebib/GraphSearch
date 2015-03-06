package search.datastructures;

import java.util.ArrayDeque;

/**
 * Stores a {@code Collection} of items in a Stack {@link search.datastructures.DataStructure} The implementation actually uses a {@link java.util.ArrayDeque} in place of a {@link java.util.Stack}
 *
 * @author Jack Hair
 * @param <A> @inheritDoc
 */
public class SearchStack<A> extends ArrayDeque<A> implements DataStructure<A> {

	private static final long serialVersionUID = -1396748782494268710L;

	@Override
	public A getHead() {
		return pop();
	}

	@Override
	public boolean add(A a) {
		push(a);
		return true;
	}

}
