// using dfs to check if the cycle is present in the undirected graph

// tc - O(V + E)
// sc - O(V)

class Solution {
    public boolean isCycleDFS(Map<Integer, List<Integer>> adjList, int src, int parent, boolean[] visited){
        visited[src] = true;
        
        for(int nbr : adjList.get(src)){
            if(nbr == parent){
                continue;
            }
            
            if(visited[nbr]){
                return true;
            }
            
            if(isCycleDFS(adjList, nbr, src, visited)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];

        for(int src : adjList.keySet()){
            if(!visited[src] && isCycleDFS(adjList, src, -1, visited)){
                return true;
            }
        }
        
        return false;
    }
}
class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first
    }
}


// using bfs to check if there is cycle in the graph
// tc - O(V + E)
// sc - O(V) - queue

class Solution {
    public boolean isCycleBFS(Map<Integer, List<Integer>> adjList, int src, boolean[] visited){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        visited[src] = true;
        
        while(!q.isEmpty()){
            int[] front = q.poll();
            int node = front[0];
            int parent = front[1];
            
            for(int nbr : adjList.get(node)){
                
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    q.add(new int[]{nbr, node});
                }
                else if(nbr != parent){
                    return true;
                }
            }
        
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[V];

        for(int src : adjList.keySet()){
            if(!visited[src] && isCycleBFS(adjList, src, visited)){
                return true;
            }
        }
        
        return false;
    }
}
