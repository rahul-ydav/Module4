import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedPath {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph1 g = new Graph1(A, B);
        g.print();
        return g.dfs(1);
    }

    private static class Graph1{
        int nodes;
        Map<Integer, ArrayList<Integer>> edges  = new HashMap<>();
        int[] visited;
        Graph1(int A, ArrayList<ArrayList<Integer>> B){

            nodes = A;
            visited = new int[A+1];
            for (ArrayList<Integer> integers : B) {
                ArrayList<Integer> ar = edges.getOrDefault(integers.get(0), new ArrayList<>());
                ar.add(integers.get(1));
                edges.put(integers.get(0), ar);
            }
        }

        public int dfs(int currNode){
            visited[currNode] = 1;
            if(currNode==nodes)    return 1;

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
            System.out.println("No. of nodes = "+nodes);
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
