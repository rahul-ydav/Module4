import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class RussianDoll {

    private int[][] dp = new int[0][0];
    public int longestIncreasingSeq(ArrayList<ArrayList<Integer>> A, int itr, int prevItr){

        if(itr==A.size()-1)   return 1;
//        if(dp[itr][prevItr]!=0) return dp[itr][prevItr];
//        if(A.get(itr).get(1)>A.get(prevItr).get(1) && A.get(itr).get(0)>A.get(prevItr).get(0)){
//            dp[itr][prevItr] = Math.max(1+ longestIncreasingSeq(A, itr+1, itr), longestIncreasingSeq(A, itr+1, prevItr));
//        }
//        else dp[itr][prevItr] = longestIncreasingSeq(A, itr+1, prevItr);
//        return dp[itr][prevItr];

        if(A.get(itr).get(1)>A.get(prevItr).get(1) && A.get(itr).get(0)>A.get(prevItr).get(0)){
            return Math.max(1+ longestIncreasingSeq(A, itr+1, itr), longestIncreasingSeq(A, itr+1, prevItr));
        }
        return longestIncreasingSeq(A, itr+1, prevItr);
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {

        dp = new int[A.size()+1][A.size()+1];
        A.sort((a, b) -> {
            if (Objects.equals(a.get(1), b.get(1))) return a.get(0).compareTo(b.get(0));
            return a.get(1).compareTo(b.get(1));
        });
        System.out.println(A);

        int maxAns = 0;
        for(int i=1; i<A.size(); i++){
            int currAns = (dp[i][i-1]!=0) ? dp[i][i-1] : longestIncreasingSeq(A, i, i-1);
            maxAns = Math.max(maxAns, currAns);
        }
        return  maxAns;
    }
}
