import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fdfs {
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        Graph1 g = new Graph1(B, A);
        return g.dfs(C);
    }

    private static class Graph1{
        int finalNode;
        Map<Integer, ArrayList<Integer>> edges  = new HashMap<>();
        int[] visited;
        Graph1(int A, ArrayList<Integer> B){

            finalNode = A;
            visited = new int[B.size()+1];
            for(int i=1; i<B.size(); i++){
                ArrayList<Integer> ar = edges.getOrDefault(B.get(i), new ArrayList<>());
                ar.add(i+1);
                edges.put(B.get(i), ar);
            }
        }

        public int dfs(int currNode){
            visited[currNode] = 1;
            if(currNode==finalNode)    return 1;

            ArrayList<Integer> currArr = edges.get(currNode);
            if(currArr==null)   return 0;
            for (Integer integer : currArr) {
                if (visited[integer] != 1 && dfs(integer) == 1) {
                    return 1;
                }
            }
            return 0;
        }

        void print(){
            for(Map.Entry<Integer, ArrayList<Integer>> mp : edges.entrySet()){
                System.out.println("currNode::"+mp.getKey());
                for(Integer i: mp.getValue()){
                    System.out.print(i+ ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


}
