package add.two.numbers.as.a.linked.list;

import java.util.LinkedList;
import java.util.Scanner;

public class AddTwoNumbersAsALinkedList {

    static LinkedList generateList(Integer n) {
        LinkedList list = new LinkedList();
        while (n > 0) {
            list.add(n % 10);
            n = Math.floorDiv(n, 10);
        }
        return list;
    }

    static LinkedList addNumbers(LinkedList l1, LinkedList l2) {
        LinkedList results = new LinkedList();
        int size = Math.max(l1.size(), l2.size());
        int circulatingValue = 0;
        while (size-- > 0) {
            int sum = circulatingValue;
            circulatingValue = 0;

            if (!l1.isEmpty()) {
                sum += ((Integer) l1.poll());
            }
            if (!l2.isEmpty()) {
                sum += ((Integer) l2.poll());
            }
            if (sum > 9) {
                results.add(sum % 10);
                circulatingValue = 1;
            } else {
                results.add(sum);
            }
        }
        if (circulatingValue != 0) {
            results.add(circulatingValue);
        }
        return results;
    }

    static void printList(LinkedList list) {
        StringBuilder output = new StringBuilder();
        while (!list.isEmpty()) {
            output.append(list.poll());
            if (list.size() > 0) {
                output.append(" -> ");
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            LinkedList l1 = generateList(input.nextInt());
            LinkedList l2 = generateList(input.nextInt());
            /*LinkedList l1 = new LinkedList();
            l1.add(2);
            l1.add(4);
            l1.add(3);
            LinkedList l2 = new LinkedList();
            l2.add(5);
            l2.add(6);
            l2.add(4);*/

            LinkedList resultList = addNumbers(l1, l2);
            printList(resultList);

        } catch (Exception e) {
            System.out.println("I had a problem preparing your lists!\n"
                    + "Try entering 'xxx yyy' or \n'xxx\nyyy'");
        }
        input.close();

    }

}
