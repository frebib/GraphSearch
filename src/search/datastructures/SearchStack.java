package search.datastructures;

import java.util.ArrayDeque;

public class SearchStack<A> extends ArrayDeque<A> implements DataStructure<A> {

	private static final long serialVersionUID = -1396748782494268710L;

	@Override
	public A getHead() {
		// TODO Auto-generated method stub
		return pop();
	}

	@Override
	public boolean add(A a) {
		// TODO Auto-generated method stub
		push(a);
		return true;
	}

}
