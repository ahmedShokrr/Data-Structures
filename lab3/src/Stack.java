public class Stack {
    int capacity;
    int[] stack;
    int top;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        int top = 0;
    }

    public int size() {
        return top;
    }

    public void push(int data) {
        if (size() == capacity) {
            expand();
        }
        stack[top] = data;
        top++;

    }

    public void expand() {
        int length = size();
        capacity++;
        int newStack[] = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        else
        {
            top--;
            stack[top] = 0;
            shrink();
        }
    }

    public void shrink(){
        int length = size();
        capacity--;
        int newStack[]= new int[capacity];
        System.arraycopy(stack,0,newStack,0,length);
        stack = newStack;
    }
    public void display(){
        for(int i: stack){
            System.out.print(" "+i);
        }
    }
    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        }else {
            System.out.println("the stack is empty");

        }
            return -1;

    }
}
