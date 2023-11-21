import java.util.ArrayList;
import java.util.Arrays;

public class MaxSum {

    public int[] dp = new int[1];

    private int solve(ArrayList<ArrayList<Integer>> A, int idx){
        if(idx>=A.get(0).size())    return 0;

        if(dp[idx]!=-1) return dp[idx];

        int currMax = Math.max(A.get(0).get(idx), A.get(1).get(idx));
        dp[idx] = Math.max(solve(A, idx+2)+currMax, solve(A, idx+1));
        return dp[idx];
    }

    public int adjacent(ArrayList<ArrayList<Integer>> A) {

        dp = new int[A.get(0).size()+1];
        Arrays.fill(dp, -1);
        return solve(A, 0);
    }
}
