import java.util.*;
public class NoOfIslands{
    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    static int rl, cl;
    public static void dfs(char grid[][],int r,int c,boolean vis[][]){
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nR=r+dr[i];
            int nC=c+dc[i];
            if(nR>=0 && nC>=0 && nR<rl && nC<cl && !vis[nR][nC] && grid[nR][nC]=='1'){
                dfs(grid, nR, nC, vis);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char grid[][]=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.next().charAt(0);
            }
        }
        rl=grid.length;
        cl=grid[0].length;
        int count=0;
        boolean vis[][]=new boolean[rl][cl];
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        System.out.println("No of Islands : "+count);
    }
}