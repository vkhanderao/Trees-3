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
//Time Complexity:O(N)
//Space Complexity:O(1)
class Solution {
    List<List<Integer>> resultList=new ArrayList<List<Integer>>();
    List<Integer> currList=new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        helper(root,targetSum,new ArrayList<Integer>());
        return resultList;
    }
    
    private void helper(TreeNode root,int targetSum,List<Integer> currList){
        if(root==null){
            return;
        }
        currList.add(root.val);
        helper(root.left,targetSum-root.val,currList);
        if(targetSum-root.val==0 && root.left==null && root.right==null){
            resultList.add(new ArrayList(currList));
        }
        helper(root.right,targetSum-root.val,currList);
        
        currList.remove(currList.size()-1);
    }
}