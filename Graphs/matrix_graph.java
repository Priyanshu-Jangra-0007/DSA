import java.util.*;
public class matrix_graph{
    public static void printM(int [][]mat,int len){
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v,edges;
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        edges=sc.nextInt();
        int[][] mat=new int[v+1][v+1];
        for(int i=0;i<edges;i++){
            int u=sc.nextInt();
            int v1=sc.nextInt();
            mat[u][v1]=1;
            mat[v1][u]=1;
        }
        printM(mat,v+1);
    }
}