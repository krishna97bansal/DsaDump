package com.dsa.DSADump.tree;

import org.springframework.stereotype.Service;

@Service
public class ChildrenSumPropertyConversion {
    public void driver(){
        TreeNode  root = new TreeNode(2);
        root.left = new TreeNode(35);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);

        change(root);

    }

    private void change(TreeNode root) {
        if(root==null)
            return;
        int childSum=0;
        if(root.left!=null){
            childSum+=root.left.value;
        }
        if(root.right!=null){
            childSum+=root.right.value;
        }
        if(childSum<root.value){
            if(root.left!=null){
                root.left.value=childSum;
            }
            if(root.right!=null){
                root.right.value=childSum;
            }
        }

        change(root.left);
        change(root.right);

        int tot=0;
        if(root.left!=null){
            childSum+=root.left.value;
        }
        if(root.right!=null){
            childSum+=root.right.value;
        }
        if (root.left!=null || root.right!=null){
            root.value=tot;
        }

    }
}
