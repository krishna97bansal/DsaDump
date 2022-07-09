package com.dsa.DSADump.tree;

import org.springframework.stereotype.Service;

@Service
public class SymmetricTrees {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        System.out.println(checkSymmetric(node.left,node.right));
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if(left==null || right==null){
            return left==right;
        }

        if(left.value!=right.value)
            return false;

        return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
    }
}
