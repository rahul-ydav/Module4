import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RussianDoll3 {
    HashMap<Pair, Integer> mp = new HashMap<>();
    public int longestIncreasingSeq(ArrayList<ArrayList<Integer>> A, int itr, int lastItr) {

        if (itr == A.size()) return 0;
        Pair p = new Pair(itr, lastItr);
        if(mp.containsKey(p)){
            return mp.get(p);
        }
        if(itr!=lastItr && A.get(itr).get(0)>A.get(lastItr).get(0) && A.get(itr).get(1)>A.get(lastItr).get(1)){
            int left = longestIncreasingSeq(A, itr+1, lastItr);
            int right = 1+longestIncreasingSeq(A, itr+1, itr);
            int res = Math.max(left, right);
            mp.put(p, res);
        }
        else {
            int rem = longestIncreasingSeq(A, itr + 1, lastItr);
            mp.put(p, rem);
        }

        return mp.get(p);
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {

        A.sort((a, b) -> {
            if (Objects.equals(a.get(0), b.get(0))) return b.get(1).compareTo(a.get(1));
            return a.get(0).compareTo(b.get(0));
        });
        System.out.println(A);
        int res = longestIncreasingSeq(A, 0, 0);
        System.out.println(mp);
        return res;
    }

    private static class Pair{
        int itr;
        int lastHeight;
        Pair(int a, int b){
            itr = a;
            lastHeight = b;
        }
    }
}
