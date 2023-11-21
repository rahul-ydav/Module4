import java.util.ArrayList;

public class DungeonPrincess2 {

    private int[][] dp = new int[0][0];
    private int solve(ArrayList<ArrayList<Integer>> A, int x, int y){
        if(!(x >= 0 && x < A.size() && y >= 0 && y < A.get(0).size())){
            return Integer.MIN_VALUE;
        }
        if(x==A.size()-1 && y==A.get(0).size()-1){
            return Math.min(A.get(x).get(y), 0);
        }
        if(dp[x][y] != Integer.MIN_VALUE) {
            return dp[x][y];
        }
        int res = A.get(x).get(y) + Math.max(solve(A, x+1, y), solve(A, x, y+1));
        if(res>0) res = 0;
        dp[x][y] = res;
        return res;
    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        dp = new int[A.size()+1][A.get(0).size()+1];
        for(int i=0; i<=A.size(); i++){
            for(int j=0; j<=A.get(0).size(); j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int res = -1*solve(A, 0, 0);
        for(int i=0; i<=A.size(); i++){
            for(int j=0; j<=A.get(0).size(); j++){
                System.out.print(dp[i][j]+ ", ");
            }
            System.out.println();
        }
        return res+1;
    }
}
