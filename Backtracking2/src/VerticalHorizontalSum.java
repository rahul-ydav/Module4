import java.util.ArrayList;

public class VerticalHorizontalSum {


    public int finder(int A, ArrayList<ArrayList<Integer>> B, int C, int startI, int startJ){

        if(startJ==B.get(0).size()){
            startJ = 0;
            startI++;
            if(startI == B.size())  return 1;
        }

        int res = 1;

        for(int i=startI; i<B.size(); i++){
            for(int j=startJ; j<B.get(0).size(); j++){
                if(!checkRow(B, C, i, j) || !checkColumn(B, C)){
                    if(A>0){
                        B.get(i).set(j, (-1*B.get(i).get(j)));
                        A--;
                        int ans = finder(A, B, C, i, j+1);
                        if(ans==1)  return ans;
                        else if(B.get(i).get(j)<0){
                            B.get(i).set(j, -1*B.get(i).get(j));
                            A++;
                        }
                        else{
                            return 0;
                        }
                    }
                    else{
                        return 0;
                    }
                }
            }
        }
        return res;
    }

    private boolean checkRow(ArrayList<ArrayList<Integer>> B, int C, int x, int y){

        return true;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C) {

        int res = finder(A, B, C, 0, 0);
        return 0;
    }
}
