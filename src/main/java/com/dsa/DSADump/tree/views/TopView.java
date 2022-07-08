package com.dsa.DSADump.tree.views;

import com.dsa.DSADump.tree.TreeNode;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TopView { public void driver(){
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

    topView(root,res);
    for (Integer re : res) {
        System.out.println(re);
    }
}

    private void topView(TreeNode root, List<Integer> res) {
        TreeMap<Integer,Integer> ts=new TreeMap<>();
        Queue<TopTuple> q=new LinkedList<>();
        q.add(new TopTuple(root,0));

        while(!q.isEmpty()) {
            TopTuple temp = q.poll();
            int vertical = temp.vertical;

            if (!ts.containsKey(vertical))
                ts.put(vertical,temp.node.value);

            if (temp.node.left != null) {
                q.add(new TopTuple(temp.node.left, vertical - 1));
            }
            if (temp.node.right != null) {
                q.add(new TopTuple(temp.node.right, vertical + 1));
            }

        }
        for (Map.Entry<Integer,Integer> entry : ts.entrySet()) {
            res.add(entry.getValue());
        }

    }
}
class TopTuple{
    TreeNode node;
    int vertical;

    public TopTuple(TreeNode node, int vertical) {
        this.node = node;
        this.vertical = vertical;
    }
}

