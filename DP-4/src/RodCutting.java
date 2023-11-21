import java.util.ArrayList;

public class RodCutting {

    private int[][] dp = new int[0][0];
    private int cutRod(ArrayList<Integer> A, int rodLen, int itr){

        if(itr==0 || rodLen==0) return 0;
        if(dp[rodLen][itr]!=-1)    return dp[rodLen][itr];
        int res;
        if(itr<=rodLen){
            res = Math.max(A.get(itr-1) + cutRod(A, rodLen-itr, itr),  cutRod(A, rodLen, itr-1));
            dp[rodLen][itr] = res;
            return res;
        }
        res = cutRod(A, rodLen, itr-1);
        dp[rodLen][itr] = res;
        return res;
    }
    public int solve(ArrayList<Integer> A) {
        dp = new int[A.size()+1][A.size()+1];
        for(int i=0; i<=A.size(); i++){
            for(int j=0; j<=A.size(); j++){
                dp[i][j] = -1;
            }
        }
        return cutRod(A, A.size(), A.size());
    }
}
