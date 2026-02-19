import java.util.*;
public class GraphBeauty {
    static int parent[];
    static int size[];
    static Map<Integer,HashSet<Integer>> compMap;
    static Map<Integer,Integer> compBeauty;

    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int t=sc.nextInt();

        parent=new int[n+1];
        size=new int[n+1];
        compMap=new HashMap<>();
        compBeauty=new HashMap<>();
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
            HashSet<Integer> set=new HashSet<>();
            set.add(i);
            compMap.put(i,set);
            compBeauty.put(i,1);
        }
        long totalBeauty=0;
        while(q-->0){
            int type=sc.nextInt();
            int u=sc.nextInt();
            int v=sc.nextInt();
            if(type==1){
                int parentU=find(u);
                int parentv=find(v);
                if(parentU!=parentv){
                    int temp=parentU;
                    parentU=parentv;
                    parentv=temp;
                    parent[parentv]=parentU;
                    size[parentU]+=size[parentv];
                    HashSet<Integer> big=compMap.get(parentU);
                    HashSet<Integer> small=compMap.get(parentv);
                    int beautyBig=compBeauty.get(parentU);
                    for(int node: small){
                        boolean left=big.contains(node-1);
                        boolean right=big.contains(node+1);
                        if(left && right) beautyBig--;
                        else if(!left && !right) beautyBig++;
                        big.add(node);
                    }
                    compMap.put(parentU,big);
                    compBeauty.put(parentU,beautyBig);
                    compMap.remove(parentv);
                    compBeauty.remove(parentv);
                }
            }
            else if(type==2){
                int parent_u=find(u);
                int beauty_u=compBeauty.get(parent_u);
                totalBeauty+=beauty_u;
            }
        }
        System.out.println(totalBeauty);
    }
}
