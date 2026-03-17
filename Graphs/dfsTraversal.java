import java.util.*;
public class dfsTraversal {
    int v;
    ArrayList<ArrayList<Integer>> adj;
    public dfsTraversal(int v){
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
        System.out.print(src+" ");
        for(int neigh:adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh, vis);
            }
        }
    }
    public void printlist(){
        for(int i=0;i<v;i++){
            System.out.print(i+"-> ");
            for(int neigh:adj.get(i)){
                System.out.print(neigh+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        dfsTraversal g=new dfsTraversal(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        boolean vis[]=new boolean[6];
        g.dfs(1, vis);
    }
}
