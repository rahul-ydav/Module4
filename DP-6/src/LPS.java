public class LPS {

    private int[][] dp = new int[0][0];
    private int findLength(StringBuilder A, StringBuilder B, int x, int y){

        if(x==A.length() || y==B.length())  return 0;

        if(dp[x][y]!=0) return dp[x][y];
        System.out.println("x:: "+x+ ", y:: "+y);
        if(A.charAt(x)!=B.charAt(y)){
            dp[x][y] = Math.max(findLength(A, B, x+1, y), findLength(A, B, x, y+1));
        }
        else dp[x][y] = 1+findLength(A, B, x+1, y+1);

        return dp[x][y];
    }
    public int solve(String A) {

        StringBuilder A1 = new StringBuilder(A);
        StringBuilder B = new StringBuilder(A1.reverse());
        A1.reverse();
        dp = new int[A.length()+1][A.length()+1];
//        System.out.println("A1:: "+A1);
//        System.out.println("B::: "+B);
        return findLength(A1, B, 0, 0);
    }
}
