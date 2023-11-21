import java.util.HashMap;

public class MinSquares {

    public HashMap<Integer, Integer> hm = new HashMap<>();
    public int countMinSquares(int A) {
        if(A==1)    return 1;
        if(A==0)    return 0;

        if(hm.containsKey(A))   return hm.get(A);


        int res = A;
        for(int i=1; i*i<=A; i++){
            res = Math.min(res, countMinSquares(A-i*i));
        }

        res++;
        hm.put(A, res);
        return res;
    }
}
