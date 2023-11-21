public class NdigitNumber {

    private final int mod = 1000000007;
    private int[][] dp = new int[0][0];
    private int finder(int A, int B){

        if(B<0) return 0;
        if(A==0 && B==0){
            return 1;
        }
        if(A==0)    return 0;
        if(dp[A][B]!=-1)    return dp[A][B];

        int res = 0;
        for(int i=0; i<=9; i++){
            res = (res + finder(A-1, B-i)%mod)%mod;
        }
        dp[A][B] = res;

        return res;
    }
    public int solve(int A, int B) {
        dp = new int[A+1][B+1];
        for(int i=0; i<=A; i++){
            for(int j=0; j<=B; j++){
                dp[i][j] = -1;
            }
        }
        int res = 0;
        for(int i=1; i<=9; i++){
            res = (res + finder(A-1, B-i)%mod)%mod;
        }

        return res;
    }
}
