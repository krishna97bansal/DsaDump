package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@Service
public class PostOrderTraversalIterative {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        for (Integer integer : postOrderTraversalIterative(node)) {
            System.out.print(integer+" ");
        }
    }

    private List<Integer> postOrderTraversalIterative(TreeNode node) {
        List<Integer> result=new LinkedList<>();
        TreeNode temp =node;
        Stack<TreeNode> st=new Stack<>();
        while(temp!=null || !st.isEmpty()){
            if(temp!=null){
                st.add(temp);
                temp=temp.left;
            }
            else{
                TreeNode temp2=st.peek();
                if(temp2.right==null){
                    TreeNode out=st.pop();
                    result.add(out.value);
                    while(!st.isEmpty() && st.peek().right==out){
                        out=st.pop();
                        result.add(out.value);
                    }

                }
                else{
                    temp=temp2.right;
                }
            }

        }
        return result;
    }
}