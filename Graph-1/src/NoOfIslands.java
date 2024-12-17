import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class NoOfIslands {

    boolean isValid(int x, int y, int a, int b, ArrayList<ArrayList<Integer>> A){
        if(x==0 && y==0)    return false;
        if(x+a<0 || x+a>=A.size())  return false;
        if(y+b<0 || y+b>=A.get(0).size())   return false;
        return A.get(x+a).get(y+b) == 1;
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int result = 0;
        int[] dir = {-1, 0, 1};

        for(int i=0; i<A.size(); i++){
            for(int j=0; j<A.get(0).size(); j++){
                if(A.get(i).get(j)==1){
                    result++;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));

                    while(!q.isEmpty()){
                        Pair currNode = q.poll();
                        for(int x: dir){
                            for(int y: dir){
                                if(isValid(x, y, currNode.getA(), currNode.getB(), A)) {
                                    q.add(new Pair(currNode.getA()+x, currNode.getB()+y));
                                    A.get(currNode.getA()+x).set(currNode.getB()+y, -1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public class Pair{
        private int a;
        private int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        int getA(){
            return this.a;
        }
        int getB(){
            return this.b;
        }
    }
}
