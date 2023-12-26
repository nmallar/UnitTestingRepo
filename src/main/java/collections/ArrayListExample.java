package collections;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            al.add(i);


        }

        System.out.println(al);
        al.remove(5);
        System.out.println("After removing 5 " + al);

        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(99);
        anotherList.add(88);
        System.out.println("Another list " + anotherList);
        al.addAll(anotherList);
        System.out.println("After adding another list: " + al);
    }
}
