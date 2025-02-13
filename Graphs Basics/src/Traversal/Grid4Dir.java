package Traversal;

import java.util.ArrayList;

public class Grid4Dir {

    int[][] grid;
    int n;
    int m;
    int target;
    int[] dir = {-1, 1};
    public boolean findNumber(int[][] grid, int target){
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        this.target = target;

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    if(dfs(i, j)) return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int x, int y){
        if(grid[x][y] == target)    return true;

        grid[x][y] = 0;

        for(int i=0; i<dir.length; i++){
            if(validNode(x, y+dir[i])){
                if(dfs(x, y+dir[i]))    return true;
            }
            if(validNode(x+dir[i], y)){
                if(dfs(x+dir[i], y))    return true;
            }
        }
        return false;
    }

    boolean validNode(int x, int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0;
    }

}
