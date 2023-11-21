import java.util.*;

public class TopologicalSort {
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph1 g = new Graph1(A, B);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<g.inDegree.length; i++){
            if(g.inDegree[i]==0) q.add(i);
        }



        ArrayList<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int currNode = q.poll();
            res.add(currNode);

            ArrayList<Integer> Integers = g.edges.get(currNode);

            if(Integers!=null) {
                for (Integer integer : Integers) {
                    g.inDegree[integer]--;
                    if (g.inDegree[integer] == 0) q.add(integer);
                }
            }
        }
        return res;
    }

    public static class Graph1{
        int nodes;
        Map<Integer, ArrayList<Integer>> edges  = new HashMap<>();
        public int[] visited;

        public int[] inDegree;
        Graph1(int A, ArrayList<ArrayList<Integer>> B){

            nodes = A;
            visited = new int[A+1];
            inDegree = new int[A+1];
            for (ArrayList<Integer> integers : B) {
                ArrayList<Integer> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                ar1.add(integers.get(1));
                edges.put(integers.get(0), ar1);

                inDegree[integers.get(1)]++;
            }

            for (ArrayList<Integer> integers : B) {
                Collections.sort(integers);
            }
        }
    }
}
