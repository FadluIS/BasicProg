public class IntegerStack implements Cloneable {
    private Integer[] _stack;
    private int _topIndex;

    /**
     * For testing purposes
     */
    public static void main(String[] args) throws Exception {
        IntegerStack stack = new IntegerStack(4);
        stack.push(3);
        stack.push(2);
        stack.push(364);
        stack.push(2);
//        stack.push(364);

        System.out.println(stack);

        System.out.println("Removed " + stack.pop() + " from stack.");
        System.out.println(stack);

        System.out.println("\nCloning:");
        IntegerStack copy = (IntegerStack) stack.clone();

        // ? Tried to use hashcode to get some object reference to proof deep copy, but documentation states that two
        // separate object can have same hashcode.
        System.out.println("Original: " + stack + "\n " + stack.hashCode());
        System.out.println("\nCopy: " + copy + "\n " + copy.hashCode());
    }

    /**
     * Initialize an stack of type {@code Integer} with given size.
     *
     * @param size of stack
     */
    public IntegerStack(int size) {
        this._stack = new Integer[size];
        this._topIndex = -1;
    }

    /**
     * Get the max number of elements that can be placed.
     *
     */
    public int getLength() {
        return this._stack.length;
    }

    /**
     * Get number of current elements in stack.
     *
     * @return
     */
    public int getSize() {
        return this._topIndex + 1;
    }

    /**
     * Push an {@code int} to the top of the stack.
     *
     * @param value int to be pushed
     * @throws Exception
     */
    public void push(int value) throws Exception {
        // Ensure stack is not full
        if (this.isFull()) {
            throw new Exception("Cannot push " + value + ". Stack is full.");
        }

        // Increment index and push to top of stack
        this._stack[++this._topIndex] = value;
    }

    /**
     * Remove an {@code int} from the top of the stack.
     *
     * @return the removed element
     * @throws Exception
     */
    public int pop() throws Exception {
        // Ensure stack is not empty
        if (this.isEmpty()) {
            throw new Exception("Cannot pop from empty stack.");
        }

        // Return top of stack and decrement index
        return this._stack[this._topIndex--];
    }

    public boolean isFull() {
        return (this._topIndex == this._stack.length - 1);
    }

    public boolean isEmpty() {
        return (this._topIndex == -1);
    }

    @Override
    public Object clone() {
        IntegerStack copy = new IntegerStack(this.getLength());

        // Iterate through stack from bottom to top making clones of all items
        for (int i = 0; i <= this._topIndex; i++) {
            try {
                copy.push(this._stack[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        return copy;
    }

    @Override
    public String toString() {
        String result = "[ ";

        if (!this.isEmpty()) result += this._stack[0];
        for (int i = 1; i <= this._topIndex; i++) {
            result += ", " + this._stack[i];
        }

        return result + " ]";
    }
}
