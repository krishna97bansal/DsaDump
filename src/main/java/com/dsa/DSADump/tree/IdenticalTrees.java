package com.dsa.DSADump.tree;

import org.springframework.stereotype.Service;

@Service
public class IdenticalTrees {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        System.out.println(check(node,node));
    }

    private boolean check(TreeNode node1,TreeNode node2) {
        if(node1==null || node2==null)
            return node1==node2;

        return (node1.value==node2.value) && check(node1.left,node2.left) &&check(node1.left,node2.left);

    }
}
