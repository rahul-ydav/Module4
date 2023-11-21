import java.util.ArrayList;

public class Subset2 {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        findSets(A, new ArrayList<>(), 0);

        return res;
    }

    void findSets(ArrayList<Integer> A, ArrayList<Integer> temp, int idx){
        if(idx==A.size()){
            res.add(temp);
            return;
        }

        findSets(A, temp, idx+1);

        ArrayList<Integer> temp2 = new ArrayList<>(temp);
        temp2.add(A.get(idx));
        findSets(A, temp2, idx+1);
    }
}
