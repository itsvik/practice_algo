public class LinkList {
    public static class Node{
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node("1");
        Node root2 = new Node("2");
        Node root3 = new Node("3");
        Node root4 = new Node("4");
        Node root5 = new Node("5");
        Node root6 = new Node("6");


        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;
        root5.next = root6;
        root6.next = root1;

        System.out.println(detectLoop1(root1));

//        printList(root);

//        System.out.println("\n Reverse List --- \n");
//        Node reverseList = reverseList(root);
//        printList(reverseList);
//        System.out.println("\n Reverse reverse List --- \n");
//        Node reverseReverseList = reverseList(reverseList);
//        printList(reverseReverseList);

//        System.out.println("Reverse 2,3");
//        reverseSubList(root, 2,5);
//        printList(root);
//        reverseSubList(root, 2,5);
//        printList(root);
//        int size = getSize(root, 0);
//        System.out.println(size);


//        System.out.println(isPalindrome(root));
    }


    private static void reverseKWise(Node root, int k){
        Node temp = root, newHead = null;

        while (temp != null){

            Node before = temp;
            newHead = temp;
            temp = temp.next;
            for (int i = 1; i < k; i++){
                Node t = temp.next;
                temp.next = newHead;
                newHead.next = t;
                temp = t;
            }
//            before.next =

        }
    }


    // TODO: Check and complete
    private static boolean isPalindrome(Node root) {
        Node t = root, mid = root;
        int count = 0;
        while (t != null){
            count++;
            t = t.next;
            mid = mid.next;
            if(t != null)
                t = t.next;
            else
                break;
        }
        reverseSubList(root, count+1, count*2);
        t = root;
        while (mid != null){
            if(mid.value == t.value){
                t = t.next;
                mid = mid.next;
            } else {
                reverseSubList(root, count+1, count*2);
                return false;
            }
        }

        return true;
    }


    //TODO: Check for issues ---------------------------------------------------------------<<<<<<< Che3ck for issues
    private static String detectLoop(Node root) {
        Node s = root, f = root.next;
        int i =0;
        while (s != null && f != null){
            System.out.println("Loop :: "+i++ );
            s = s.next;
            f = f.next;
            if(s == f) {
                return getLoopPosition(root, f);
            }
            if(f != null){
                f = f.next;
                if(s == f) {
                    return getLoopPosition(root, f);
                }
            } else
                break;
        }
        return "false";
    }

    private static boolean detectLoop1(Node root) {
        Node s = root, f = root;
        while (f != null){
            f = f.next;
            if(f==null){
                return false;
            }
            s = s.next;
            f = f.next;
            if(f==null){
                return false;
            }
            if(s == f) {
                System.out.println(getLoopPosition(root, s));
                return true;
            }

        }
        return false;
    }

    private static String getLoopPosition(Node root, Node f) {
        Node s = root;

        while (s != f) {
            s = s.next;
            if(s == f) {
                return s.value;
            }
            f = f.next;
            if(s == f) {
                return s.value;
            }
        }
        return null;
    }


    private static int getSize(Node root, int s) {
        if(root == null)
            return s;
        return getSize(root.next, s+1);
    }

    private static void reverseSubList(Node root, int i, int j) {

        Node t = root;
        int count = 1;
        while (t != null && count < i-1){
            t = t.next;
            count++;
        }

        Node iBefore = t;
        Node iNext = t.next;

        t = t.next;
        Node iHead = t;

        while (t != null && ++count <= j){
            Node temp = t.next;
            t.next = iHead;
            iHead = t;
            t = temp;
        }
        iBefore.next = iHead;
        iNext.next = t;
    }

    private static Node reverseList(Node root) {
        if(root == null){
            System.out.println("Empty List");
            return null;
        }
        Node t = root.next;
        Node newHead = root;
        newHead.next = null;
        while (t != null){
            Node temp = t;
            t = t.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    private static void printList(Node root) {
        Node t = root;
        while(t != null){
            System.out.println(t.value);
            t = t.next;
        }
    }


}
