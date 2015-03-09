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
		return get(0);
	}

	@Override
	public boolean add(A a) {
		System.out.println("Added: " + a);
		super.add(a);
		System.out.println("Sort started");
		Collections.sort(this, comparer);
		System.out.println("Sort finished");
		return true;
	}
}
