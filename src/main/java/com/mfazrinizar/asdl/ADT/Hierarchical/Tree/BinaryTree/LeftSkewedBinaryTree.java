package com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

public class LeftSkewedBinaryTree {
    private TreeNode root;

    public LeftSkewedBinaryTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public void insert(int[] values) {
        for (int value : values) {
            this.root = insert(this.root, value);
        }
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        node.setLeft(insert(node.getLeft(), value));

        return node;
    }

    public void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    public void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    public void printPostOrder(TreeNode node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}