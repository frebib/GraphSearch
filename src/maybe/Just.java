// WHAT (NOT) TO DO:
// -------------------
// REPLACE the "Exercise" lines with code (possibly empty code).
// LEAVE ALONE the "Exercise" lines for parts you are not solving.
//
// To get any marks for the whole exercise, your submission should
// compile using the "compile" script. Submissions that don't compile
// won't get any marks.

package maybe;

/**
 * Implementation of Just (using the "composite pattern").
 * 
 * @author Martin Escardo
 * @param <A> @inheritDoc
 */

public class Just<A> implements Maybe<A> {

	private final A something;

	public Just(A something) {
		// throw new Exercise("Just:Just");
		this.something = something;
	}

	@Override
	public boolean isNothing() {
		// throw new Exercise("Just:isNothing");
		return false;
	}

	@Override
	public int size() {
		// throw new Exercise("Just:size");
		return 1;
	}

	@Override
	public String toString() {
		// throw new Exercise("Just:toString");
		return "Just(" + something.toString() + ")";
	}

	@Override
	public boolean has(A a) {
		// throw new Exercise("Just:has");
		return something.equals(a);
	}

	// Higher-order functions:

	@Override
	public Maybe<A> filter(Predicate<A> p) {
		// throw new Exercise("Just:filter");
		if (p.holds(something))
			return this;
		else
			return new Nothing<A>();
	}

	@Override
	public <B> Maybe<B> map(Function<A, B> f) {
		// throw new Exercise("Just:map");
		return new Just<B>(f.apply(something));
	}

	@Override
	public <B> B fold(Function<A, B> f, B b) {
		// throw new Exercise("Just:fold");
		return f.apply(something);
	}

	@Override
	public boolean all(Predicate<A> p) {
		// throw new Exercise("Just:all");
		return p.holds(something);
	}

	@Override
	public boolean some(Predicate<A> p) {
		// throw new Exercise("Just:some");
		return p.holds(something);
	}

	@Override
	public void forEach(Action<A> f) {
		// throw new Exercise("Just:forEach");
		f.apply(something);
	}

	// Unsafe operation:
	@Override
	public A fromMaybe() {
		// throw new Exercise("Just:fromMaybe");
		return something;
	}
}
