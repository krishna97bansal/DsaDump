package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;
/*
Points to Remember:
1. The order is Root Node->Left Node->Right Node.
 */
@Service
public class PreOrderTraversal {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        inOrderTraversal(node);
    }

    private void inOrderTraversal(TreeNode node) {
        if(node==null){
            return;
        }

        System.out.print(node.value+" ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);

    }
}