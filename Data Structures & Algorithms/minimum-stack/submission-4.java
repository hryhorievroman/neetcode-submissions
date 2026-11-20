class MinStack {
    LinkedList<Integer> elements;
    Stack<Integer> minElements;

    public MinStack() {
        elements = new LinkedList<>();
        minElements = new Stack<>();
    }

    public void push(int val) {
        int currMin = !minElements.empty() ? Math.min(val, minElements.peek()) : val;
        minElements.push(currMin);
        elements.add(val);
    }

    public void pop() {
        elements.removeLast();
        minElements.pop();
    }

    public int top() {
        return elements.getLast();
    }

    public int getMin() {
        return minElements.peek();
    }
}