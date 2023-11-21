import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        String A = "bebeeed";
//        LPS lps = new LPS();
//        int resp = lps.solve(A);

//        ArrayList<Integer> A = new ArrayList<>(List.of(40, 20, 30, 10, 30));
//        MCM mcm = new MCM();
//        int resp = mcm.solve(A);

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();


//        [[6,18],[2,14],[5,6],[4,15],[8,11],[3,11],[11,10],[5,11]]
//        B.add(0, new ArrayList<>(List.of(5, 4)));
//        B.add(1, new ArrayList<>(List.of(6, 4)));
//        B.add(2, new ArrayList<>(List.of(6, 7)));
//        B.add(3, new ArrayList<>(List.of(2, 3)));
//        B.add(0, new ArrayList<>(List.of(6, 18)));
//        B.add(1, new ArrayList<>(List.of(2, 14)));
//        B.add(2, new ArrayList<>(List.of(5, 6)));
//        B.add(3, new ArrayList<>(List.of(4, 15)));
//        B.add(4, new ArrayList<>(List.of(8, 11)));
//        B.add(5, new ArrayList<>(List.of(3, 11)));
//        B.add(6, new ArrayList<>(List.of(11, 10)));
//        B.add(7, new ArrayList<>(List.of(5, 11)));
        B.add(0, new ArrayList<>(List.of(8, 9)));
        B.add(1, new ArrayList<>(List.of(8, 18)));
        RussianDoll3 rd = new RussianDoll3();
        int resp = rd.solve(B);
        System.out.println("Final resp:: "+resp);
    }
}