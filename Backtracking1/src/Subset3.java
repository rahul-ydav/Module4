import java.util.ArrayList;
// working recursive solution
public class Subset3 {
    public ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        res.add(new ArrayList<>());
        findSets(A, new ArrayList<>(), 0, true);
        findSets(A, new ArrayList<>(), 0, false);

        return res;
    }

    void findSets(ArrayList<Integer> A, ArrayList<Integer> temp, int idx, boolean addNext) {
        if (idx == A.size()) {
            return;
        }
        if (addNext) {
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            temp2.add(A.get(idx));

            res.add(temp2);
            temp = temp2;
        }
        findSets(A, temp, idx+1, true);
        findSets(A, temp, idx+1, false);
    }
}
