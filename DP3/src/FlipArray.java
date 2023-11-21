//This function is returning minimum sum and not minimum count of elements requires sign inversion.
import java.util.List;
public class FlipArray {

    public int finder(List<Integer> A, int itr, int sum){

        int res = sum + -2*A.get(itr);
        if(itr==A.size()-1){
            if(res>=0) return Math.min(res, sum);
            return sum;
        }
        if(res>=0){
            return Math.min(finder(A, itr+1, res), finder(A, itr+1, sum));
        }
        return finder(A, itr+1, sum);
    }
    public int solve(final List<Integer> A) {

        int sum = 0;
        for (Integer integer : A) sum += integer;

        return finder(A, 0, sum);
    }
}
