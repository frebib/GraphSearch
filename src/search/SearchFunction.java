package search;

import maybe.Function2;
import search.graph.Node;

/**
 * Provides a more specific interface that applies a function on two {@link Node}{@code s} and returns a floating point number, {@link Search}{@code ing}
 *
 * @author frebib
 * @param <A> Element represented by the {@link Node}
 */
public interface SearchFunction<A> extends Function2<Node<A>, Node<A>, Float> {
	/**
	 * A {@link SearchFunction} that calculates a Euclidean distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Coordinate> euclidean = (a, b) -> (float) Math.abs(a.contents.x - b.contents.x) + Math.abs(a.contents.y - b.contents.y);
	/**
	 * A {@link SearchFunction} that calculates a Manhattan distance between two {@link Node}{@code s}
	 */
	public static final SearchFunction<Coordinate> manhattan = (a, b) -> (float) Math.sqrt(Math.pow(a.contents.x - b.contents.x, 2) + Math.pow(a.contents.y - b.contents.y, 2));

	@Override
	public Float apply(Node<A> a, Node<A> b);
}
