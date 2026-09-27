class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize the stack. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /** Push the element onto the stack. */
    public void push(int val) {
        stack.push(val);  // Push the value to the main stack
        // Push the minimum value onto the min stack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /** Remove the element on the top of the stack. */
    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();  // Pop from the main stack
            if (val == minStack.peek()) {
                minStack.pop();  // Pop from the min stack if it matches the top value
            }
        }
    }

    /** Get the top element of the stack. */
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();  // Return the top element of the main stack
        }
        return -1;  // Return a default value if the stack is empty
    }

    /** Retrieve the minimum element from the stack. */
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();  // Return the top element of the min stack
        }
        return -1;  // Return a default value if the min stack is empty
    }
}
