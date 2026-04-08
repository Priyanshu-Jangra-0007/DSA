import java.util.*;
public class WallsAndGates2 {
    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    static int rl,cl;
    static int maxi=Integer.MAX_VALUE;
    static class pair{
        int r,c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public static void bfs(Queue<pair> q,int arr[][]){
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.r;
            int c=curr.c;
            for(int i=0;i<4;i++){
                int nR=r+dr[i];
                int nC=c+dc[i];
                if(nR<rl && nC<cl && nR>=0 && nC>=0 && arr[nR][nC]==maxi){
                    arr[nR][nC]=1+arr[r][c];
                    q.offer(new pair(nR,nC));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        rl=sc.nextInt();
        cl=sc.nextInt();
        int arr[][]=new int[rl][cl];
        //-1 water      0 Empty         INF Land
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                if(arr[i][j]==0){
                    q.offer(new pair(i,j));
                }
            }
        }
        bfs (q,arr);
        for(int i=0;i<rl;i++){
            for(int j=0;j<cl;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
