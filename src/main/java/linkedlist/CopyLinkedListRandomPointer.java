package linkedlist;

public class CopyLinkedListRandomPointer {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = addNode(n1, 2);
        Node n3 = addNode(n1, 3);
        Node n4 = addNode(n1, 4);
        Node n5 = addNode(n1, 5);
        Node n6 = addNode(n1, 6);

        n1.random = n5;
        n2.random = n3;
        n3.random = n2;
        n4.random = n1;
        n5.random = n5;
        n6.random = n4;

        print(n1);
        Node node = copyList(n1);
        System.out.println("\nCopied List \n");
        print(node);

    }

    public static void print(Node n) {
        Node t = n;
        while (t != null) {
            System.out.println(t.value + " r: " + t.random.value);
            t = t.next;
        }
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

    private static Node copyList(Node list) {
        // keeping input list head intact
        Node l1 = list;
        // Copying first New list node out of the loop to keep Head for future
        Node l2 = new Node(l1);
        l1.next = l2;
        l1 = l1.next.next;

        // Loop list to copy and connect new list
        while (l1 != null) {
           Node n = new Node(l1);
           l1.next = n;
           l1 = l1.next.next;
        }
        l1 = list;
        // Loop list and connect randoms of new list
        while (l1 != null){
            l1.next.random = l1.random.next;
            l1 = l1.next.next;
        }
        l1 = list;
        // Loop until L1(last_node) -> L2(Last_node) -> null
        // Restore next pointers of original and new list
        while (l1.next.next != null) {
            Node t = l1.next;
            l1.next = t.next;
            t.next = l1.next.next;
            l1 = l1.next;
        }
//        return new list head
        return l2;
    }


    public static class Node {
        Integer value;
        Node next, random;

        public Node() {
        }

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Node node) {
            this.value = node.value;
            this.next = node.next;
            this.random = node.random;
        }
    }


}


