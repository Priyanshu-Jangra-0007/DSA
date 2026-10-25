class Solution {
    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    static int n,m;
    public int closedIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||i==n-1||j==0||j==m-1){
                    if(grid[i][j]==0){
                        dfs(i,j,grid);
                    }
                }
            }
        }
        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !vis[i][j]){
                    dfs1(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int r,int c,int[][] grid){
        grid[r][c]=1;
        for(int i=0;i<4;i++){
            int nR=r+dr[i];
            int nC=c+dc[i];
            if(nR<n && nC<m && nR>=0 && nC>=0 && grid[nR][nC]==0){
                dfs(nR,nC,grid);
            }
        }
    }
    public void dfs1(int r,int c,int[][] grid,boolean vis[][]){
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nR=r+dr[i];
            int nC=c+dc[i];
            if(nR<n && nC<m && nR>=0 && nC>=0 && grid[nR][nC]==0 && !vis[nR][nC]){
                dfs1(nR,nC,grid,vis);
            }
        }
    }
}