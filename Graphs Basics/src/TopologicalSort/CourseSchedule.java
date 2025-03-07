package TopologicalSort;

import Cycles.DAGDirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
leetcode 207
* */
public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] order = new int[numCourses];

        int pos = numCourses-1;

        Graph g = new Graph(numCourses, prerequisites);
        if(isCyclic(numCourses, prerequisites, g)){
            System.out.println("cyclic");
            return new int[0];
        }

        g.visited = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(g.visited[i]==0){
                pos = g.dfs(i, order, pos);
            }
        }

        return order;

    }

    public boolean isCyclic(int n, int[][] grid, Graph g){
//        DAGDirected.Graph g = new Graph(n, grid);
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
                ArrayList<Integer> adjacentNodes = this.edges.getOrDefault(B[i][1], new ArrayList<>());
                adjacentNodes.add(B[i][0]);
                edges.put(B[i][1], adjacentNodes);
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

        int dfs(int currNode, int[] order, int pos){
            visited[currNode] = 1;
            if(edges.get(currNode)==null){
                order[pos] = currNode;
                return pos-1;
            }
            for(Integer node : edges.get(currNode)){
                if(visited[node]==0){
                    pos = dfs(node, order, pos);
                }
            }
            order[pos] = currNode;
            return pos-1;
        }
    }
}
