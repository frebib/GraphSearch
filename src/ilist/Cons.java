package ilist;

/**
 * Implementation of a list that has a head and a tail (using the "composite pattern").
 *
 * @author Martin Escardo
 * @param <E> @inheritDoc
 */
public class Cons<E> implements IList<E> {
	private final E head;
	private final IList<E> tail; 	// Reference to another list

	/**
	 * Create a list from a head and a tail
	 *
	 * @param head The head of the list, of type element
	 * @param tail The tail of the list, of type {@link IList}
	 */
	public Cons(E head, IList<E> tail) {
		assert (tail != null);		// Tail should NOT be null. Use Nil instead.

		this.head = head;
		this.tail = tail;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 1 + tail.size();
	}

	@Override
	public String toString() {
		return "Cons(" + head + ", " + tail.toString() + ")";
	}

	@Override
	public IList<E> append(IList<E> l) {
		return new Cons<E>(head, tail.append(l));
	}

	@Override
	public IList<E> append(E e) {
		return append(new Cons<E>(e, new Nil<E>()));
	}

	@Override
	public IList<E> reverse() {
		return tail.reverse().append(head);
	}

	@Override
	public boolean has(E e) {
		return (head.equals(e) || tail.has(e));
	}

	@Override
	public E get(int i) {
		return (i == 0 ? head : tail.get(i - 1));
	}
}
