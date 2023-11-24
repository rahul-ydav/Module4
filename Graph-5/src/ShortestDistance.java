import java.util.*;

public class ShortestDistance {

    public int[] dx = new int[]{-1, 0, 1, 0};
    public int[] dy = new int[]{0, -1, 0, 1};
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[][] visited = new int[A.size()][A.get(0).size()];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        q.add(new Pair(B.get(0), B.get(1), 0));

        while(!q.isEmpty()){
            Pair currPair = q.poll();
            visited[currPair.x][currPair.y] = 1;

            if(currPair.x == C.get(0) && currPair.y == C.get(1)){
                return currPair.dist;
            }

            for(int i=0; i<4; i++){
                int x = currPair.x;
                int y = currPair.y;
                int dist = currPair.dist;

                while(x>=0 && x<A.size() && y>=0 && y<A.get(0).size() && A.get(x).get(y)==0){
                    x+=dx[i];
                    y+=dy[i];
                    dist++;
                }
                x-=dx[i];
                y-=dy[i];
                dist--;

                if(visited[x][y]==0){
                    q.add(new Pair(x, y, dist));
                }
            }
        }
        return -1;
    }

    public static class Pair{
        public int x;
        public int y;
        public int dist;
        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
