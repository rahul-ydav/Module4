import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
//        int A = 12;
//
//        MinSquares ms = new MinSquares();
//        int res = ms.countMinSquares(A);
//        System.out.println("ans: "+res);

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(0, new ArrayList<>(List.of(1, 2, 3, 4)));
        B.add(1, new ArrayList<>(List.of(2, 3, 4, 5)));

//        B.add(0, new ArrayList<>(List.of( 1)));
//        B.add(1, new ArrayList<>(List.of(2)));

        MaxSum ms = new MaxSum();
        int resp = ms.adjacent(B);
        System.out.println("final ans:::: " + resp);
    }
}