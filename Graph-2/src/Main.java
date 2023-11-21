import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int A = 10;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(0, new ArrayList<>(List.of(7, 8)));
        B.add(1, new ArrayList<>(List.of(1, 2)));
        B.add(2, new ArrayList<>(List.of(0, 9)));
        B.add(3, new ArrayList<>(List.of(1, 3)));
        B.add(4, new ArrayList<>(List.of(6, 7)));
        B.add(5, new ArrayList<>(List.of(0, 3)));
        B.add(6, new ArrayList<>(List.of(2, 5)));
        B.add(7, new ArrayList<>(List.of(3, 8)));
        B.add(8, new ArrayList<>(List.of(4, 8)));
//        B.add(9, new ArrayList<>(List.of(14, 11)));
//        B.add(10, new ArrayList<>(List.of(12, 9)));
//        B.add(11, new ArrayList<>(List.of(2, 1)));
//        B.add(12, new ArrayList<>(List.of(9, 2)));

//        B.add(0, new ArrayList<>(List.of(2, 1, 1)));
//        B.add(1, new ArrayList<>(List.of(1, 1, 0)));
//        B.add(2, new ArrayList<>(List.of(0, 1, 1)));
//        B.add(3, new ArrayList<>(List.of(1, 4)));
//        B.add(4, new ArrayList<>(List.of(4, 5)));

//        RottenOranges ro = new RottenOranges();
        Bipartite bp = new Bipartite();
//        ConstructRoads cr = new ConstructRoads();
//        UndirectedCyclicGraph uc = new UndirectedCyclicGraph();
        int resp = bp.solve(A, B);
        System.out.println("Final resp:: "+resp);
    }
}