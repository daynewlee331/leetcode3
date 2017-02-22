package leetcode3;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator = null;
	Integer buffer = null;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if(this.iterator.hasNext()) this.buffer = this.iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.buffer;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.buffer != null;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		Integer res = this.buffer;
		if(this.iterator.hasNext()) this.buffer = this.iterator.next();
		else this.buffer = null;
		return res;
	}

}
