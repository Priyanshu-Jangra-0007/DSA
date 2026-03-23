import java.util.*;
public class ConnectedComponents {
    int v;
    ArrayList<ArrayList<Integer>> adj;
    ConnectedComponents(int v){
        this.v=v;
        adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void dfs(int src,boolean vis[]){
        vis[src]=true;
        // System.out.print(src+" ");
        for(int neigh:adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh, vis);
            }
        }
    }
    public int countcomponent(){
        boolean vis[]=new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i, vis);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ConnectedComponents g=new ConnectedComponents(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        boolean vis[]=new boolean[6];
        // g.dfs(1, vis);
        System.out.println("Connected Components : "+g.countcomponent());
    }
}
