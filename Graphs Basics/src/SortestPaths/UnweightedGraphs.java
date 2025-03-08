package SortestPaths;

import java.util.*;

public class UnweightedGraphs {

    public String findSortestPath(int nodes, int[][] edges, int startNode, int endNode){

        //bfs
        Graph g = new Graph(nodes, edges, endNode);
        boolean found = g.bfs(startNode);
        if(!found)  return "Path doesn't exists";
        //construct Path
        ArrayList<Integer> res = new ArrayList<>();
        int i=endNode;
        while(i!=startNode){
            res.add(i);
            i = g.prev[i];
        }
        res.add(startNode);

        Collections.reverse(res);

        return res.toString();
    }
    public class Graph{
        private int nodes;

        private int[] visited;
        int endNode;
        public int[] prev;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph(int n, int[][] B, int endNode){
            this.endNode = endNode;
            nodes = n;

            visited = new int[n+1];
            prev = new int[n+1];

            for(int i=0; i<B.length; i++){

                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(B[i][0], new ArrayList<>());
                adjacentNodes.add(B[i][1]);
                edges.put(B[i][0], adjacentNodes);

                ArrayList<Integer> adjacentNodes2 = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                adjacentNodes2.add(B[i][0]);
                edges.put(B[i][1], adjacentNodes2);
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
                if(currNode==endNode)    return true;

                //traversing
                if(edges.get(currNode)==null)   return false;
                for(Integer node: edges.get(currNode)){
                    if(visited[node]==0){
                        q.add(node);
                        prev[node] = currNode;
                    }
                }
            }
            return false;
        }
    }
}
