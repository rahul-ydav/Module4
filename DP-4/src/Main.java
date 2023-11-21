import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
//        ArrayList<Integer> A = new ArrayList<>(List.of(3, 4, 1, 6, 2));
//        RodCutting rc = new RodCutting();

        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));
        CoinChange cc = new CoinChange();
        int resp = cc.coinchange2(A, 4);
        System.out.println("Final resp:: "+resp);
    }
}