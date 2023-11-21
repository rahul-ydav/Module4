import java.util.ArrayList;
import java.util.Objects;

public class RussianDoll2 {
    private int[][] dp = new int[0][0];
    public int longestIncreasingSeq(ArrayList<ArrayList<Integer>> A, int itr) {

        if (itr == A.size() - 1) return 1;

        int maxAns = 0;
        for(int i=itr+1; i<A.size(); i++){

            if(itr!=-1 && A.get(itr).get(1)>A.get(i).get(1) && A.get(itr).get(0)>A.get(i).get(0)){
                maxAns = Math.max(maxAns, 1+longestIncreasingSeq(A, i));
            }
            else if(itr==-1){
                maxAns = Math.max(maxAns, 1+longestIncreasingSeq(A, i));
            }
        }
        return maxAns;
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {

        dp = new int[A.size() + 1][A.size() + 1];
        A.sort((a, b) -> {
            if (Objects.equals(a.get(1), b.get(1))) return b.get(0).compareTo(a.get(0));
            return a.get(1).compareTo(b.get(1));
        });
        System.out.println(A);
        int res = longestIncreasingSeq(A,  -1);
        return res;
    }
}
