// tc - O(V + E)
// sc - O(V)

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public void bfsHelper(Map<Integer, List<Integer>> adjList, int src, ArrayList<Integer> ans, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        ans.add(src);
        
        while(!q.isEmpty()){
            int front = q.poll();
            
            for(int nbr : adjList.get(front)){
                if(!visited[nbr]){
                    q.add(nbr);
                    visited[nbr] = true;
                    ans.add(nbr);
                }
            }
        }
    }
    
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
      // making adlist for understanding
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int u = 0; u < adj.size(); u++){
            for(int v : adj.get(u)){
                adjList.putIfAbsent(u, new ArrayList<>());
                adjList.get(u).add(v);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        bfsHelper(adjList, 0, ans, visited);
        
        return ans;
    }
}
