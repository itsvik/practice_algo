package graph;

import java.util.*;

public class DisconnectedGraphs {

    private static final List<Node> NODE_LIST = new ArrayList<>();

    public static void main(String[] args) {
        int x = findDisconnectedGraphs(new String[]{"ababa",
                                                    "ababa",
                                                    "aaaaa"});
        System.out.println(x);
    }

    private static int findDisconnectedGraphs(String[] arr) {
        int r = arr.length, c = arr[0].length();
//        Create a matrix of Nodes from given array
        Node[][] g = new Node[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                g[i][j] = new Node();
                g[i][j].value = arr[i].charAt(j);
                NODE_LIST.add(g[i][j]);
            }
        }
        constructGraph(r, c, g);
        return getDisconnected();

    }

    /**
     * Connect all nodes in g to make a linked graph
     * @param r rows
     * @param c columns
     * @param g matrix graph
     */
    private static void constructGraph(int r, int c, Node[][] g) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i != 0)
                    g[i][j].addEdge("up", g[i-1][j]);
                if(j != 0)
                    g[i][j].addEdge("left", g[i][j-1]);
                if(i != r -1)
                    g[i][j].addEdge("down", g[i+1][j]);
                if(j != c -1)
                    g[i][j].addEdge("right", g[i][j+1]);
            }
        }
    }

    /**
     * Traverse all the nodes in g DFS
     * Remove for each disconnected(when value of nodes are different they are disconnected) graph nodes from NODE_LIST
     * Keep count of each new graph
     * Do until there is a node left in NODE_LIST
     * @return count
     */
    public static int getDisconnected(){
        Stack<Node> stack = new Stack<>();
        int count = 0;
        while (!NODE_LIST.isEmpty()) {
            Node start = NODE_LIST.get(0);
            stack.add(start);
            count++;
            while (!stack.isEmpty()) {
                Node t = stack.pop();
                NODE_LIST.remove(t);
                System.out.print(t.value);
                for (Node e : t.edges) {
                    if (NODE_LIST.contains(e) && e.value.equals(t.value) )
                        stack.add(e);
                }
            }
            System.out.println(count);
        }
        return count;
    }


    public static class Node{
        public Character value;
        public Set<Node> edges = new HashSet<>();

        public void addEdge(String dir, Node n){
            edges.add( n);
        }
    }


}
