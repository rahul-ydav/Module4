package Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DAGDirected {

    public boolean isCyclic(int n, int[][] grid){
        Graph g = new Graph(n, grid);
        for(int startNode=0; startNode<n; startNode++){
            Arrays.fill(g.visited, 0);
            if(g.findCycle(startNode)){
                return true;
            }
        }
        return false;
    }

    public class Graph{
        private int nodes;

        int[] visited;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph(int n, int[][] B){
            nodes = n;

            visited = new int[n+1];

            for(int i=0; i<B.length; i++){
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
                adjacentNodes.add(B[i][1]);
                edges.put(B[i][0], adjacentNodes);
            }

        }

        boolean findCycle(int currNode){
            if(visited[currNode]==1)    return true;

            visited[currNode] = 1;

            if(edges.get(currNode)==null){
                visited[currNode] = 0;
                return false;
            }
            for(Integer node : edges.get(currNode)){
                if(findCycle(node))    return true;
            }
            visited[currNode] = 0;
            return false;
        }
    }
}
