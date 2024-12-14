import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations2 {
    private ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
    private boolean[] used;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        this.used = new boolean[A.size()];

        Collections.sort(A);
        backTrack(A, 0, new ArrayList<>());

        return allPermutations;
    }

    private void backTrack(ArrayList<Integer> A, int idx, ArrayList<Integer> currPermute){

        if(idx==A.size()){
            allPermutations.add(new ArrayList<>(currPermute));
            return;
        }
        for(int i=0; i<A.size(); i++){
            if(used[i] || (idx>0 && A.get(idx).equals(A.get(idx-1)) && !used[idx-1])) continue;
            used[i] = true;
            currPermute.add(A.get(i));
            backTrack(A,idx+1, currPermute);
            used[i] = false;
            currPermute.remove(currPermute.size()-1);
        }

    }
}
