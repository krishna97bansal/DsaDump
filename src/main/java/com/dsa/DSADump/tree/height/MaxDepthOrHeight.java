package com.dsa.DSADump.tree.height;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

@Service
public class MaxDepthOrHeight {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        System.out.println(height(node));
    }

    private int height(TreeNode node) {
        if(node==null)
            return 0;

        int lh=height(node.left);
        int rh=height(node.right);

        return 1+Math.max(lh,rh);
    }
}
