package graph;

/**
 * Matrix of 0,1
 * 0 -  water
 * 1 - land
 */
public class IslandsInSea {

    public static void main(String[] args) {
        char[][] graph = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        int count = 0;
        int r = graph.length, c = graph[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (isSafe(graph, visited, i, j)) {
                    count++;
                    DFS(graph, visited, i, j);
                }
            }
        }
        System.out.println(count);
    }


    private static void DFS(char[][] graph, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int rn[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int cn[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < rn.length; i++) {
            if (isSafe(graph, visited, r + rn[i], c + cn[i]))
                DFS(graph, visited, r + rn[i], c + cn[i]);
        }
    }

    private static boolean isSafe(char[][] graph, boolean[][] visited, int r, int c) {
        return r > -1 && r < graph.length
                && c < graph[0].length && c > -1
                && !(visited[r][c])
                && graph[r][c] == '1';
    }
}
