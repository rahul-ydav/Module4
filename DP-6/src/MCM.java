import java.util.ArrayList;

public class MCM {

    private int[][] dp = new int[0][0];
    private int makeMCM(ArrayList<Integer> A, int i, int j){
        if(i>=j)    return 0;

        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int minSum = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempSum = makeMCM(A, i, k) + makeMCM(A, k+1, j) + A.get(i-1)*A.get(k)*A.get(j);

            minSum = Math.min(tempSum, minSum);
        }

        dp[i][j] = minSum;

        return minSum;
    }
    public int solve(ArrayList<Integer> A) {

        dp = new int[A.size()][A.size()];
        return makeMCM(A, 1, A.size()-1);
    }
}
