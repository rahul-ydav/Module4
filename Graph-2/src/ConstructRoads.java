import java.util.*;

public class ConstructRoads {
    public int mod = 1000000007;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph1 g = new Graph1(A, B);

        for (ArrayList<Integer> integers : B) {
            if (g.visited[integers.get(0)] == 0) {
                g.dfs(integers.get(0), 2);
            }
        }

        int visitedA = 0;
        int visitedB = 0;
        for(int i=0; i<g.visited.length; i++){
            if(g.visited[i]==1) visitedA++;
            else if(g.visited[i]==2) visitedB++;
            System.out.print(g.visited[i]+", ");
        }

        long allEdges = ((long)visitedA%mod*(long)visitedB%mod)%mod;
        return (int)(allEdges - (A-1)%mod + mod)%mod;
    }

    public static class Graph1{
        int nodes;
        Map<Integer, ArrayList<Integer>> edges  = new HashMap<>();
        public int[] visited;
        Graph1(int A, ArrayList<ArrayList<Integer>> B){

            nodes = A;
            visited = new int[A+1];
            for (ArrayList<Integer> integers : B) {
                ArrayList<Integer> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                ar1.add(integers.get(1));
                edges.put(integers.get(0), ar1);

                ArrayList<Integer> ar2 = edges.getOrDefault(integers.get(1), new ArrayList<>());
                ar2.add(integers.get(0));
                edges.put(integers.get(1), ar2);
            }
        }

        public void dfs(int currNode, int lastVisit){
            visited[currNode] = (lastVisit%2)+1;

            ArrayList<Integer> currArr = edges.get(currNode);
            if(currArr==null)   return;
            for (Integer integer : currArr) {
                if (visited[integer] == 0)  dfs(integer, visited[currNode]);
            }
        }

        void print(){
            System.out.println("No. of nodes = "+nodes);
            for(Map.Entry<Integer, ArrayList<Integer>> mp : edges.entrySet()){
                System.out.print("currNode::"+mp.getKey()+ " = ");
                for(Integer i: mp.getValue()){
                    System.out.print(i+ ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
