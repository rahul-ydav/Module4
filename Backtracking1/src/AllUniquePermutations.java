import java.util.ArrayList;
import java.util.List;

public class AllUniquePermutations {
    public ArrayList<ArrayList<Integer>> allPermutations = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        findPermutes(A, 0);

        return allPermutations;
    }

    public void findPermutes(List<Integer> A, int idx){

        for(int i=idx; i<A.size(); i++){
            System.out.println("A:: "+ A);
            findPermutes(A, idx+1);
            rotateSubArrayBy1(A, idx);
        }

        if(idx==A.size()){
            ArrayList<Integer> Anew = new ArrayList<>(A);

            if(checkUnique(Anew)) allPermutations.add(Anew);
        }
    }

    public void rotateSubArrayBy1(List<Integer> A, int idx){
        int firstVal = A.get(idx);
        for(int i= idx+1; i<A.size(); i++){
            A.set(i-1, A.get(i));
        }
        A.set(A.size()-1, firstVal);
    }

    public boolean checkUnique(ArrayList<Integer> A){

        for(ArrayList<Integer> pr : allPermutations){
            if(pr.equals(A))    return false;
        }
        return true;
    }
}
