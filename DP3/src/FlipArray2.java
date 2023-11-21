// This top-down approach.
// In every step we are solving some part of the problem. And then passing that partial solution further.
// The final result is calculated at the final step.

// For memoization bottom-up approach is comfortable.
import java.util.List;
public class FlipArray2 {

    private int minCount = 30000;
    private int minSum = 0;
    private int[][] dp = new int[0][0];
    public void finder(List<Integer> A, int sum, int currSum, int itr, int currCount){

        if(itr>=A.size()){
            System.out.println("inside "+ currSum + "currCount :: " + currCount);
            if(currSum>minSum){
                minCount = currCount;
                minSum = currSum;
            }
            return;
        }
//        if(dp[itr][currSum]==1)   return;
        System.out.println("currSum :: "+ currSum + "currCount :: " + currCount);
        int localSum = A.get(itr) + currSum;
        if(sum>=localSum){
            finder(A, sum, localSum, itr+1, currCount+1);
        }
        finder(A, sum, currSum, itr+1,currCount);
//        dp[itr][currSum] = 1;
    }
    public int solve(final List<Integer> A) {

        int sum = 0;
        for (Integer integer : A) sum += integer;

        dp = new int[A.size()+1][sum/2+1];
        for(int i=0; i<=A.size(); i++){
            for(int j=0; j<=sum/2; j++){
                dp[i][j] = -1;
            }
        }

//        minSum = sum;

        finder(A, sum/2, 0,0, 0);
        return minCount;
    }
}
