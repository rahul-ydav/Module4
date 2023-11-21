import java.util.List;

public class FlipArray3 {

    private Pair[][] dp = new Pair[0][0];
    public Pair finder(List<Integer> A, int reqSum, int itr){

        if(itr==A.size()){
            return new Pair(reqSum, 0);
        }

        if(dp[itr][reqSum]!=null){
//            System.out.println("dp["+itr+"]["+reqSum+"] = "+ dp[itr][reqSum].sum + ", " + dp[itr][reqSum].minCount);
            return new Pair(dp[itr][reqSum]);
        }

        int localSum = reqSum - A.get(itr);
        Pair left = null;
        if(localSum>=0){
            left = finder(A, localSum, itr+1);
            left.minCount++;
        }
        Pair right = finder(A, reqSum, itr+1);

        Pair ans = null;

        if(left==null || left.sum>right.sum)  ans = right;
        else if(left.sum==right.sum){
            if(left.minCount<= right.minCount)  ans = left;
            else    ans = right;
        }
        else ans = left;

        Pair res = new Pair(ans);
        dp[itr][reqSum] = res;
//        System.out.println("res["+itr+"]["+reqSum+"] = "+ res.sum + ", " + res.minCount);
        return new Pair(res);
    }
    public int solve(final List<Integer> A) {

        int sum = 0;
        for (Integer integer : A) sum += integer;

        dp = new Pair[A.size()+1][sum/2+1];
        Pair res = finder(A, sum/2, 0);
//        for(int i=0; i<=A.size(); i++){
//            for(int j=0; j<=sum/2; j++){
//                System.out.print(dp[i][j]+ ", ");
//            }
//            System.out.println();
//        }


        return res.minCount;
    }

    public class Pair{
        int sum;
        int minCount;
        Pair(int sum, int minCount){
            this.sum = sum;
            this.minCount = minCount;
        }
        Pair(Pair p){
            this(p.sum, p.minCount);
        }
    }
}
