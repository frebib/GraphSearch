package search.datastructures;

public interface DataStructure<A> {
	public A getHead();

	public boolean add(A a);

	public boolean isEmpty();

	public boolean contains(A a);
}
