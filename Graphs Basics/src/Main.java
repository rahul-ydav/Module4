import Cycles.DAGDirected;
import Cycles.UndirectedAG;
import SortestPaths.UnweightedGraphs;
import TopologicalSort.CourseSchedule;
import Traversal.BFSIterative;
import Traversal.DFSIterative;
import Traversal.Grid4Dir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int n = 10;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(0, new ArrayList<>(List.of(1, 2)));
        B.add(1, new ArrayList<>(List.of(2, 5)));
        B.add(new ArrayList<>(List.of(3, 1)));
        B.add(1, new ArrayList<>(List.of(2, 4)));
        B.add(1, new ArrayList<>(List.of(2, 6)));
        B.add(1, new ArrayList<>(List.of(3, 7)));
        B.add(1, new ArrayList<>(List.of(3, 8)));
        B.add(1, new ArrayList<>(List.of(9, 10)));
//        B.add(new ArrayList<>(List.of(1, 9)));
        B.add(new ArrayList<>(List.of(3, 7)));

        boolean result;

//        DFSIterative dfsi = new DFSIterative();
//        result = dfsi.findNumber(n, B, 9);
//        System.out.println("result: "+ result);

//        BFSIterative bfsi = new BFSIterative();
//        result = bfsi.findNumber(n, B, 9);
//        System.out.println("result: "+ result);


//        int[][] edges = {
//                {1, 2, 4, 8},
//                {0, 1, 44, 6},
//                {13, 8, 0, 5}
//        };
//        Grid4Dir gr = new Grid4Dir();
//        result = gr.findNumber(edges, 44);
//        System.out.println("result: "+ result);

//        int[][] edges = {
//                {0, 1},
//                {4, 0},
//                {4, 2},
//                {2, 1},
//                {2, 3},
//                {3, 4}
//        };
//
//        DAGDirected dagd = new DAGDirected();
//        boolean res = dagd.isCyclic(5, edges);
//        System.out.println("dagd res: "+res);

//        int[][] edges = {
//                {0, 1},
//                {2, 0},
//                {0, 3},
//                {2, 3}
//        };
//
//        UndirectedAG uag = new UndirectedAG();
//        boolean res = uag.isCyclic(4, edges);
//        System.out.println("uag res: "+res);


//        int[][] edges = {{1,0},{2,0},{3,1},{3,2}};
//        CourseSchedule cs = new CourseSchedule();
//        int[] res = cs.findOrder(4, edges);
//
//        System.out.println("cs: "+ Arrays.toString(res));

        int[][] edges = {{0,7},{9,0},{0,11},{11, 7}, {9, 10}, {10, 1}, {1, 8}, {9,8},
                {8,12}, {12,2}, {2,3}, {7,3},{3,4},{7,6},{6,5}
        };
        int startNode = 0;
        int endNode = 5;

        UnweightedGraphs uwg = new UnweightedGraphs();
        String res = uwg.findSortestPath(12, edges, startNode, endNode);
        System.out.println("uwg res: "+res);

    }
}