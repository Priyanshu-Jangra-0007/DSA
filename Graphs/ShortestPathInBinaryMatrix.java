import java.util.*;
public class ShortestPathInBinaryMatrix {
    static int dr[]={-1,-1,-1,0,0,1,1,1};
    static int dc[]={-1,0,1,-1,1,-1,0,1};
    static int rl,cl;
    static class Pair{
        int r,c,dist;
        Pair(int r,int c,int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public static int bfs(int grid[][],int r,int c,boolean vis[][]){
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(r, c,1));
        vis[r][c]=true;
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.r;
            int col=curr.c;
            int dist=curr.dist;
            if(row==rl-1 && col==cl-1) return dist;
            for(int i=0;i<8;i++){
                int nR=row+dr[i];
                int nC=col+dc[i];
                if(nR>=0 && nC>=0 && nR<rl && nC<cl && !vis[nR][nC] && grid[nR][nC]==0){
                    vis[nR][nC]=true;
                    q.offer(new Pair(nR, nC,dist+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        rl=sc.nextInt();
        cl=sc.nextInt();
        int grid[][]=new int[rl][cl];
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        boolean vis[][]=new boolean[rl][cl];
        if(grid[0][0] ==1 || grid[rl-1][cl-1]==1){
            System.out.println("-1");
            return;
        }
        int ans=bfs(grid, 0, 0, vis);
        System.out.println(ans);
    }
}
