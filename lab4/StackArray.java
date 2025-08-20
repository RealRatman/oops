import java.util.Arrays;

public class StackArray<T> implements MyStack<T> {
    private Object[] arr;
    private int top;
    private int cap;
    private final int maxcap = 100;

    public StackArray(int initcap) {
        if (initcap <= 0 || initcap > maxcap) {
            throw new IllegalArgumentException("bad init cap");
        }
        this.cap = initcap;
        this.arr = new Object[cap];
        this.top = -1;
    }

    @Override
    public void push(T item) throws StackOverflowException {
        if (isfull()) {
            if (cap == maxcap) {
                throw new StackOverflowException("cant push, max cap hit");
            }
            resize();
        }
        arr[++top] = item;
        System.out.println(item + " pushed");
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() throws StackUnderflowException {
        if (isempty()) {
            throw new StackUnderflowException("cant pop, stack empty");
        }
        T item = (T) arr[top--];
        return item;
    }

    @Override
    public void display() {
        if (isempty()) {
            System.out.println("stack empty");
            return;
        }
        System.out.print("stack (top down): [ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i != 0) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    @Override
    public boolean isempty() {
        return top == -1;
    }

    @Override
    public boolean isfull() {
        return top == cap - 1;
    }

    private void resize() {
        int newcap = Math.min(cap * 2, maxcap);
        arr = Arrays.copyOf(arr, newcap);
        cap = newcap;
        System.out.println("resized to " + cap);
    }

    @Override
    public String toString() {
        if (isempty()) return "[]";
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = top; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
