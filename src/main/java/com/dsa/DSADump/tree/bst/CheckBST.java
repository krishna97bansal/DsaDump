package com.dsa.DSADump.tree.bst;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

@Service
public class CheckBST {
    public void driver(){
        TreeNode node=new TreeNode(13);
        node.left=new TreeNode(10);
        node.right=new TreeNode(15);

        node.left.left=new TreeNode(7);
        node.left.right=new TreeNode(12);

        node.left.left.right=new TreeNode(9);
        node.left.left.left=new TreeNode(8);

        node.right.left=new TreeNode(14);
        node.right.right=new TreeNode(17);

        System.out.println(bst(node,Long.MIN_VALUE,Long.MAX_VALUE));
    }

    private boolean bst(TreeNode node, long minValue, long maxValue) {
        if(node==null)
            return true;

        if(node.value>=maxValue || node.value<=minValue)
            return false;

        return bst(node.left,minValue,node.value) &&bst(node.right,node.value,maxValue);
    }
}
