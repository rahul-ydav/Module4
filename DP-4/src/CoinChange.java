import java.util.ArrayList;

public class CoinChange {
    private final int mod = 1000007;
    private int[][] dp = new int[0][0];
    int solve(ArrayList<Integer> A, int B, int itr){

        if(B==0)    return 1;
        if(itr==-1)  return 0;

        if(dp[itr][B]!=-1)  return dp[itr][B];

        int res = 0;
        if(B-A.get(itr)>=0){
            res = (res + solve(A, B-A.get(itr), itr)%mod)%mod;
        }
        res = (res%mod + solve(A, B, itr-1)%mod)%mod;

        dp[itr][B] = res;
        return res;
    }
    public int coinchange2(ArrayList<Integer> A, int B) {

        dp = new int[A.size()+1][B+1];
        for(int i=0; i<=A.size(); i++){
            for(int j=0; j<=B; j++){
                dp[i][j] = -1;
            }
        }
        return solve(A, B, A.size()-1);
    }
}
