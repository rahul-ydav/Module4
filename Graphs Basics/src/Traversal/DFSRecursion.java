package Traversal;

import java.util.ArrayList;
import java.util.HashMap;

public class DFSRecursion {
    boolean findNumber(int n, ArrayList<ArrayList<Integer>> B, int target){
        Graph g = new Graph(n, B);
        g.target = target;
        boolean  ans = g.dfs(1);
        return true;
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
            }
        }

        boolean dfs(int currNode){
            if(visited[currNode]==1)    return false;
            visited[currNode] = 1;

            if(currNode==target)    return true;
            if(edges.get(currNode)==null)   return false;
            for(Integer node : edges.get(currNode)){
                if(dfs(node))   return true;
            }
            return false;
        }
    }
}


