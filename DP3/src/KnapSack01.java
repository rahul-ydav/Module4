import java.util.ArrayList;

public class KnapSack01 {

    private int[][] dp = new int[0][0];
    private int finder(ArrayList<Integer> A, ArrayList<Integer> B, int C, int i) {
        if(i>=A.size() || C<=0) return 0;

        if(dp[i][C]!=0)    return dp[i][C];
        int currW = C-B.get(i);
        int res = 0;
        if(currW<0){
            res = finder(A, B, C, i+1);
        }
        else{
            res = Math.max(A.get(i) + finder(A, B, currW, i+1), finder(A, B, C, i+1));
        }
        dp[i][C] = res;

        return res;
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        dp = new int[A.size()+1][C+1];

//        System.out.println("First element:: "+dp[0][0]);
//        System.out.println("2nd element:: "+dp[0][1]);
//        System.out.println("3rd element:: "+dp[1][0]);
//        for(int i=0; i<=A.size(); i++){
//            for(int j=0; j<=C; j++){
//                dp[i][j] = -1;
//            }
//        }
        return finder(A, B, C, 0);

    }
}
