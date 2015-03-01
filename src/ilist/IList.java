package ilist;

/**
 * Interface for immutable lists using the "composite pattern".
 */

public interface IList<E> {
	/**
	 * Gets whether the {@link List} is empty
	 * 
	 * @return {@code true} if the {@link List} is empty
	 */
	public boolean isEmpty();
	/**
	 * Gets the size of the {@link List}
	 * 
	 * @return Size of the {@link List}
	 */
	public int size();

	/**
	 * Reverses this {@link List}
	 * 
	 * @return This {@link List}, reversed
	 */
	public IList<E> reverse();
	/**
	 * Appends a {@link List} to the end
	 * 
	 * @param l {@link List} to append
	 * @return This {@link List} with {@code l} appended to the end
	 */
	public IList<E> append(IList<E> l);
	/**
	 * Appends an element to the end
	 * 
	 * @param e Element to append
	 * @return This {@link List} with {@code e} appended to the end
	 */
	public IList<E> append(E e);

	public boolean has(E e);
	public E get(int i);
}