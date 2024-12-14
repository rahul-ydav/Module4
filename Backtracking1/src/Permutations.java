import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        findPermutes(A, 0);

        return allPermutations;
    }

    public void findPermutes(List<Integer> A, int idx){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=idx; i<A.size(); i++){
            System.out.println("idx: "+idx +", i: "+i+", currA: "+A.toString());
            if(!hs.contains(A.get(idx))) {
                hs.add(A.get(idx));
                findPermutes(A, idx + 1);
            }
            rotateSubArrayBy1(A, idx);
        }

        ArrayList<Integer> Anew = new ArrayList<>(A);
        if(idx==A.size())  allPermutations.add(Anew);
    }

    public void rotateSubArrayBy1(List<Integer> A, int idx){
        int firstVal = A.get(idx);
        for(int i= idx+1; i<A.size(); i++){
            A.set(i-1, A.get(i));
        }
        A.set(A.size()-1, firstVal);
    }
}
