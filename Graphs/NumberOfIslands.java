class Question{
    //LC - 200
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
    */
}

class Solution {
    public void dfs(char[][] grid, int i, int j){
        int n = grid.length, m=grid[0].length;
        int dx[] = {0,1,0,-1};
        int dy[] = {-1,0,1,0};
        grid[i][j] = '0';
        for(int dir=0;dir<4;dir++){
            int x = i + dx[dir];
            int y = j + dy[dir];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]=='1'){
                dfs(grid,x,y);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m=grid[0].length;
        //boolean vis[][] = new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1') {
                    c++;
                    dfs(grid, i, j);

                }
            }
        }
        return c;


    }
}