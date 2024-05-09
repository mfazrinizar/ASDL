package com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree;

import java.util.List;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(List<Integer> values) {
        for (int value : values) {
            addLeft(this.root, value);
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isOneEl() {
        return this.root != null && this.root.getLeft() == null && this.root.getRight() == null;
    }

    public boolean isLeaf(TreeNode N) {
        return N != null && N.getLeft() == null && N.getRight() == null;
    }

    public boolean isUnerLeft(TreeNode N) {
        return N != null && N.getLeft() != null && N.getRight() == null;
    }

    public boolean isUnerRight(TreeNode N) {
        return N != null && N.getLeft() == null && N.getRight() != null;
    }

    public boolean addLeft(TreeNode parent, int value) {
        if (parent == null) {
            this.root = new TreeNode(value);
            return true;
        } else if (parent.getLeft() == null) {
            parent.setLeft(new TreeNode(value));
            return true;
        }
        return false;
    }

    public boolean addRight(TreeNode parent, int value) {
        if (parent == null) {
            this.root = new TreeNode(value);
            return true;
        } else if (parent.getRight() == null) {
            parent.setRight(new TreeNode(value));
            return true;
        }
        return false;
    }

    public TreeNode deleteRight(TreeNode N) {
        if (N != null && N.getRight() != null) {
            TreeNode rightNode = N.getRight();
            N.setRight(null);
            return rightNode;
        }
        return null;
    }

    public TreeNode deleteLeft(TreeNode N) {
        if (N != null && N.getLeft() != null) {
            TreeNode leftNode = N.getLeft();
            N.setLeft(null);
            return leftNode;
        }
        return null;
    }

    public void printPreOrder(TreeNode curr) {
        if (curr != null) {
            System.out.print(curr.getValue() + " ");
            printPreOrder(curr.getLeft());
            printPreOrder(curr.getRight());
        }
    }

    public void printInOrder(TreeNode curr) {
        if (curr != null) {
            printInOrder(curr.getLeft());
            System.out.print(curr.getValue() + " ");
            printInOrder(curr.getRight());
        }
    }

    public void printPostOrder(TreeNode curr) {
        if (curr != null) {
            printPostOrder(curr.getLeft());
            printPostOrder(curr.getRight());
            System.out.print(curr.getValue() + " ");
        }
    }

    public int jumlahNode(TreeNode curr) {
        if (curr == null) {
            return 0;
        } else {
            return 1 + jumlahNode(curr.getLeft()) + jumlahNode(curr.getRight());
        }
    }

    public int jumlahDaun(TreeNode curr) {
        if (curr == null) {
            return 0;
        } else if (isLeaf(curr)) {
            return 1;
        } else {
            return jumlahDaun(curr.getLeft()) + jumlahDaun(curr.getRight());
        }
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}