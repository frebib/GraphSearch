package maybe;

/**
 * Interface to allow function delegation in the form of an {@linkplain Action} on an Element *
 *
 * @author Martin Escardo
 * @param <E> An Element of any type to apply an action to
 */
public interface Action<E> {
	/**
	 * Applies an action to an Element
	 *
	 * @param e Element to apply the Action to
	 */
	void apply(E e);
}
