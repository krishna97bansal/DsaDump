package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;
/*
Points to Remember:
1. The order is Left Node->Right Node->Root Node.
 */
@Service
public class PostOrderTraversal {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        postOrderTraversal(node);
    }

    private void postOrderTraversal(TreeNode node) {
        if(node==null){
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value+" ");

    }
}
