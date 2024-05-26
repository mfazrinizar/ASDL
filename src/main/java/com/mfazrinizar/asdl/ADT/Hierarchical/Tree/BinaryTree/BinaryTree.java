package com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int value) {
        this.root = new TreeNode(value);
    }

    public BinaryTree(int[] values) {
        for (int value : values) {
            insert(this.root, value);
        }
    }

    public TreeNode insert(TreeNode node, char value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    public TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return this.root;
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

    public void printPreOrderChar(TreeNode curr) {
        if (curr != null) {
            System.out.print((char) curr.getValue() + " ");
            printPreOrderChar(curr.getLeft());
            printPreOrderChar(curr.getRight());
        }
    }

    public void printInOrderChar(TreeNode curr) {
        if (curr != null) {
            printInOrderChar(curr.getLeft());
            System.out.print((char) curr.getValue() + " ");
            printInOrderChar(curr.getRight());
        }
    }

    public void printPostOrderChar(TreeNode curr) {
        if (curr != null) {
            printPostOrderChar(curr.getLeft());
            printPostOrderChar(curr.getRight());
            System.out.print((char) curr.getValue() + " ");
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