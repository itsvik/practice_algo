package linkedlist;

import java.util.Optional;

public class AddTwoNumbers {

    public static void main(String[] args) {

        Node num1 = new Node();
        num1.value = 1;
        addNode(num1, 9);
        addNode(num1, 9);
        addNode(num1, 4);
        addNode(num1, 5);

        Node num2 = new Node();
        num2.value = 0;
        addNode(num2, 2);
        addNode(num2, 3);
        addNode(num2, 4);
        addNode(num2, 5);

        print(num1);
        print(num2);
        print(addLinkedListNumber(num1, num2));
    }

    private static Node addLinkedListNumber(Node num1, Node num2) {
        if(num1 == null)
            return num2;
        if (num2 == null)
            return num1;

        Node sum = new Node();
        sum.value = (num1.value + num2.value) % 10;
        Node result = sum;
        int carry = (num1.value + num2.value) / 10;
        num1 = num1.next;
        num2 = num2.next;

        while (num1 != null || num2 != null) {
            int x = num1 == null ? 0 : num1.value, y = num2 == null ? 0 : num2.value;
            sum.next = new Node();
            sum.next.value = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            sum = sum.next;
            num1 = num1 != null ? num1.next : null;
            num2 = num2 == null ? null : num2.next;
        }
        if(carry > 0){
            sum.next = new Node();
            sum.next.value = carry;
        }
        return result;
    }

    public static class NumberPair {
        Node num1, num2;
    }


    public static class Node {
        int value;
        Node next;
    }

    public static void print(Node n) {
        Node t = n;
        while (t != null) {
            System.out.print(t.value);
            t = t.next;
        }
        System.out.println();
    }

    public static Node addNode(Node r, int value) {
        Node t = r;
        while (t.next != null) {
            t = t.next;
        }
        t.next = new Node();
        t.next.value = value;
        return t.next;
    }

}
