package graph;

import java.util.*;
import java.util.stream.Stream;

public class AlienLanguage {
    public static void main(String[] args) {

        String[] words = {"aac", "aa", "aab"};
        printOrder(words, 3);
    }

    private static void printOrder(String[] words, int n) {
        Map<Character, Node> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            for (Character c: words[i].toCharArray()) {
                map.put(c, new Node(c));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i+1].toCharArray();
            int j =0;
            while (j < w1.length && j < w2.length && w1[j] == w2[j])
                j++;
            if(j < w1.length && j < w2.length && w1[j] != w2[j]){
                map.get(w1[j]).addOutEdge(map.get(w2[j]));
                map.get(w2[j]).addInEdge(map.get(w1[j]));
            }
        }
        printTopologicalOrder(map);
    }

    private static void printTopologicalOrder(Map<Character, Node> map) {
        Stack<Node> stack = new Stack<>();
        for (Map.Entry<Character, Node> e :
                map.entrySet()) {
            System.out.println("("+e.getKey()+")");
            for (Node n: e.getValue().outEdges) {
                System.out.println(" ---> " + n.c);
            }
        }

        for (Map.Entry<Character, Node> e : map.entrySet()) {
            if(e.getValue().inEdges.isEmpty()){
                stack.add(e.getValue());
            }
        }

        while (!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.c + " ");
            for (int i = 0; i < temp.outEdges.size(); i++) {
                Node n = temp.outEdges.get(i);
                n.removeInEdge(temp);
//                temp.removeOutEdge(n);
                if(n.inEdges.isEmpty())
                    stack.add(n);
            }
        }

    }

    public static class Node{
        public Character c;
        public List<Node> inEdges = new ArrayList<>();
        public List<Node> outEdges = new ArrayList<>();

        public Node(Character c) {
            this.c = c;
        }

        public void addInEdge(Node n){
            inEdges.add(n);
        }

        public void addOutEdge(Node n){
            outEdges.add(n);
        }

        public Node removeInEdge(Node n){
            inEdges.remove(n);
            return n;
        }
        public Node removeOutEdge(Node n){
            outEdges.remove(n);
            return n;
        }


    }


}
