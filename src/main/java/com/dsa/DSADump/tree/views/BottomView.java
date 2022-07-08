package com.dsa.DSADump.tree.views;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BottomView {public void driver(){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(10);

    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(10);

    root.left.left.right = new TreeNode(5);
    root.left.left.right.right = new TreeNode(6);

    List<Integer> res=new LinkedList<>();

    bottomView(root,res);
    for (Integer re : res) {
        System.out.println(re);
    }
}

    private void bottomView(TreeNode root, List<Integer> res) {
        TreeMap<Integer,Integer> ts=new TreeMap<>();
        Queue<BottomTuple> q=new LinkedList<>();
        q.add(new BottomTuple(root,0));

        while(!q.isEmpty()) {
            BottomTuple temp = q.poll();
            int vertical = temp.vertical;

            ts.put(vertical,temp.node.value);

            if (temp.node.left != null) {
                q.add(new BottomTuple(temp.node.left, vertical - 1));
            }
            if (temp.node.right != null) {
                q.add(new BottomTuple(temp.node.right, vertical + 1));
            }

        }
        for (Map.Entry<Integer,Integer> entry : ts.entrySet()) {
            res.add(entry.getValue());
        }

    }
}
class  BottomTuple{
    TreeNode node;
    int vertical;

    public BottomTuple(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}
