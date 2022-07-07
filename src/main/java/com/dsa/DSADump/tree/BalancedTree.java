package com.dsa.DSADump.tree;

import org.springframework.stereotype.Service;

@Service
/*
The tree is said to be balanced if abs(left height-right height)<=1
 */
public class BalancedTree {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        System.out.println(check(node)!=-1?"balanced":"not balanced");
    }

    private int check(TreeNode node) {
        if(node==null)
            return 0;

        int lh=check(node.left);
        if(lh==-1 )
            return -1;
        int rh=check(node.right);
        if(rh==-1 )
            return -1;
        if(Math.abs(lh-rh)>1)
            return -1;

        return 1+Math.max(lh,rh);
    }
}
