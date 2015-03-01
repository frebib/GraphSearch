package ilist;

/**
 * Interface for immutable lists using the "composite pattern".
 * 
 * @author Martin Escardo
 * @param <E> Element to store a list of
 */

public interface IList<E> {
	/**
	 * Gets whether the {@link ilist.IList} is empty
	 * 
	 * @return {@code true} if the {@link ilist.IList} is empty
	 */
	public boolean isEmpty();
	/**
	 * Gets the size of the {@link ilist.IList}
	 * 
	 * @return Size of the {@link ilist.IList}
	 */
	public int size();

	/**
	 * Reverses this {@link ilist.IList}
	 * 
	 * @return This {@link ilist.IList}, reversed
	 */
	public IList<E> reverse();
	/**
	 * Appends a {@link ilist.IList} to the end
	 * 
	 * @param l {@link ilist.IList} to append
	 * @return This {@link ilist.IList} with {@code l} appended to the end
	 */
	public IList<E> append(IList<E> l);
	/**
	 * Appends an element to the end
	 * 
	 * @param e Element to append
	 * @return This {@link ilist.IList} with {@code e} appended to the end
	 */
	public IList<E> append(E e);

	/**
	 * Returns if an item is within the {@link ilist.IList}
	 * 
	 * @param e Item to compare
	 * @return true if in the {@link ilist.IList}
	 */
	public boolean has(E e);
	/**
	 * Gets the element at index {@code i}
	 * 
	 * @param i Index to retrieve item from
	 * @return Item at index {@code i}
	 */
	public E get(int i);
}