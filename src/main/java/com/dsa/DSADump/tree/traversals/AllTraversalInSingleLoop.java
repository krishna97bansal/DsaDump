package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

@Service
public class AllTraversalInSingleLoop {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        allTraversals(node);

    }

    private void allTraversals(TreeNode node) {
        Stack<All> st=new Stack<>();
        List<Integer> pre=new LinkedList<>();
        List<Integer> in=new LinkedList<>();
        List<Integer> post=new LinkedList<>();
        st.add(new All(node,1));

        while(!st.isEmpty()){
            All temp=st.pop();

            if(temp.value==1){
                pre.add(temp.node.value);
                temp.value++;
                st.add(temp);
                if(temp.node.left!=null){
                    st.add(new All(temp.node.left,1));
                }
            }

            else if(temp.value==2){
                in.add(temp.node.value);
                temp.value++;
                st.add(temp);
                if(temp.node.right!=null){
                    st.add(new All(temp.node.right,1));
                }
            }
            else{
                post.add(temp.node.value);
            }

        }

        for (Integer integer : pre) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer integer : in) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer integer : post) {
            System.out.print(integer+" ");
        }
    }
}
class All{
    TreeNode node;
    int value;

    public All(TreeNode node, int value) {
        this.node = node;
        this.value = value;
    }
}