package maybe;

/**
 * Implementation of Nothing (using the "composite pattern").#
 *
 * @author Martin Escardo
 * @param <E> @inheritDoc
 */

public class Nothing<E> implements Maybe<E> {

	/**
	 * Create an empty Maybe
	 */
	public Nothing() {
	}

	@Override
	public boolean isNothing() {
		return true;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public String toString() {
		return "Nothing";
	}

	@Override
	public boolean has(E a) {
		return false;
	}

	// Higher-order functions:

	@Override
	public Maybe<E> filter(Predicate<E> p) {
		return this;
	}

	@Override
	public <B> Maybe<B> map(Function<E, B> f) {
		return new Nothing<B>();
	}

	@Override
	public <B> B fold(Function<E, B> f, B b) {
		return b;
	}

	@Override
	public boolean all(Predicate<E> p) {
		return true;
	}

	@Override
	public boolean some(Predicate<E> p) {
		return false;
	}

	@Override
	public void forEach(Action<E> f) {
		// Nothing to do, but must have this method as
		// Nothing implements the abstract class Maybe
	}

	// Unsafe operations:
	@Override
	public E fromMaybe() {
		throw new RuntimeException("Nothing");
	}
}
