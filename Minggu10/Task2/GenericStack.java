package Task2;

import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> items; 

    public GenericStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new GenericStackException("Underflow Error"); 
        }
        return items.remove(items.size() - 1); 
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static class GenericStackException extends RuntimeException {
        public GenericStackException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Tes Stack Integer ---");
        GenericStack<Integer> stack = new GenericStack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        
        stack.push(10);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop()); 

        System.out.println("Apakah kosong? " + stack.isEmpty());
        
        System.out.println("\n--- Tes Stack String ---");
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Halo");
        stringStack.push("Java");
        stringStack.push("Collections");
        
        System.out.println("Pop: " + stringStack.pop());
        System.out.println("Pop: " + stringStack.pop());
    }
}
