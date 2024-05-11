package com.mfazrinizar.asdl.ADT.Hierarchical.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree.LeftSkewedBinaryTree;

public class LeftSkewedBinaryTreeDriver {
    public static void main(String[] args) {
        LeftSkewedBinaryTree leftSkewedBinaryTree = new LeftSkewedBinaryTree();
        leftSkewedBinaryTree.insert(new int[]{1, 2, 3, 4, 5});

        System.out.println("Pre-order traversal of the left skewed binary tree:");
        leftSkewedBinaryTree.printPreOrder(leftSkewedBinaryTree.getRoot());
        System.out.println();

        System.out.println("In-order traversal of the left skewed binary tree:");
        leftSkewedBinaryTree.printInOrder(leftSkewedBinaryTree.getRoot());
        System.out.println();

        System.out.println("Post-order traversal of the left skewed binary tree:");
        leftSkewedBinaryTree.printPostOrder(leftSkewedBinaryTree.getRoot());
        System.out.println();
    }
}
