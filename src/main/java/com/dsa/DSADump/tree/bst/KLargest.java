package com.dsa.DSADump.tree.bst;

import com.dsa.DSADump.tree.TreeNode;

public class KLargest {
    public void driver() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);
        int a[] = new int[1];
        a[0] = 6;

        System.out.println(klargest(root, a).value);
    }

    private TreeNode klargest(TreeNode root, int a[]) {
        if (root == null) {
            return null;
        }

        TreeNode right = klargest(root.right, a);
        if (right != null) {
            return right;
        }
        a[0]--;
        if (a[0] == 0) {
            return root;
        }
        return klargest(root.left, a);
    }
}