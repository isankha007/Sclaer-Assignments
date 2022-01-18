roblem Description

Find the lowest common ancestor in an unordered binary tree A given two values B and C in the tree.

Lowest common ancestor : the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.



Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109



Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.



Output Format

Return the LCA.



Example Input

Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 LCA is 1.
Explanation 2:

 LCA is 2.


 /**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int lca(TreeNode A, int B, int C) {
        if(findIfExist(A,B)==false|| findIfExist(A,C)==false){
            return -1;
        }
        TreeNode ans= findLca(A,B,C);
        return ans==null?-1:ans.val;
    }

    public TreeNode findLca(TreeNode root ,int B, int C){
        if(root==null || root.val==B || root.val==C){
            return root;
        }
       // if(root)
       TreeNode left=findLca(root.left,B,C);
       TreeNode right=findLca(root.right,B,C);
       
       if(left==null){
           return right;
       }else if(right==null){
           return left;
       }else{
           return root;
       }
    }

    boolean findIfExist(TreeNode A,int x){
        if(A==null){
            return false;
        }
        if(A.val==x){
            return true;
        }
        return findIfExist(A.left,x)|| findIfExist(A.right,x);
    }
}

