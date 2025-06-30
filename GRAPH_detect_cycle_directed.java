// using dfs - to check if the cycle is present in the graph
// tc - O(V + E)
// sc - O(V) - recursion stack + visited + inRecursion

class Solution {
    public boolean isCycleDFS(Map<Integer, List<Integer>> adjList, int src, boolean[] visited, boolean[] inRecursion){
        visited[src] = true;
        inRecursion[src] = true;
        
        for(int nbr : adjList.getOrDefault(src, new ArrayList<>())){
            if(!visited[nbr] && isCycleDFS(adjList, nbr, visited, inRecursion)){
                return true;   
            }
            else if(inRecursion[nbr]){
                return true;
            }
        }
        inRecursion[src] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for(int src = 0; src < V; src++){
            if(!visited[src] && isCycleDFS(adjList, src, visited, inRecursion)){
                return true;
            }
        }
        
        return false;
    }
}
