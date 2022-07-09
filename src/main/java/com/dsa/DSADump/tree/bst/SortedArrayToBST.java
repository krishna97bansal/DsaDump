package com.dsa.DSADump.tree.bst;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

@Service
public class SortedArrayToBST {
    public void driver(){
        int a[]= {1,2,3,4};
        TreeNode node=toBst(a,0,a.length-1);
        inOrder(node);

    }

    private void inOrder(TreeNode node) {
        if(node==null)
            return ;


        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    private TreeNode toBst(int[] a, int i, int j) {
        TreeNode node=null;
        if(i<=j){
            int med=(i+j)/2;
            node= new TreeNode(a[med]);
            node.left=toBst(a,i,med-1);
            node.right=toBst(a,med+1,j);
        }
        return  node;
    }

}
