import java.util.ArrayList;

public class uniquePaths {
    public int[][] dp = new int[0][0];
    private int solve(ArrayList<ArrayList<Integer>> A, int x, int y){
        int n = A.size();
        int m = A.get(0).size();
        System.out.println("n:: "+n + " m::: "+ m + " x:: "+x + " y:: "+ y);
        if(x<0 || x>=n || y<0 || y>=m || A.get(x).get(y)==1)    return 0;
        if(x==n-1 && y==m-1)    return 1;
        if(dp[x][y]!=-1)    return dp[x][y];

        dp[x][y] = solve(A, x, y+1) + solve(A, x+1, y);

        return dp[x][y];
    }
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        dp = new int[A.size()][A.get(0).size()];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }
        return solve(A, 0, 0);
    }
}
