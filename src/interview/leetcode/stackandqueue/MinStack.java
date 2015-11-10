package interview.leetcode.stackandqueue;

import java.util.Stack;


public class MinStack {

	/**
	 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		getMin() -- Retrieve the minimum element in the stack.
	 */
	
    class Ele{
        int x;
        int min;
        
        public Ele(int x, int min){
            this.x=x;
            this.min=min;
        }
    }

	Stack<Ele> stk = new Stack<Ele>();

	public void push(int x) {

		if (stk.isEmpty()) {
			stk.push(new Ele(x, x));
		} else {
			stk.push(new Ele(x, Math.min(stk.peek().min, x)));
		}
	}

	public void pop() {

		stk.pop();
	}

	public int top() {

		return stk.peek().x;
	}

	public int getMin() {

		return stk.peek().min;
	}
}
