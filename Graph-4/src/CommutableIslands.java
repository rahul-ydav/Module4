import java.util.*;

// Minimum Spanning Tree question
public class CommutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph g = new Graph(A, B);
        return g.Prims();
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

        public int startNode = -1;

        Graph(int A, ArrayList<ArrayList<Integer>> B) {

            nodes = A;
            visited = new int[A+1];
            int smallest = Integer.MAX_VALUE;
            for (ArrayList<Integer> integers : B) {

                ArrayList<Pair> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                Pair p = new Pair(integers.get(1), integers.get(2));
                ar1.add(p);
                edges.put(integers.get(0), ar1);

                ArrayList<Pair> ar2 = edges.getOrDefault(integers.get(1), new ArrayList<>());
                Pair p2 = new Pair(integers.get(0), integers.get(2));
                ar2.add(p2);
                edges.put(integers.get(1), ar2);

                if(smallest>integers.get(2)){
                    smallest = integers.get(2);
                    startNode = integers.get(0);
                }
            }
        }



        public int Prims(){

            int res = 0;
            PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> a.w - b.w );
            p.add(new Pair(startNode, 0));

            int k = 0;
            while(!p.isEmpty() && k<nodes){
                Pair currPair = p.poll();
                if(visited[currPair.n]==1) continue;
                visited[currPair.n] = 1;

                res +=currPair.w;

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
