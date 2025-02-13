package Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DFSIterative {
    public boolean findNumber(int n, ArrayList<ArrayList<Integer>> B, int target){
        Graph2 g = new Graph2(n, B);
        g.target = target;
        return g.dfs2(1);

    }

    public class Graph2{
        private int nodes;

        private int[] visited;
        int target;
        private HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        /*
        (1, 2),
        (4, 5),
        (3, 1)
        * */
        Graph2(int n, ArrayList<ArrayList<Integer>> B){
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

        boolean dfs2(int startNode){
            Stack<Integer> st = new Stack<>();

            visited[startNode] = 1;
            st.push(startNode);
            while(!st.isEmpty()){
                int currNode = st.pop();
                visited[currNode] = 1;
                //logic condition
                if(currNode==target)    return true;

                //traversing
                if(edges.get(currNode)==null)   return false;
                for(Integer node: edges.get(currNode)){
                    if(visited[node]==0){
                        st.push(node);
                    }
                }
            }
            return false;
        }
    }
}
