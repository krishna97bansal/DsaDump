package com.dsa.DSADump.tree.views;

import com.dsa.DSADump.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeftView {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        Map<Integer,Integer> res=new HashMap<>();
        leftView(node,res,0);
        System.out.println(res.values());
    }

    private void leftView(TreeNode node, Map<Integer, Integer> res,int level) {
        if(node==null)
            return;

        if(!res.containsKey(level)){
            res.put(level,node.value);
        }

        leftView(node.left,res,level+1);
        leftView(node.right,res,level+1);
    }
}
