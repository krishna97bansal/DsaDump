package com.dsa.DSADump.tree.traversals;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Points to Remember:
1. In level order traversal we do simple BFS at each level.
 */
@Service
public class LevelOrderTraversal {
    public void driver(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);

        for (List<Integer> integer : inOrderTraversal(node)) {
            System.out.print(integer+" ");
        }
    }

    private List<List<Integer>> inOrderTraversal(TreeNode node) {
        List<List<Integer>> result=new LinkedList<>();
        if(node==null){
            return result;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            int size = q.size();           // This size is to maintain nodes count at each level.
            result.add(new LinkedList<>());
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                result.get(result.size()-1).add(temp.value);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return result;
    }
}
