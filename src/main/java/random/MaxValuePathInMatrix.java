package random;

public class MaxValuePathInMatrix {

    public static void main (String[] args)
    {
        int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };

        System.out.println(findMaxPath(mat, 3, 5, 0, 0 , 0));
//        System.out.println(findMaxPathDP(mat, 4, 6));
    }

    private static int findMaxPath(int[][] mat, int i, int j, int ci, int cj, int value) {
        if(ci == i && cj == j){
            return value;
        }
        int r = 0, d = 0;
        if( ci < i && mat[ci+1][cj] > mat[ci][cj+1]){
            d = findMaxPath(mat, i, j, ++ci, cj, value + mat[ci+1][cj]);
        } else if( ci < i && mat[ci][cj+1] >= mat[ci+1][cj]){
            r = findMaxPath(mat, i, j, ci, ++cj, value + mat[ci][cj+1]);
        }
        return Math.max(r,d) + value;
    }

    private static int findMaxPathDP(int[][] mat, int i, int j) {
        int[][] dp = new int[i+1][j+1];
        dp[0][0] = mat[0][0];
        for (int k = 1; k < j; k++) {
            dp[0][k] = dp[0][k-1] + mat[0][k];
        }
        for (int k = 1; k < i; k++) {
            dp[k][0] = dp[k-1][0] + mat[k][0];
        }

        for (int k = 1; k < i; k++) {
            for (int l = 1; l < j; l++) {
                dp[k][l] = Math.max(dp[k-1][l], dp[k][l-1]) + mat[k][l];
            }
        }
        return dp[i-1][j-1];
    }
}
