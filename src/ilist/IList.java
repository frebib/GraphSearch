package ilist;

/**
 * Interface for immutable lists using the "composite pattern".
 */

public interface IList<E> {
	public boolean isEmpty();
	public int size();

	public IList<E> reverse();
	public IList<E> append(IList<E> l);
	public IList<E> append(E e);

	public boolean has(E e);
	public E get(int i);
}