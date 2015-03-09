package search;

import lejos.geom.Point;

/**
 * Provides a more specific interface that applies a function on two {@link Node}{@code s} and returns a floating point number, {@link Search}{@code ing}
 *
 * @author frebib
 * @param <A> Element represented by the {@link Node}
 */
public interface SearchFunction<A> {
	/**
	 * A {@link SearchFunction} that calculates a Euclidean distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Point> euclidean = new SearchFunction<Point>() {
		@Override
		public float apply(Node<Point> a, Node<Point> b) {
			return (float) Math.sqrt(Math.pow(a.contents.x - b.contents.x, 2) + Math.pow(a.contents.y - b.contents.y, 2));
		}
	};
	/**
	 * A {@link SearchFunction} that calculates a Manhattan distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Point> manhattan = new SearchFunction<Point>() {
		@Override
		public float apply(Node<Point> a, Node<Point> b) {
			return Math.abs(a.contents.x - b.contents.x) + Math.abs(a.contents.y - b.contents.y);
		}
	};
	/**
	 * An empty function that returns 0
	 */
	public static final SearchFunction<Point> nothing = new SearchFunction<Point>() {
		@Override
		public float apply(Node<Point> a, Node<Point> b) {
			return 0f;
		}
	};

	public float apply(Node<A> a, Node<A> b);
}
