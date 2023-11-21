import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(11, 22, 33));
//        Subset4  sub = new Subset4();
//        ArrayList<ArrayList<Integer>> resp = sub.subsets(A);
//        AllUniquePermutations pr = new AllUniquePermutations();
//        ArrayList<ArrayList<Integer>> resp = pr.permute(A);

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
//        B.add(0, new ArrayList<>(List.of(1, 0, 0, 0)));
//        B.add(1, new ArrayList<>(List.of(0, 0, 0, 0)));
//        B.add(2, new ArrayList<>(List.of(0, 0, 2, -1)));

        B.add(0, new ArrayList<>(List.of(0, 1)));
        B.add(1, new ArrayList<>(List.of(2, 0)));

        UniquePathsIII up = new UniquePathsIII();
        int resp = up.solve(B);
        System.out.println("final ans::::");
        System.out.println(resp);
    }
}