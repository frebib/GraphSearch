package maybe;

/**
 * Implementation of Just (using the "composite pattern").
 *
 * @author Martin Escardo
 * @param <E> @inheritDoc
 */

public class Just<E> implements Maybe<E> {
	private final E element;

	/**
	 * Creates {@link Just} an Element
	 * 
	 * @param something An Element to {@link Just} create
	 */
	public Just(E something) {
		// throw new Exercise("Just:Just");
		this.element = something;
	}

	@Override
	public boolean isNothing() {
		return false;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public String toString() {
		return "Just(" + element.toString() + ")";
	}

	@Override
	public boolean has(E a) {
		return element.equals(a);
	}

	// Higher-order functions:

	@Override
	public Maybe<E> filter(Predicate<E> p) {
		if (p.holds(element))
			return this;
		else
			return new Nothing<E>();
	}

	@Override
	public <B> Maybe<B> map(Function<E, B> f) {
		return new Just<B>(f.apply(element));
	}

	@Override
	public <B> B fold(Function<E, B> f, B b) {
		return f.apply(element);
	}

	@Override
	public boolean all(Predicate<E> p) {
		return p.holds(element);
	}

	@Override
	public boolean some(Predicate<E> p) {
		return p.holds(element);
	}

	@Override
	public void forEach(Action<E> f) {
		f.apply(element);
	}

	@Override
	public E fromMaybe() {
		return element;
	}
}
