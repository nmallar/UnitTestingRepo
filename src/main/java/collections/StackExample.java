package collections;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println("Peek output " + stack.peek());
        System.out.println("Element At " + stack.elementAt(3));
        System.out.println("First Element in Stack " + stack.firstElement());
        System.out.println("Last Element in Stack " + stack.lastElement());

        Iterator<String> iterator = stack.iterator();
        System.out.println("Initial Stack elements ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        stack.pop();
        System.out.println("After removing first element");

        iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Search for existence of A in stack :" + stack.search("A"));
        System.out.println("Search for existence of B in stack :" + stack.search("B"));
        System.out.println("Search for existence of X in stack :" + stack.search("X"));
        System.out.println("Get operation on stack get(0):" + stack.get(0));
    }
}
