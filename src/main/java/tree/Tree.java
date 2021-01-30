package tree;

import java.util.Arrays;
import java.util.List;

public class Tree {

    static int max = Integer.MIN_VALUE;
    static List<Integer> maxSumPath;

    public static class Node{
        Node left, right, random;
        int value;



        public Node(Node left, Node right, int value){
            this.left = left;
            this.right = right;
            this.random = null;
            this.value = value;
        }
    }

    public static void connectSibling(Node root){
        if(root == null || root.right == null)
            return;

        root.left.random = root.right;

        if(root.left.right != null){
            root.left.right.random = root.right.left;
            connectSibling(root.left);
            connectSibling(root.right);
        }
    }

    public static void main(String[] args) {

        Node _7 = new Node(null, null, 7);
        Node _6 = new Node(null, null, 6);
        Node _5 = new Node(null, null, 5);
        Node _4 = new Node(null, null, 4);

        Node _3 = new Node(_6, _7, 3);
        Node _2 = new Node(_4, _5, 2);

        Node root = new Node(_2, _3, 1);

//        connectSibling(root);

//        printSibling(root);

        getMaxSumPath(root, new Integer[8], 0, 0);
        System.out.println(max);
        maxSumPath.forEach(System.out::println);

    }

    public static void getMaxSumPath(Node root, Integer[] path, int position, int sum){
        if(root == null){
            if(sum > max){
                max = sum;
                maxSumPath = Arrays.asList(path);
            }
            return;
        }
        path[position] = root.value;
        getMaxSumPath(root.left, path, position+1, sum + root.value);
        getMaxSumPath(root.right, path, position+1, sum + root.value);
    }

//    public static void printSibling(Node root){
//        if(root == null)
//            return;
//
//        System.out.print(root.value + " ");
//        if(root.random != null){
//            System.out.println("=> "  +  root.random.value);
//        }
//
//        print(root.left);
//        print(root.right);
//    }

    public static Node lowestCommonAncestor(Node root, Node a, Node b){



        return null;
    }
}
