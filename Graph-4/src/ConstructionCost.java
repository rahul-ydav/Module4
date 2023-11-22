import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructionCost {

    public static int mod = 1000000007;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph g = new Graph(A, B);
        return g.Prims(1);
    }

    public static class Pair{
        public int n;
        public int w;
        Pair(int node, int weight){
            n = node;
            w = weight;
        }
    }

    public static class Graph {
        int nodes;
        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();
        public int[] visited;

        Graph(int A, ArrayList<ArrayList<Integer>> B) {

            nodes = A;
            visited = new int[A+1];
            for (ArrayList<Integer> integers : B) {

                ArrayList<Pair> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                Pair p = new Pair(integers.get(1), integers.get(2));
                ar1.add(p);
                edges.put(integers.get(0), ar1);

                ArrayList<Pair> ar2 = edges.getOrDefault(integers.get(1), new ArrayList<>());
                Pair p2 = new Pair(integers.get(0), integers.get(2));
                ar2.add(p2);
                edges.put(integers.get(1), ar2);

            }
        }



        public int Prims(int startNode){

            int res = 0;
            PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> a.w - b.w );
            p.add(new Pair(startNode, 0));

            int k = 0;
            while(!p.isEmpty() && k<nodes){
                Pair currPair = p.poll();
                if(visited[currPair.n]==1) continue;
                visited[currPair.n] = 1;

                res = (res%mod+ currPair.w%mod)%mod;

                ArrayList<Pair> currArr = edges.get(currPair.n);
                if (currArr == null) return res;
                for(Pair pair: currArr){
                    if(visited[pair.n]==0){
                        p.add(pair);
                    }

                }
                k++;
            }
            return res;
        }
    }
}
