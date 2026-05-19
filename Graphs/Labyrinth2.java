import java.util.*;
public class Labyrinth2 {
    static int rl,cl;
    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    static char direction[]={'U','D','L','R'};
    static char arr[][];
    static boolean vis[][];
    static class pair{
        int r,c;
        pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public static String bfs(int sr,int sc,int er,int ec){
        Queue<pair> q=new LinkedList<>();
        char[][] parent=new char[rl][cl];
        q.add(new pair(sr, sc));
        while(!q.isEmpty()){
            pair curr=q.poll();
            if(curr.r==er && curr.c==ec){
                StringBuilder path=new StringBuilder();
                int r=er,c=ec;
                while(r!=sr ||c!=sc){
                    char d=parent[r][c];
                    path.append(d);
                    if(d=='U')r++;
                    else if(d=='D') r--;
                    else if(d=='L') c++;
                    else if(d=='R') c--;
                }
                return path.reverse().toString();
            }
            for(int i=0;i<4;i++){
                int nR=curr.r+dr[i];
                int nC=curr.c+dc[i];
                if(nR>=0 && nC>=0 && nR<rl && nC<cl && arr[nR][nC]!='#' && !vis[nR][nC]){
                    vis[nR][nC]=true;
                    parent[nR][nC]=direction[i];
                    q.offer(new pair(nR, nC));
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        rl=sc.nextInt();
        cl=sc.nextInt();
        arr=new char[rl][cl];
        vis=new boolean[rl][cl];
        char par[][]=new char[rl][cl];

        int sx=0,sy=0,dx=0,dy = 0;
        for(int i=0;i<rl;i++){
            String s=sc.next();
            for(int j=0;j<cl;j++){
                arr[i][j]=s.charAt(j);
                if(arr[i][j]=='A'){
                    sx=i;
                    sy=j;
                }
                if(arr[i][j]=='B'){
                    dx=i;
                    dy=j;
                }
            }
        }
        Queue<pair> q=new LinkedList<>();
        String path=bfs(sx,sy,dx,dy);
        if (path == null) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(path.length());
            System.out.println(path);
        }
    }
}
