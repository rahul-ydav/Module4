import java.util.*;

public class PossibilityOfFinishing {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Graph1 g = new Graph1(A, B, C);

        int res = g.checkCycle();
        if(res==1)  return 0;

        return 1;
    }

    public static class Graph1 {
        int nodes;
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        public int[] visited;
        public int[] inDegree;

        Graph1(int A, ArrayList<Integer> B, ArrayList<Integer> C) {

            nodes = A;
            visited = new int[A + 1];
            inDegree = new int[A + 1];
            for (int i=0; i<B.size(); i++) {
                ArrayList<Integer> ar1 = edges.getOrDefault(B.get(i), new ArrayList<>());
                ar1.add(C.get(i));
                edges.put(B.get(i), ar1);

                inDegree[C.get(i)]++;
            }
        }

        public int detectCycle(int currNode) {
            visited[currNode]=1;
            ArrayList<Integer> currArr = edges.get(currNode);
            if (currArr == null) return 0;
            for (Integer integer : currArr) {
                if(visited[integer]==1 || detectCycle(integer)==1)    return 1;
            }
            visited[currNode] = 0;

            return 0;
        }

        public int checkCycle() {

            for(int i=1; i<=nodes; i++){
                this.visited = new int[nodes+1];
                if(detectCycle(i)==1)   return 1;
            }
            return 0;
        }
    }
}
