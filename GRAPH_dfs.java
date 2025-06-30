// tc - O(V + E)
// sc - O(V) - recursion stack in worst case

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfsHelper(Map<Integer, List<Integer>> adjList, int src, List<Integer> ans, boolean[] visited){
        if(visited[src]){
            return ;
        }
        visited[src] = true;
        ans.add(src);
        
        for(int nbr : adjList.get(src)){
            if(!visited[nbr]){
                dfsHelper(adjList, nbr, ans, visited);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int u = 0; u < adj.size(); u++){
            
            for(int v : adj.get(u)){
                adjList.putIfAbsent(u, new ArrayList<>());
                adjList.get(u).add(v);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        dfsHelper(adjList, 0, ans, visited);
        
        return ans;
        
    }
}
