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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int l = que.size();
            for(int i = 0;i<l;i++){
                TreeNode temp = que.poll();
                level.add(temp.val);
                if(temp.left != null){
                    que.add(temp.left);
                }

                if(temp.right!=null){
                    que.add(temp.right);
                }
            }
            list.add(level);
        }
        return list;
    }
}
