package SearchDataStructures;

import java.util.ArrayDeque;

public class SearchStack<A> extends ArrayDeque<A> implements SearchDataStructure<A> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1396748782494268710L;

	@Override
	public A getHead() {
		// TODO Auto-generated method stub
		return this.pop();
	}

	@Override
	public boolean add(A a) {
		// TODO Auto-generated method stub
		this.push(a);
		return true;
	}

}
