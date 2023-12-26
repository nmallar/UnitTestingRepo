package collections;

import java.util.Vector;

//just like ArrayList but is ThreadSafe(synchronized)
public class VectorExample {

    public static void main(String[] args) {
        Vector<Integer> al = new Vector<>();

        for (int i = 0; i < 10; i++) {
            al.add(i);


        }

        System.out.println(al);
        al.remove(5);
        System.out.println("After removing 5 " + al);

        Vector<Integer> anotherList = new Vector<>();
        anotherList.add(99);
        anotherList.add(88);
        System.out.println("Another Vector " + anotherList);
        al.addAll(anotherList);
        System.out.println("After adding another Vector: " + al);
    }
}
