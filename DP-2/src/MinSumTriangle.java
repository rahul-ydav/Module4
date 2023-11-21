import java.util.ArrayList;

public class MinSumTriangle {

//    private int[][] dp = new int[0][0];
    private ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
    private int finder(ArrayList<ArrayList<Integer>> a, int row, int col){
//        System.out.println("row: " + row + ", col: "+ col);
        if(col>=a.get(row).size()) return Integer.MAX_VALUE;
//        System.out.println("check1 pass");
        if(row==a.size()-1) return a.get(row).get(col);
//        System.out.println("check2 pass");

        if(dp.get(row).get(col)!=-1)    return dp.get(row).get(col);

        dp.get(row).set(col, a.get(row).get(col) + Math.min( finder(a, row+1, col), finder(a, row+1, col+1)));
//        System.out.println("localRes: "+ dp[row][col]);
        return dp.get(row).get(col);
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
//        dp = new int[a.size()][a.get(a.size()-1).size()];
        for(int i=0; i<a.size(); i++){
            dp.add(i, new ArrayList<>());
            for(int j=0; j<a.get(i).size(); j++){
                dp.get(i).add(j, -1);
            }
        }
        return finder(a, 0, 0);
    }
}
