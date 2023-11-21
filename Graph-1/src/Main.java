import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
//        B.add(0, new ArrayList<>(List.of(1, 2)));
//        B.add(1, new ArrayList<>(List.of(4, 1)));
//        B.add(2, new ArrayList<>(List.of(2, 4)));
//        B.add(3, new ArrayList<>(List.of(3, 4)));
//        B.add(4, new ArrayList<>(List.of(5, 2)));
//        B.add(5, new ArrayList<>(List.of(1, 3)));

        B.add(0, new ArrayList<>(List.of(1, 2)));
        B.add(1, new ArrayList<>(List.of(2, 3)));
        B.add(2, new ArrayList<>(List.of(4, 3)));

        DirectedPath dPath = new DirectedPath();
        int resp = dPath.solve(A, B);
        System.out.println("Final resp:: "+resp);
    }
}