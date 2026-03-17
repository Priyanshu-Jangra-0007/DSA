import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsTraversal {
    int v;
    ArrayList<ArrayList<Integer>> adj;
    bfsTraversal(int v){
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
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int src){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            ans.add(temp);
            for(int neigh:adj.get(temp)){
                if(!vis[neigh]){
                    vis[neigh]=true;
                    q.add(neigh);
                }
            }
        }
        return ans;
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
        bfsTraversal g=new bfsTraversal(6);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        boolean vis[]=new boolean[6];
        ArrayList<Integer> ans=bfs(g.adj, vis, 1);
        System.out.println(ans);
        // g.printlist();
    }
}
