// topological sort using dfs
// keeping the nodes in stack for the topological sorted order
// tc - O(V + E)
// sc - O(V) - visited array & stack

class Solution {
    public static void topoSortDFS( Map<Integer, List<Integer>> adjList, int src, boolean[] visited, Stack<Integer> stack){
        visited[src] = true;
        
        for(int nbr : adjList.getOrDefault(src, new ArrayList<>())){
            if(!visited[nbr]){
                topoSortDFS(adjList, nbr, visited, stack);
            }
        }
        stack.push(src);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int src = 0; src < V; src++){
            if(!visited[src]){
                topoSortDFS(adjList, src, visited, stack);
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}


// kahn's algorithm
// topological sort using bfs - indegree array to store the indegries of the nodes
// tc - O(V + E)
// sc - O(V) - indegree - array

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        
        for(int src = 0; src < V; src++){
            if(inDegree[src] == 0){
                q.add(src);
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
                }
            }
        }
        return ans;
    }
}
