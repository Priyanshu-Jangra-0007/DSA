import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import javax.smartcardio.CardTerminals.State;
public class FlightDiscount {
    static class Pair{
        int to_city;
        long cost;
        public Pair(int to_city, long cost) {
            this.to_city = to_city;
            this.cost = cost;
        }
    }
    static class State{
        int to_city;
        long cost;
        int used;
        public State(int to_city, long cost,int used) {
            this.to_city = to_city;
            this.cost = cost;
            this.used= used;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i = 0 ; i <=n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 1; i<=m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj.get(u).add(new Pair(v,w));
        }
        long prices[][]=new long[n+1][2];
        for(long[] price:prices){
            Arrays.fill(price, Long.MAX_VALUE);
        }
        PriorityQueue<State>pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        pq.offer(new State(1,0,0));// 0->road, 1->train
        prices[1][0]=0;
        while(!pq.isEmpty()){
            State curr = pq.poll();
            int node = curr.to_city;
            long nodeCost = curr.cost;
            int discountStatus = curr.used;
            for(Pair adjNode:adj.get(node)){
                int adjN=adjNode.to_city;
                long adjNcost=adjNode.cost;
                if(prices[adjN][discountStatus]>nodeCost+adjNcost){
                    prices[adjN][discountStatus]=nodeCost+adjNcost;
                    pq.offer(new State (adjN,prices[adjN][discountStatus],discountStatus));
                }
                if(discountStatus==0){
                    adjNcost=adjNcost/2;
                    if(prices[adjN][1]>adjNcost+nodeCost){
                        prices[adjN][1]=adjNcost+nodeCost;
                        pq.offer(new State (adjN,prices[adjN][1],1));

                    }
                }
            }
        }
        System.out.println(Math.min(prices[n][0], prices[n][1]));
    }
}
