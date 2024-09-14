

class MaximumWeight{
    public int maxWeightCell(int N, int Edge[]){
       int node=0;
       int[] indegree=new int[N];
       for(int i=0;i<N;i++){
           if(Edge[i]==-1) continue;
           indegree[Edge[i]]+=i;
           if(indegree[node]<=indegree[Edge[i]]){
               node=Edge[i];
           }
       }
       return node;
    }
}
