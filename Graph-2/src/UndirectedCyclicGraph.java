import java.util.*;

public class UndirectedCyclicGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph1 g = new Graph1(A, B);

        for (ArrayList<Integer> integers : B) {
            if (g.visited[integers.get(0)] == 0 && g.dfs(integers.get(0), -1)==1) {
                return 1;
            }
        }

        return 0;
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

        public int dfs(int currNode, int lastNode) {
            visited[currNode] = 1;
            ArrayList<Integer> currArr = edges.get(currNode);
            if (currArr == null) return 0;
            for (Integer integer : currArr) {
                if(visited[integer]==1 && integer!=lastNode && currArr.size()>1)    return 1;
                else if (visited[integer] == 0 && dfs(integer, currNode)==1)   return 1;
            }

            return 0;
        }

        public int bfs(int currNode){
            Queue<Integer> q = new ArrayDeque<>();
            visited[currNode] = 1;

            q.add(currNode);

            while(!q.isEmpty()){
                int node = q.poll();
                ArrayList<Integer> currArr = edges.get(currNode);
                if (currArr == null) return 0;
                for (Integer integer : currArr) {
                    if(visited[integer]==1 && integer!=node)    return 1;
                    if(visited[integer]==0){
                        visited[integer] = 1;
                        q.add(integer);
                    }
                }
            }
            return 0;
        }

        void print() {
            System.out.println("No. of nodes = " + nodes);
            for (Map.Entry<Integer, ArrayList<Integer>> mp : edges.entrySet()) {
                System.out.print("currNode::" + mp.getKey() + " = ");
                for (Integer i : mp.getValue()) {
                    System.out.print(i + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
