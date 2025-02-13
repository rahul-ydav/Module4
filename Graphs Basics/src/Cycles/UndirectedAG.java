package Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UndirectedAG {
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

                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                adjacentNodes2.add(B[i][0]);
                edges.put(B[i][1], adjacentNodes2);
            }

        }

        boolean findCycle(int currNode){
            visited[currNode] = 1;

            int[] tempVisited = new int[nodes+1];
            for(int i=0; i<nodes+1; i++){
                tempVisited[i] = visited[i];
            }
            if(edges.get(currNode)==null)  return false;
            for(Integer node : edges.get(currNode)){
                if(visited[currNode]==2)    return true;
                else if(visited[node]==1){
                    visited[node] = 2;
                }
                else if(findCycle(node))    return true;
            }

            for(int i=0; i<nodes+1; i++){
                visited[i] = tempVisited[i];
            }

            return false;
        }
    }
}

