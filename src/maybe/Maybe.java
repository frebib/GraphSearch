package maybe;

/**
 * Interface for the Maybe type using the "composite pattern". We include high-order methods. We will use E,B,C for type variables.#
 *
 * @author Martin Escardo
 * @param <E> Type of object to be a Maybe
 */

public interface Maybe<E> {
	/**
	 * Gets whether the {@link Maybe} has an Element
	 *
	 * @return {@code true} if has an Element
	 */
	public boolean isNothing();

	/**
	 * Gets the size of the {@link Maybe}
	 *
	 * @return Size of {@link Maybe}
	 */
	public int size();
	/**
	 * Gets whether the {@link Maybe} has Element {@code e}
	 *
	 * @param e Element to check if {@link Maybe} has
	 * @return {@code true} if {@link Maybe} has Element {@code e}
	 */
	public boolean has(E e);

	/**
	 * Filters out the Element if it satisfies the {@link Predicate} {@code p}
	 *
	 * @param p {@link Predicate} to satisfy
	 * @return {@link Maybe} an Element
	 */
	public Maybe<E> filter(Predicate<E> p);
	/**
	 * Maps a {@link Function} {@code f} to Element {@code e}
	 *
	 * @param f {@link Function} to map
	 * @return {@link Maybe} an Element
	 */
	public <B> Maybe<B> map(Function<E, B> f);
	/**
	 * Fold a {@link Function} {@code f} over Element {@code e}
	 *
	 * @param f {@link Function} to fold
	 * @param b Initial value to fold with
	 * @return {@link Maybe} an Element
	 */
	public <B> B fold(Function<E, B> f, B b);
	/**
	 * Gets whether all of the 1 Element satisfy the {@link Predicate} {@code p}
	 *
	 * @param p {@link Predicate} to satisfy
	 * @return {@link Maybe} an Element
	 */
	public boolean all(Predicate<E> p);
	/**
	 * Gets whether some of the 1 Element satisfy the {@link Predicate} {@code p}
	 *
	 * @param p {@link Predicate} to satisfy
	 * @return {@link Maybe} an Element
	 */
	public boolean some(Predicate<E> p);
	/**
	 * Apply an {@link Action} a to the Element
	 *
	 * @param a {@link Action} to apply
	 */
	public void forEach(Action<E> a);

	/**
	 * An unsafe operation to get the content from the {@link Maybe} Element
	 *
	 * @return The Element in the {@link Maybe} or an Exception if {@link Nothing}
	 */
	public E fromMaybe();
}