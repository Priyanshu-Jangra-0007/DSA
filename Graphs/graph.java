import java.util.*;
public class graph {
    int v;
    ArrayList<Integer>[] adj;
    // constructor
    graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    // add edge
    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    //bfs
    void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }

    void dfsHelper(int u,boolean vis[]){
        vis[u]=true;
        System.out.print(u+" ");
        for(int v:adj[u]){
            if(!vis[v]){
                dfsHelper(v, vis);
            }
        }
    }
    void dfs(){
        int src=0;
        boolean vis[]=new boolean[v];
        dfsHelper(src, vis);
    }

    boolean isCycleUndirDFS(int src,boolean visited[],int parent){
        visited[src]=true;
        for(int neigh:adj[src]){
            if(!visited[neigh]){
                if(isCycleUndirDFS(neigh, visited, src)) return true;
            }
            else if(neigh!=parent) return true;
        }
        return false;
    }
    boolean isCycleDFS() {
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isCycleUndirDFS(i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCycleUndirBFS(int src, boolean[] vis){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,-1});
        vis[src]=true;
        while(!q.isEmpty()){
            int [] cur=q.poll();
            int u=cur[0];
            int par=cur[1];
            for(int v:adj[u]){
                if(!vis[v]){
                    vis[v]=true;
                    q.add(new int[]{v,u});
                }
                else if(v!=par){
                    return true;
                }
            }
        }
        return false;
    }
    boolean isCycleBFS(){
        boolean vis[]=new boolean [v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(isCycleUndirBFS(i, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    void printgraph(){
        for(int i=0;i<v;i++){
            System.out.print(i+ " : ");
            for(int neigh:adj[i]){
                System.out.print(neigh+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        graph g = new graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.bfs();
        System.out.println();
        g.dfs();
        // g.printgraph();
        System.out.println();
        System.out.println(g.isCycleBFS());
        System.out.println(g.isCycleDFS());
    }
}
