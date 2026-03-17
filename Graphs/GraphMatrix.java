import java.util.*;
public class GraphMatrix{
    int[][] adjMatrix;
    int v;
//----Constructor------
    GraphMatrix(int v){
        this.v=v;
        adjMatrix=new int[v+1][v+1];
    }
//----Add Edges--------
    public void addEdge(int u,int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;
    }
//----Print Matrix------
    public void printMatrix(){
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphMatrix g=new GraphMatrix(3);
        g.addEdge(1,2);
        g.addEdge(2,2);
        g.printMatrix();
    }
}