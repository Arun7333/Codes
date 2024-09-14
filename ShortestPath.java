import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath
{
    public class Pair{
        int node;
        int weight;
        Pair(int n,int w){
            this.node=n;
            this.weight=w;
        }
    }

    private List<List<Pair>> graph=new ArrayList<>();
    
    private int Shortestpath(int start,int end,int n,List<List<Pair>> graph){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((u,v)->u.weight-v.weight);
        
        pq.add(new Pair(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int weight=curr.weight;
            
            for(Pair pair:graph.get(node)){
                int next=pair.node;
                int nextWeight=pair.weight;
                if(dist[next]>weight+nextWeight){
                    dist[next]=weight+nextWeight;
                    pq.add(new Pair(next,dist[next]));
                }
            }
        }
        
        if(dist[end]==Integer.MAX_VALUE) return -1;
        
        return dist[end];
    }
    
    public void getInput(){
        Scanner in=new Scanner(System.in);
		
        int n=in.nextInt();
		for(int i=0;i<n;i++) this.graph.add(new ArrayList<>());
		
		int edges=in.nextInt();
		for(int i=0;i<edges;i++){
		    int u=in.nextInt();
		    int v=in.nextInt();
		    int w=in.nextInt();
		    this.graph.get(u).add(new Pair(v,w));
		    this.graph.get(v).add(new Pair(u,w));
		}
		
		int u=in.nextInt();
		int v=in.nextInt();
		ShortestPath s=new ShortestPath();
		System.out.println(s.Shortestpath(u,v,n,graph));
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    ShortestPath s=new ShortestPath();
        s.getInput();
	}
}
