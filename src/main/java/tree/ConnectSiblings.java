package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSiblings {

    public static void main(String[] args) {

        Node _7 = new Node(7);
        Node _6 = new Node(6);
        Node _5 = new Node(5);
        Node _4 = new Node(4);

        Node _3 = new Node(3);
        Node _2 = new Node(2);

        Node root = new Node(1);
        root.left = _2;
        root.right = _3;
        _3.left = _4;
        _3.right = _5;
        _5.left = _6;
        _5.right = _7;

        connectSiblings(root);
        print(root);
    }

    private static void connectSiblings(Node root){
        Node t = root;
        Queue<Node> q = new LinkedList();
        q.add(t.left);
        q.add(t.right);
        Node a = t;
        while (!q.isEmpty()){
            Node n = q.peek();
            if(n.left != null)
                q.add(n.left);
            if(n.right != null)
                q.add(n.right);
            a.sibling = n;
            a = q.poll();
        }
    }

    private static void print(Node root){
        while (root.sibling != null){
            System.out.println(root.value);
            root = root.sibling;
        }
    }

    public static class Node{
        int value;
        Node left, right, sibling;

        public Node(int value) {
            this.value = value;
        }
    }
}
