package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

@Service
public class ZigZagTraversal {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        zigzagTraversal(node);
    }

    private void zigzagTraversal(TreeNode node) {
        List<Integer> result=new LinkedList<>();

        boolean rightToLeft=true;
        Stack<TreeNode> current=new Stack<>();
        Stack<TreeNode> next=new Stack<>();

        current.add(node);
        while(!current.isEmpty()){

            TreeNode temp=current.pop();
            result.add(temp.value);
            if(rightToLeft){
                if(temp.left!=null){
                    next.add(temp.left);
                }
                if(temp.right!=null){
                    next.add(temp.right);
                }
            }
            else{
                if(temp.right!=null){
                    next.add(temp.right);
                }
                if(temp.left!=null){
                    next.add(temp.left);
                }
            }
            if(current.isEmpty()){
                current=next;
                next=new Stack<>();
                rightToLeft=!rightToLeft;
            }
        }
        result.forEach(i->System.out.println(i+" "));
    }
}
