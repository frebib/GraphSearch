package search;

import maybe.Function2;
import search.graph.Node;

public interface SearchFunction<A> extends Function2<Node<A>, Node<A>, Float> {
	public static final SearchFunction<Coordinate> euclidean = (a, b) -> (float) Math.abs(a.contents.x - b.contents.x) + Math.abs(a.contents.y - b.contents.y);
	public static final SearchFunction<Coordinate> manhattan = (a, b) -> (float) Math.sqrt(Math.pow(a.contents.x - b.contents.x, 2) + Math.pow(a.contents.y - b.contents.y, 2));

	public Float apply(Node<A> a, Node<A> b);
}
