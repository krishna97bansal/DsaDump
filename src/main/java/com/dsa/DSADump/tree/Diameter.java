package com.dsa.DSADump.tree;

import org.springframework.stereotype.Service;

@Service
public class Diameter {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        int res[]=new int[1];
        diamt(node,res);
       System.out.println(res[0]);
    }

    private int diamt(TreeNode node, int[] result) {
        if(node==null){
            return 0;
        }

        int lh=diamt(node.left,result);
        int rh=diamt(node.right,result);

        result[0]=Math.max(result[0],lh+rh);

        return 1+Math.max(lh,rh);
    }
}
