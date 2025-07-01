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

// using bfs / kahn's algorithm for topological order if the topological order contains nodes < total nodes then cycle is present
// tc - O(V + E)
// sc - O(V)

class Solution {

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
            inDegree[v]++;
        }
        
        int count = 0;

        
        for(int src = 0; src < V; src++){
            if(inDegree[src] == 0){
                q.add(src);
                count++;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            
            for(int v : adjList.getOrDefault(u, new ArrayList<>())){
                inDegree[v]--;
                
                if(inDegree[v] == 0){
                    q.add(v);
                    count++;
                }
            }
        }
        return count != V;
    }
}
