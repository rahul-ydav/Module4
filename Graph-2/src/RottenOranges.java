import java.util.ArrayList;

public class RottenOranges {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        boolean repeatRun = false;
        int res = 0;
        if(validate(A)){
            while(!repeatRun){
                repeatRun = true;
                res++;
                for(int i=0; i<A.size(); i++) {
                    for (int j = 0; j < A.get(0).size(); j++) {
                        if(A.get(i).get(j)==2){
                            if(i!=0 && A.get(i-1).get(j)!=0 && A.get(i-1).get(j)!=2){
                                A.get(i-1).set(j, 2);
                                repeatRun = false;
                            }
                            if(i!=A.size()-1 && A.get(i+1).get(j)!=0 && A.get(i+1).get(j)!=2){
                                A.get(i+1).set(j, 2);
                                repeatRun = false;
                            }
                            if(j!=0 && A.get(i).get(j-1)!=0 && A.get(i).get(j-1)!=2){
                                A.get(i-1).set(j-1, 2);
                                repeatRun = false;
                            }
                            if(j!=A.get(0).size()-1 && A.get(i).get(j+1)!=0 && A.get(i).get(j+1)!=2){
                                A.get(i-1).set(j+1, 2);
                                repeatRun = false;
                            }
                        }
                    }
                }
            }
            return res-1;
        }
        return -1;
    }

    private boolean validate(ArrayList<ArrayList<Integer>> A){

        boolean validity = true;
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                if(i!=0 && A.get(i-1).get(j)!=0){
                    validity = true;
                }
                if(i!=A.size()-1 && A.get(i+1).get(j)!=0){
                    validity = true;
                }
                if(j!=0 && A.get(i).get(j-1)!=0){
                    validity = true;
                }
                if(j!=A.get(0).size()-1 && A.get(i).get(j+1)!=0){
                    validity = true;
                }
                if(!validity)   return validity;
            }
        }
        return validity;
    }
}
