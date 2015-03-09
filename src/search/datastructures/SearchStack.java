package search.datastructures;

import java.util.Stack;

/**
 * Stores a {@code Collection} of items in a Stack {@link search.datastructures.DataStructure} The implementation actually uses a {@link java.util.ArrayDeque} in place of a {@link java.util.Stack}
 *
 * @author Jack Hair
 * @param <A> @inheritDoc
 */
public class SearchStack<A> extends Stack<A> implements DataStructure<A> {
	@Override
	public A getHead() {
		return pop();
	}

	@Override
	public boolean add(A a) {
		push(a);
		return true;
	}

	@Override
	public boolean contains(A a) {
		for (Object element : elementData)
			if (a.equals(element))
				return true;
		return false;
	}
}