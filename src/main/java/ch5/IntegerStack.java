package ch5;

public class IntegerStack implements Cloneable {
    private Integer[] stack;
    private int topIndex;

    public static void main(String[] args) throws Exception {
    }

    /**
     * Initialize an stack of type {@code Integer} with given size.
     *
     * @param size of stack
     */
    public IntegerStack(int size) {
        this.stack = new Integer[size];
        this.topIndex = -1;
    }

    /**
     * Get the max number of elements that can be placed.
     *
     */
    public int getLength() {
        return this.stack.length;
    }

    /**
     * Get number of current elements in stack.
     *
     * @return
     */
    public int getSize() {
        return this.topIndex + 1;
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
        this.stack[++this.topIndex] = value;
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
        return this.stack[this.topIndex--];
    }

    public boolean isFull() {
        return (this.topIndex == this.stack.length - 1);
    }

    public boolean isEmpty() {
        return (this.topIndex == -1);
    }

    @Override
    public Object clone() {
        IntegerStack copy = new IntegerStack(this.getLength());

        // Iterate through stack from bottom to top making clones of all items
        for (int i = 0; i <= this.topIndex; i++) {
            try {
                copy.push(this.stack[i]);
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

        if (!this.isEmpty()) result += this.stack[0];
        for (int i = 1; i <= this.topIndex; i++) {
            result += ", " + this.stack[i];
        }

        return result + " ]";
    }
}
