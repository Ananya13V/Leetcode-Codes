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
    long mod = 1000000007L;
    long ans = 0;

    private long dfs(TreeNode node){
        if(node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }
    public int maxProduct(TreeNode root) {
        long total = dfs(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) continue;

            long cur = (total - node.val) * node.val;
            ans = Math.max(ans, cur);

            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }

        return (int)(ans% mod);
    }
}

//Optimized
// class Solution {
//     long maxP=0, SUM=0;
//     public int maxProduct(TreeNode root) {
//         if (root == null) return 0;
      
//         SUM= totalsum(root);
//         totalsum(root);

//         return (int)(maxP % 1000000007);
//     }

//          int totalsum(TreeNode root)
//         {
//                 if(root==null) return 0;

//                 int lss= totalsum(root.left);
//                 int rss= totalsum(root.right);
//                 int subts= root.val+ lss+ rss;

//                 maxP = Math.max(maxP, subts * (SUM - subts));
//                 return subts;
//         }
//     }
