package collections;

public class Main {

    public static void main(String[] args) {
        Node tail = new Node(1, null);
        Node n1 = new Node(2, tail);
        Node n2 = new Node(3, n1);
        Node n3 = new Node(4, n2);
        Node n4 = new Node(5, n3);
        Node n5 = new Node(6, n4);


//        while (n5!=null){
//            System.out.println(n5.data);
//            n5=n5.next;
//        }

        for (int val : n5) {
            System.out.println(val);
        }
    }
}



