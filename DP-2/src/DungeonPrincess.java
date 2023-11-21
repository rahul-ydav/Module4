import java.util.ArrayList;
/* This approach will work without memoization.
As for calculating for each cell we need to give currPow too.
So we have to implement memoization. We need to make 3d array( i.e. dependent on row, col, currPow).

Depending on currPow might not server the purpose of memoization.
Because we will be calculating for each cell again and again.
*/
public class DungeonPrincess {

//    private int[][] dp = new int[0][0];
    private int solve(ArrayList<ArrayList<Integer>> A, int x, int y, int currPow){


        if(!(x >= 0 && x < A.size() && y >= 0 && y < A.get(0).size())){
            return 100000;
        }
        int requiredPow = currPow-(-1*A.get(x).get(y));
        if(x==A.size()-1 && y==A.get(0).size()-1){
            return Math.max(-1*requiredPow, 0);
        }
//        System.out.println("x: "+ x + ", y: "+ y+ ", dp[x][y]: "+ dp[x][y]);
//        if(dp[x][y] != -1000) {
//            return dp[x][y];
//        }
        if(requiredPow<0){
            int left = solve(A, x+1, y, 0);
            int right = solve(A, x, y+1, 0);

            requiredPow = -1*requiredPow + Math.min(left, right);
        }
        else{
            currPow = requiredPow;
            requiredPow = Math.min(solve(A, x+1, y, currPow), solve(A, x, y+1, currPow));
        }
//        dp[x][y] = requiredPow;
        System.out.println("x: "+ x + ", y: "+ y+ ", requiredPow: " +requiredPow);
        return requiredPow;
    }

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
//        dp = new int[A.size()+1][A.get(0).size()+1];
//        for(int i=0; i<=A.size(); i++){
//            for(int j=0; j<=A.get(0).size(); j++){
//                dp[i][j] = -1000;
//            }
//        }
        int res = solve(A, 0, 0, 0);
        return res+1;
    }
}
