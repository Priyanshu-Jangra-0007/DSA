import java.util.*;
public class ice{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                if(arr[i][0]==arr[j][0] || arr[i][1]==arr[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(j);
                }
            }
        }
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
        }
        System.out.println(count-1);
    }
    public static void dfs(int src,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        for(int neigh:adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh,vis,adj);
            }
        }
    }
}