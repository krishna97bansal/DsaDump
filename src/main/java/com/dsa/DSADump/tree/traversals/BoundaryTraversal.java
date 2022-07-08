package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import com.sun.source.tree.Tree;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@Service
public class BoundaryTraversal {
    public void driver(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> result=new LinkedList<>();
        leftTraversal(root,result);
        leafTraversal(root,result);
        rightTraversal(root,result);

        result.forEach(i->System.out.print(i+" "));
    }

    private void rightTraversal(TreeNode root, List<Integer> result) {
        Stack<Integer> st=new Stack<>();
        TreeNode temp=root.right;
        while(temp!=null){
            if(!isLeaf(temp)){
                st.add(temp.value);
            }
            if(temp.right!=null){
                temp=temp.right;
            }
            else{
                temp=temp.left;
            }
        }
        while(!st.isEmpty()){
            result.add(st.pop());
        }
    }

    private void leafTraversal(TreeNode root, List<Integer> result) {
        if (isLeaf(root)) {
            result.add(root.value);
            return;
        }
        if (root.left != null) leafTraversal(root.left, result);
        if (root.right != null) leafTraversal(root.right, result);
    }

    private void leftTraversal(TreeNode root, List<Integer> result) {
        result.add(root.value);
        TreeNode temp=root.left;
        while(temp!=null){
            if(!isLeaf(temp)){
                result.add(temp.value);
            }
            if(temp.left!=null){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
    }

    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
}
