package SearchDataStructures;

public interface SearchDataStructure<A>{
	public A getHead();
	public boolean add(A a);
	public boolean isEmpty();
	public boolean contains(A a);
}
