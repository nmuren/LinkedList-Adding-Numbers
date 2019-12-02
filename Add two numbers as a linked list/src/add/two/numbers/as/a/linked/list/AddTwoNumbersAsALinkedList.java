package add.two.numbers.as.a.linked.list;

import java.util.LinkedList;

class Node {

    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    Node getNext() {
        return next;
    }
}

public class AddTwoNumbersAsALinkedList {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(new Node(2));
        l1.add(new Node(4));
        l1.add(new Node(3));
        LinkedList l2 = new LinkedList();
        l2.add(new Node(5));
        l2.add(new Node(6));
        l2.add(new Node(4));

        LinkedList lResult = new LinkedList();
        int l1Value = 0;
        int l2Value = 0;
        int size = l1.size();
        for (int i = 0; i < size; i++) {
            l1Value += ((Node) l1.poll()).getData() * Math.pow(10, i);
            l2Value += ((Node) l2.poll()).getData() * Math.pow(10, i);

        }

        Integer sum = l1Value + l2Value;
        //System.out.println(sum);

        String s = sum.toString();
        char[] c = s.toCharArray();

        for (int i = c.length - 1; i >= 0; i--) {
            char c1 = c[i];
            lResult.add(new Node(Character.getNumericValue(c1)));
        }
        int size2 = lResult.size();
        for (int i = 0; i < size2; i++) {
            Node n3 = (Node) lResult.poll();
            System.out.println(n3.getData());
        }
    }

}
