import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bipartite {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph1 g = new Graph1(A, B);

        for (ArrayList<Integer> integers : B) {
            if (g.visited[integers.get(0)] == 0 && g.dfs(integers.get(0), 2)==0) {
                return 0;
            }
        }

        return 1;
    }

    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        public int[] visited;

        Graph1(int A, ArrayList<ArrayList<Integer>> B) {

            nodes = A;
            visited = new int[A + 1];
            for (ArrayList<Integer> integers : B) {
                ArrayList<Integer> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                ar1.add(integers.get(1));
                edges.put(integers.get(0), ar1);

                ArrayList<Integer> ar2 = edges.getOrDefault(integers.get(1), new ArrayList<>());
                ar2.add(integers.get(0));
                edges.put(integers.get(1), ar2);
            }
        }

        public int dfs(int currNode, int lastVisit){
            visited[currNode] = (lastVisit%2)+1;

            ArrayList<Integer> currArr = edges.get(currNode);
            if(currArr==null)   return 1;
            for (Integer integer : currArr) {
                if(visited[integer]==visited[currNode]) return 0;
                else if (visited[integer] == 0 && dfs(integer, visited[currNode])==0){
                    return 0;
                };
            }

            return 1;
        }
    }
}
