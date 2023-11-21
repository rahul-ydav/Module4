import java.util.ArrayList;
import java.util.stream.Collectors;

public class UniquePathsIII {

    private int result = 0;
    private int startI = 0;
    private int startJ = 0;

    public int solve(ArrayList<ArrayList<Integer>> A) {
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                if(A.get(i).get(j)==1){
                    startI = i;
                    startJ = j;
                    break;
                }
            }
        }

        dfs(A, startI, startJ);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> A, int x, int y){
        ArrayList<ArrayList<Integer>> Anew = getNewInstance(A);
        if(Anew.get(x).get(y)==2 ){
            if(allNodesTraversed(Anew))    result++;
            return;
        }
        if(Anew.get(x).get(y)==0)  Anew.get(x).set(y, -1);

//        System.out.println("curr ");
        printBoard(Anew);



//        ArrayList<ArrayList<Integer>> Anew = new ArrayList<>(A.stream().map(xm -> new ArrayList<>(xm)).collect(Collectors.toList()));



        int n = Anew.size();
        int m = Anew.get(0).size();

        if(isValid(Anew, x, y-1, n, m)){
            dfs(Anew, x, y-1);
        }
        if(isValid(Anew, x, y+1, n, m)){
            dfs(Anew, x, y+1);
        }
        if(isValid(Anew, x-1, y, n, m)){
            dfs(Anew, x-1, y);
        }
        if(isValid(Anew, x+1, y, n, m)){
            dfs(Anew, x+1, y);
        }
    }

    private ArrayList<ArrayList<Integer>> getNewInstance(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> Anew = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            Anew.add(i, new ArrayList<Integer>());
            for(int j=0; j<A.get(0).size(); j++){
                Anew.get(i).add(A.get(i).get(j));
            }
        }
        return Anew;
    }

    private boolean isValid(ArrayList<ArrayList<Integer>> A, int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m && A.get(x).get(y)!=-1 && A.get(x).get(y)!=1;
    }

    private boolean allNodesTraversed(ArrayList<ArrayList<Integer>> cells){
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.get(0).size(); ++j) {
                if(cells.get(i).get(j)==0)  return false;
            }
        }

        return true;
    }

    public void printBoard(ArrayList<ArrayList<Integer>> cells) {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.get(0).size(); ++j) {
                int val = cells.get(i).get(j);
                System.out.printf(" | " + val + " | ");
            }
            System.out.print("\n");
        }
        System.out.println("==================");
    }
}
