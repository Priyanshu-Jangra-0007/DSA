import java.io.*;
import java.util.*;
public class FoxAndNames
{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] words=new String[n];
        for(int i=0;i<n;i++)
        {
            words[i]=br.readLine();
        }

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[26];
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n- 1; i++)
        {
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            for(int k=0;k<len;k++){
                char w1=a.charAt(k);
                char w2=b.charAt(k);
                if(w1!=w2)
                {
                    adj.get(w1-'a').add(w2-'a');
                    indegree[w2-'a']++;
                    break;
                }
            }
            if(a.length()>b.length() && a.startsWith(b)){
                System.out.println("Impossible");
                return ;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) 
        {
            int node = q.poll();
            sb.append((char)(node + 'a'));
            for(int adjnode:adj.get(node)){
                indegree[adjnode]--;
                if (indegree[adjnode] == 0){
                    q.offer(adjnode);
                }
            }
        }
        if(sb.length()!=26)
            System.out.println("Impossible");
        else
            System.out.println(sb.toString());
    }
}