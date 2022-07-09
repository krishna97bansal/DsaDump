package com.dsa.DSADump.tree.bst;

import com.dsa.DSADump.tree.TreeNode;

public class InOrderSuccessor {public void driver(){
    TreeNode node=new TreeNode(10);
    node.left=new TreeNode(4);
    node.right=new TreeNode(15);

    node.left.left=new TreeNode(3);
    node.left.right=new TreeNode(8);

    node.left.left.left=new TreeNode(5);

    node.right.left=new TreeNode(11);
    node.right.right=new TreeNode(19);

    node.right.left.right=new TreeNode(12);

    System.out.println(inorderSuccessor(node,8).value);

}

    private TreeNode inorderSuccessor(TreeNode node, int i) {
        TreeNode res=null;

        while(node!=null){
            if(node.value<=i){
                node=node.right;
            }
            else{
                res=node;
                node=node.left;
            }
        }
        return res;
    }
}
