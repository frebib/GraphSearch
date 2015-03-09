package search.datastructures;

import java.util.Queue;

/**
 * Stores a {@code Collection} of items in a Queue {@link search.datastructures.DataStructure}
 *
 * @author Jack Hair
 * @param <A> @inheritDoc
 */
public class SearchQueue<A> extends Queue<A> implements DataStructure<A> {
	@SuppressWarnings("unchecked")
	@Override
	public A getHead() {
		return (A) pop();
	}

	@Override
	public boolean add(A a) {
		addElement(a);
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
