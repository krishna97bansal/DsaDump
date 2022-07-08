package com.dsa.DSADump.tree.views;

import com.dsa.DSADump.tree.TreeNode;
import com.sun.source.tree.Tree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VerticaView {

    public void driver(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<List<Integer>> res=new LinkedList<>();

        verticalView(root,res);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    private void verticalView(TreeNode root,List<List<Integer>> res) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> ts=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));

        while(!q.isEmpty()) {
            Tuple temp = q.poll();
            int vertical = temp.vertical;
            int level = temp.level;

            if (!ts.containsKey(vertical))
                ts.put(vertical, new TreeMap<>());
            if (!ts.get(vertical).containsKey(level))
                ts.get(vertical).put(level, new PriorityQueue<>());

            ts.get(vertical).get(level).add(temp.node.value);

            if (temp.node.left != null) {
                q.add(new Tuple(temp.node.left, vertical - 1, level + 1));
            }
            if (temp.node.right != null) {
                q.add(new Tuple(temp.node.right, vertical + 1, level + 1));
            }

        }

        for(TreeMap<Integer, PriorityQueue<Integer>> result: ts.values()){
            res.add(new LinkedList<>());
            for(PriorityQueue<Integer> pq: result.values()){
                while(!pq.isEmpty()){
                    res.get(res.size()-1).add(pq.poll());
                }
            }
        }
    }
}
class Tuple{
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
