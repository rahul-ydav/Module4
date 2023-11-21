import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(0, new ArrayList<>(List.of(1, 2)));
        B.add(1, new ArrayList<>(List.of(2, 6)));
        B.add(2, new ArrayList<>(List.of(2, 7)));
        B.add(3, new ArrayList<>(List.of(4, 13)));
        B.add(4, new ArrayList<>(List.of(5, 8)));
        B.add(5, new ArrayList<>(List.of(5, 13)));
        B.add(6, new ArrayList<>(List.of(6, 12)));
        B.add(7, new ArrayList<>(List.of(7, 10)));
        B.add(8, new ArrayList<>(List.of(10, 14)));
        B.add(9, new ArrayList<>(List.of(13, 14)));
//        B.add(10, new ArrayList<>(List.of(12, 9)));
//        B.add(11, new ArrayList<>(List.of(2, 1)));
//        B.add(12, new ArrayList<>(List.of(9, 2)));


        int A = 14;
        int D = 2;
        ArrayList<Integer> C = new ArrayList<>(List.of(7,5,7,3,9,4,4,6,3,1,4,8,7,6));
        Batches b = new Batches();
        int resp = b.solve(A, C, B, D);
        System.out.println("Final resp:: "+resp);
    }
}