class Solution{
    public long dfs(int index,int[] Edge,boolean[] vis,int[] par){
        if(index==-1) return Long.MIN_VALUE;
        long sum=Long.MIN_VALUE;
        vis[index]=true;
        par[index]=Edge[index];
        if(Edge[index]!=-1&&!vis[Edge[index]]){
            sum=Math.max(sum,dfs(Edge[index],Edge,vis,par));
        }
        else if(Edge[index]!=-1&&par[Edge[index]]!=-1){
            int temp=index;
            int ptr=par[index];
            while(ptr!=index){
                temp+=ptr;
                ptr=par[ptr];
            }
            sum=Math.max(sum,temp);
        }
        par[index]=-1;
        return sum;
    }
    
    public long largesSumCycle(int N, int Edge[]){
        boolean[] vis=new boolean[N];
        long result=Long.MIN_VALUE;
        int[] par=new int[N];
        Arrays.fill(par,-1);
        for(int i=0;i<N;i++){
            if(!vis[i]){
                result=Math.max(result,dfs(i,Edge,vis,par));
            }
        }
        if(result==Long.MIN_VALUE) return -1;
        return result;
    }
}
