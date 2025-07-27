class Solution {
    //LC - 695
    public int dfs(int[][] grid, int i, int j, int area){
        int n = grid.length, m=grid[0].length;
        area+=1;
        int dx[] = {0,1,0,-1};
        int dy[] = {-1,0,1,0};
        grid[i][j] = 0;
        int ans=1;
        for(int dir=0;dir<4;dir++){
            int x = i + dx[dir];
            int y = j + dy[dir];
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                ans+=dfs(grid,x,y, area);
            }
        }
        return ans;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        int area=0, maxArea=0;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) {
                    maxArea=Math.max(dfs(grid, i, j,area), maxArea);
                }
            }
        }
        return maxArea;


    }
}
