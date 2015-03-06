package ilist;

/**
 * Implementation of the empty list (using the "composite pattern").
 *
 * @author Martin Escardo
 * @param <E> @inheritDoc
 */

public class Nil<E> implements IList<E> {

	public Nil() { // Nothing to do in the constructor!
	} // Could simply remove it.

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public String toString() {
		return "Nil";
	}

	@Override
	public IList<E> append(IList<E> l) {
		return l;
	}

	@Override
	public IList<E> append(E e) {
		return new Cons<E>(e, this);
	}

	@Override
	public IList<E> reverse() {
		return this;
	}

	@Override
	public boolean has(E e) {
		return false;
	}

	@Override
	public E get(int i) {
		throw new IndexOutOfBoundsException();
	}
}
