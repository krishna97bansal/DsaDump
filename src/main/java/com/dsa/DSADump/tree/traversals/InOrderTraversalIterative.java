package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
/*
Points to Remember:
 */
@Service
public class InOrderTraversalIterative {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        for (Integer integer : preOrderTraversalIterative(node)) {
            System.out.print(integer+" ");
        }
    }

    private List<Integer> preOrderTraversalIterative(TreeNode node) {
        List<Integer> result=new LinkedList<>();
        if(node==null){
            return result;
        }

        Stack<TreeNode> st=new Stack<>();
        TreeNode temp=node;
        while(true){
            if(temp!=null){
                st.add(temp);
                temp=temp.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                else{
                    TreeNode temp2=st.pop();
                    result.add(temp2.value);
                    temp=temp2.right;
                }
            }
        }
        return result;
    }
}
