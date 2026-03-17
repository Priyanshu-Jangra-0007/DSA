import java.util.*;
public class GraphList{
    int v;
    ArrayList<ArrayList<Integer>> adj;
    public GraphList(int v){
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
    public void printList(){
        for(int i=0;i<v;i++){
            System.out.print(i+"-> ");
            for(int neigh:adj.get(i)){
                System.out.print(neigh+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphList g=new GraphList(3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.printList();
    }
}