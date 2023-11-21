import java.util.ArrayList;

public class Subset4 {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int len = A.size();
        int bitMasks = 1<<len;

        for(int i = len-1; i>=0; i--){
            int currRange = 1<<i;
            for(int j = currRange; j<(1<<i+1); j++){
                ArrayList<Integer> currSet = new ArrayList<>();
                for(int k = len-1; k>=0; k--){
                    if(((j>>k) & 1) ==1)    currSet.add(A.get(len-k-1));
                    System.out.println("i = " + i+ ", j = "+ j + ", k = "+ k);
                }
                res.add(currSet);
            }
        }

        return res;
    }
}
