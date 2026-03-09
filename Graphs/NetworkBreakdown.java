public class NetworkBreakdown {
    static int parent[];
    static int comp;
    static class Pair{
        int u,v;
        Pair(int u,int v){
            this.u=u;
            this.v=v;
        }
    }
    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public static void main(String[] args) {
        
    }
}
