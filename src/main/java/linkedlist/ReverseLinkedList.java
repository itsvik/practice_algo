package linkedlist;

import java.util.Optional;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node start = new Node();
        start.value = 1;
        addNode(start, 2);
        addNode(start, 3);
        addNode(start, 4);
        addNode(start, 5);
        addNode(start, 6);
        addNode(start, 7);
        addNode(start, 8);
        addNode(start, 9);


        print(reverseKWise(start, 4));

    }

    private static Node reverseListKWise(Node start, int k) {
        Node head = null;
        NodePair pair = reverseKElementsInLinkList(start, k);
        if(pair!=null && pair.end == null) {
            return pair.start;
        }
        while (pair!=null && pair.end!=null && pair.end.next!=null) {
            if(head == null) {
                head = pair.start;
            }
            Node temp = pair.end;
            pair = reverseKElementsInLinkList(temp.next, k);
            temp.next = pair.start;

        }
        return head;
    }


    private static Node reverseKWise(Node start, int k){
        NodePair pair = reverseKElementsInLinkList(start, k);
        Node s = pair.start;
        while (pair.end.next != null){
            Node e = pair.end;
            pair = reverseKElementsInLinkList(e.next, k);
            e.next = pair.start;
        }
        return s;
    }

    private static NodePair reverseKElementsInLinkList(Node start, int k) {
        if(start == null)
            return null;
        NodePair pair = new NodePair();
        pair.end = start;
        Node s = start, t = start;
        int i = 1;
        while (i < k && t.next != null) {
            Node temp = t.next;
            t.next = temp.next;
            temp.next = s;
            s = temp;
            i++;
        }
        pair.start = s;
        return pair;
    }

    public static class NodePair {
        Node start, end;
    }

    public static class Node {
        Integer value;
        Node next;
    }

    public static void print(Node n) {
        Node t = n;
        while (t != null) {
            System.out.println(t.value);
            t = t.next;
        }
    }

    public static void addNode(Node r, int value) {
        Node t = r;
        while (t.next != null) {
            t = t.next;
        }
        t.next = new Node();
        t.next.value = value;
    }

}
