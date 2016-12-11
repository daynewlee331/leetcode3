package leetcode3;

import java.util.List;
import java.util.Stack;

class NestedIterator {
	interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	Stack<NestedInteger> stack = null;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.stack = new Stack<NestedInteger>();
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			this.stack.add(nestedList.get(i));
		}
	}

	public Integer next() {
		return this.stack.pop().getInteger();
	}

	public boolean hasNext() {
		while (!this.stack.isEmpty()) {
			NestedInteger cur = this.stack.peek();
			if (cur.isInteger()) return true;
			cur = this.stack.pop();
			List<NestedInteger> list = cur.getList();
			for (int i = list.size() - 1; i >= 0; i--) this.stack.add(list.get(i));
		}
		return false;
	}
}
