package com.dsa.DSADump.tree.height;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

@Service
public class MaxPathSum {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        int a[]=new int[1];
        a[0]=Integer.MIN_VALUE;
        System.out.println(maxSum(node,a));
    }

    private int maxSum(TreeNode node, int[] a) {
        if(node==null)
            return 0;

        int lh=Math.max(0,maxSum(node.left,a));
        int rh=Math.max(0,maxSum(node.right,a));

        a[0]=Math.max(a[0],node.value+lh+rh);

        return node.value+Math.max(lh,rh);

    }
}
