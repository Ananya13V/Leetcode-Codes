/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        // return level number with max sum
        //make list of levels and then sum it
        // 1 - root
        // 2 - root.next, root.next.next
        if(root == null) return 0;
        int sum = Integer.MIN_VALUE;
        int level = 0;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            level++;
            int sumAtCurr = 0;
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                sumAtCurr += node.val;
            }
            if(sum < sumAtCurr){
                sum = sumAtCurr;
                ans = level;
            }
        }
        return ans;
    }
}

// O(n^2) -- outer loop to traverse the tree, inner loop to find sum at each level
