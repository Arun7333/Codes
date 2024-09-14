import java.util.*;
import java.lang.*;
import java.io.*;

class Nearest
{
    private int result;
    
    public static int dfs(int node1,int node2,boolean[] vis1,boolean[] vis2,int[] Edge){
        if(Edge[node1]==-1){
            if(Edge[node2]==-1||vis2[node2]) return -1;
        }
        if(vis1[node1]){
            if(Edge[node2]==-1||vis2[node2]) return -1;
        }
        if(vis1[node2]||node1==node2) return node2;
        if(vis2[node1]) return node1;
        
        vis1[node1]=true;
        vis2[node2]=true;
        if(Edge[node1]==-1) return dfs(node1,Edge[node2],vis1,vis2,Edge);
        else if(Edge[node2]==-1) return dfs(Edge[node1],node2,vis1,vis2,Edge);

        return dfs(Edge[node1],Edge[node2],vis1,vis2,Edge);
    }
    
    public static int NearestMeetingCell(int node1,int node2,int[] Edge){
        
        return dfs(node1,node2,new boolean[Edge.length],new boolean[Edge.length],Edge);
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] Edge=new int[n];
		
		for(int i=0;i<n;i++){
		    Edge[i]=in .nextInt();
		}
		
		int n1=in.nextInt();
		int n2=in.nextInt();
		System.out.println(NearestMeetingCell(n1,n2,Edge));
	}
}
