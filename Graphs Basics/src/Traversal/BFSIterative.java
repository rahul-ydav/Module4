package Traversal;

import java.util.*;

public class BFSIterative {
    public boolean findNumber(int n, ArrayList<ArrayList<Integer>> B, int target){
        Graph g = new Graph(n, B);
        g.target = target;
        return g.bfs(1);

    }

    public class Graph{
        private int nodes;

        private int[] visited;
        int target;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph(int n, ArrayList<ArrayList<Integer>> B){
            nodes = n;

            visited = new int[n+1];

            for(ArrayList<Integer> integers: B){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(integers.get(0), new ArrayList<>());
                adjacentNodes.add(integers.get(1));
                edges.put(integers.get(0), adjacentNodes);

                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(integers.get(1), new ArrayList<>());
                adjacentNodes2.add(integers.get(0));
                edges.put(integers.get(1), adjacentNodes2);
            }
        }

        boolean bfs(int startNode){
            Queue<Integer> q = new LinkedList<>();
            visited[startNode] = 1;
            q.add(startNode);
            while(!q.isEmpty()){
                int currNode = q.remove();
                visited[currNode] = 1;
                //logic condition
                if(currNode==target)    return true;

                //traversing
                if(edges.get(currNode)==null)   return false;
                for(Integer node: edges.get(currNode)){
                    if(visited[node]==0){
                        q.add(node);
                    }
                }
            }
            return false;
        }
    }
}
