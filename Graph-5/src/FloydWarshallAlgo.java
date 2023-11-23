import java.util.ArrayList;

public class FloydWarshallAlgo {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int nodes = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0; i<nodes; i++){
            res.add(new ArrayList<>());
            for(int j=0; j<nodes; j++){
                if(A.get(i).get(j)==-1){
                    res.get(i).add(Integer.MAX_VALUE);
                }
                else{
                    res.get(i).add(A.get(i).get(j));
                }
            }
        }

        for(int k=0; k<nodes; k++){
            for(int i=0; i<nodes; i++){
                for(int j=0; j<nodes; j++){
                    if(res.get(i).get(k)==Integer.MAX_VALUE || res.get(k).get(j)==Integer.MAX_VALUE){
                        continue;
                    }
                    else if(res.get(i).get(k)+res.get(k).get(j)<res.get(i).get(j)){
                        res.get(i).set(j, res.get(i).get(k) + res.get(k).get(j));
                    }
                }
            }
        }

        for(int i=0; i<nodes; i++){
            for(int j=0; j<nodes; j++) {
                if(res.get(i).get(j)==Integer.MAX_VALUE)    res.get(i).set(j, -1);
            }
        }

        return res;
    }
}
