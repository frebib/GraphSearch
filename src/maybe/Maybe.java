package maybe;

/**
 * Interface for the Maybe type using the "composite pattern". We include high-order methods. We will use A,B,C for type variables.
 */

public interface Maybe<A> {
	public boolean isNothing();

	public int size();
	public boolean has(A a);

	// Higher-order methods:
	public Maybe<A> filter(Predicate<A> p);
	public <B> Maybe<B> map(Function<A, B> f);
	public <B> B fold(Function<A, B> f, B b);
	public boolean all(Predicate<A> p);
	public boolean some(Predicate<A> p);
	public void forEach(Action<A> a);

	public A fromMaybe();
}