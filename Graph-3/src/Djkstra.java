import java.util.*;

public class Djkstra {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        Graph1 g = new Graph1(A, B);
        ArrayList<Integer> res = g.djx(C);
        return null;
    }

    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Pair>> edges = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        public int[] visited;

        Graph1(int A, ArrayList<ArrayList<Integer>> B) {

            nodes = A;
            for(int i=0; i<nodes; i++){
                pq.add(new Pair(0, Integer.MAX_VALUE));
            }
            visited = new int[A];
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

        public ArrayList<Integer> djx(int startNode){

            PriorityQueue<Pair> p = new PriorityQueue<>();
            ArrayList<Integer> dist = new ArrayList<>(Collections.nCopies(nodes, Integer.MAX_VALUE));

            p.add(new Pair(startNode, 0));
            dist.set(startNode, 0);

            while(!p.isEmpty()){
                Pair currPair = p.poll();
                visited[currPair.n] = 1;

                ArrayList<Pair> currArr = edges.get(currPair.n);
                if (currArr == null) return null;
                for(Pair pair: currArr){
                    if(dist.get(pair.n)> (dist.get(currPair.n) + pair.w)){
                        dist.set(pair.n, dist.get(currPair.n) + pair.w);
                    }
                    p.add(new Pair(pair.n, dist.get(pair.n)));
                }
            }
            return null;
        }
    }

    public static class Pair{
        public int n;
        public int w;
        Pair(int node, int weight){
            n = node;
            w = weight;
        }
    }
}
