import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        [[0,0,0,1,1,1,1],[0,1,0,0,1,1,1],[0,1,1,0,0,1,1],[0,1,1,1,0,0,0],[0,1,1,1,1,1,0],[0,1,1,1,1,1,0],[0,1,1,1,1,1,0],[0,1,1,1,1,1,0],[0,0,0,0,0,0,0]]
        String b = "[" +
                "[0,0,0,1,1,1,1]," +
                "[0,1,0,0,1,1,1]," +
                "[0,1,1,0,0,1,1]," +
                "[0,1,1,1,0,0,0]," +
                "[0,1,1,1,1,1,0]," +
                "[0,1,1,1,1,1,0]," +
                "[0,1,1,1,1,1,0]," +
                "[0,1,1,1,1,1,0]," +
                "[0,0,0,0,0,0,0]" +
                "]";
        String maker = b.substring(2, b.length()-2);

        String[] rows = maker.split("],\\[");
        for(String row: rows)   System.out.println(row);

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(String row: rows){
            String[] r = row.split(",");
            ArrayList<Integer> temp = new ArrayList<>();
            for(String e : r){
                temp.add(Integer.parseInt(e));
            }
            A.add(temp);
        }
//        System.out.println(A);
        ArrayList<Integer> B = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> C = new ArrayList<>(List.of(3, 4));

//        FloydWarshallAlgo fw = new FloydWarshallAlgo();
//        ArrayList<ArrayList<Integer>> resp = fw.solve(B);
        ShortestDistance sd = new ShortestDistance();
        int resp = sd.solve(A, B, C);
        System.out.println("Final resp:: "+resp);
    }
}