package search.datastructures;

import rp.util.Collections;
import rp.util.Comparator;

import java.util.ArrayList;

/**
 * Stores a {@code Collection} of items in a PriorityQueue {@link search.datastructures.DataStructure}
 *
 * @author Jack Hair
 * @param <A> @inheritDoc
 */
public class SearchPriorityQueue<A> extends ArrayList<A> implements DataStructure<A> {
	private Comparator<A> comparer;

	public SearchPriorityQueue(Comparator<A> comparer) {
		this.comparer = comparer;
	}

	@Override
	public A getHead() {
		if (isEmpty())
			return null;
		A head = get(0);
		remove(0);
		return head;
	}

	@Override
	public boolean add(A a) {
		super.add(a);
		Collections.sort(this, comparer);
		return true;
	}
}
