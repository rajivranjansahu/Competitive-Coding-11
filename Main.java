// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// public class Solution{
//     // TC = O(n^2), SC = O(h)
//     List<List<Integer>> result;

//     public List<List<Integer>> findLeaves(TreeNode root) {
//         result = new ArrayList<>();
//         helper(root);
//         return result;
//     }

//     private void helper(TreeNode root) {
//         // base
//         if(root == null) return;
//         // logic
//         int height = height(root, 0);
//         result.get(height).add(root.val);
//         helper(root.left);
//         helper(root.right);
//     }

//     private int height(TreeNode root, int level) {
//         // base
//         if(root == null) return -1;
//         if(level == result.size()) result.add(newArrayList<>());
//         // logic
//         int left = height(root.left, level + 1);
//         int right = height(root.right, level + 1);
//         return 1 + Math.max(left, right);
//     }
// }


// public class Solution{
//     // TC = O(n), SC = O(h)
//     List<List<Integer>> result;

//     public List<List<Integer>> findLeaves(TreeNode root) {
//         result = new ArrayList<>();
//         helper(root, 0);
//         return result;
//     }

//     private int helper(TreeNode root, int level) {
//         // base
//         if(root == null) return -1;
//         if(level == result.size()) result.add(new ArrayList<>());
//         // logic
//         int left = helper(root.left, level + 1);
//         int right = helper(root.right, level + 1);
//         int height = 1 + Math.max(left, right);
//         result.get(height).add(root.val);
//         return height;
//     }
// }

// Without level parameter

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        
    List<List<Integer>> res;
    public List<List<Integer>> storeLeaves(TreeNode root) {
        // base
        if (root == null) return new ArrayList<>();
        res = new ArrayList<>();
        height(root);
        return res;
    }
    
    private int height(TreeNode root) {
        // base
        if(root == null) return -1;
        //logic
        int left = height(root.left);
        int right = height(root.right);
        int height = 1 + Math.max(left, right);
        if(height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Main m = new Main();
        System.out.println(m.storeLeaves(root));
    }
}