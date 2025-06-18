// optimal approach using while loops to find the leftside and rightside boundary nodes of the binary tree .
// using stack to store the right elements and then adding to the answer so that the order is preserved & using recursion to find the leaf nodes
// tc - O(n)
// sc - O(n) - using stack for storing the right boundary + system stack used in the recursion to find the leaf nodes


/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> ans = new ArrayList();
    
    void leftNodes(Node root){
        Node temp = root.left;
        while(temp != null ){
            
            if(!isLeaf(temp)){
                ans.add(temp.data);
            }
            if(temp.left != null){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }

        }
        
    }
    
    void rightNodes(Node root){
        Stack<Integer> stack = new Stack();
        Node temp = root.right;
        
        while(temp != null){
            if(!isLeaf(temp)){
                stack.push(temp.data);
            }
            if(temp.right != null){
                temp = temp.right;
            }
            else{
                temp = temp.left;
            }

        }
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        
    }
    
    
    void leafNodes(Node root){
        if(root == null)
            return;
            
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        
        leafNodes(root.left);
        leafNodes(root.right);
    }
    
    boolean isLeaf(Node root){
        return (root.left == null && root.right == null);
    }
    
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root == null){
            return ans;
        }
        if(!isLeaf(root))
            ans.add(root.data);
        leftNodes(root);
        leafNodes(root);
        rightNodes(root);
        
        return ans;
    }
}
