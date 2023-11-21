import java.util.*;

public class Batches {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        Graph1 g = new Graph1(A, C, B);
        g.print();

        int res = 0;
        for(int i=1; i<=A; i++){
            if(g.visited[i]==0){
                if(g.batchSum(i)>=D)   res++;
            }
        }
        return res;
    }
    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        public int[] visited;
        public ArrayList<Integer> strength;

        Graph1(int A, ArrayList<ArrayList<Integer>> B, ArrayList<Integer> C) {

            nodes = A;
            visited = new int[A + 1];
            strength = C;
            for (ArrayList<Integer> integers : B) {
                ArrayList<Integer> ar1 = edges.getOrDefault(integers.get(0), new ArrayList<>());
                ar1.add(integers.get(1));
                edges.put(integers.get(0), ar1);

                ArrayList<Integer> ar2 = edges.getOrDefault(integers.get(1), new ArrayList<>());
                ar2.add(integers.get(0));
                edges.put(integers.get(1), ar2);
            }
        }

        public int batchSum(int currNode) {
            visited[currNode] = 1;
            int sum = strength.get(currNode-1);

            ArrayList<Integer> currArr = edges.get(currNode);
            if (currArr == null) return sum;
            for (Integer integer : currArr) {
                if (visited[integer] == 0){
                    sum += batchSum(integer);
                }
            }

            return sum;
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
