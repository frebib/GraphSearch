package search;

/**
 * Provides a more specific interface that applies a function on two {@link Node}{@code s} and returns a floating Coordinate number, {@link Search}{@code ing}
 *
 * @author frebib
 * @param <A> Element represented by the {@link Node}
 */
public interface SearchFunction<A> {
	/**
	 * A {@link SearchFunction} that calculates a Euclidean distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Coordinate> euclidean = new SearchFunction<Coordinate>() {
		@Override
		public float apply(Node<Coordinate> a, Node<Coordinate> b) {
			return (float) Math.sqrt(Math.pow(a.payload.x - b.payload.x, 2) + Math.pow(a.payload.y - b.payload.y, 2));
		}
	};
	/**
	 * A {@link SearchFunction} that calculates a Manhattan distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Coordinate> manhattan = new SearchFunction<Coordinate>() {
		@Override
		public float apply(Node<Coordinate> a, Node<Coordinate> b) {
			return Math.abs(a.payload.x - b.payload.x) + Math.abs(a.payload.y - b.payload.y);
		}
	};
	/**
	 * An empty function that returns 0
	 */
	public static final SearchFunction<Object> nothing = new SearchFunction<Object>() {
		@Override
		public float apply(Node<Object> a, Node<Object> b) {
			return 0f;
		}
	};

	public float apply(Node<A> a, Node<A> b);
}
