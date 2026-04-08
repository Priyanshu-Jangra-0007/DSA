import java.util.*;
public class IceSkating{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][0]==arr[j][0] || arr[i][1]==arr[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(j);
                }
            }
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adj);
                count++;
            }
        }
        System.out.println(count-1);
    }

    private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i]=true;
        for(int v: adj.get(i)){
            if(!visited[v]){
                dfs(v, visited, adj);
            }
        }
    }
}