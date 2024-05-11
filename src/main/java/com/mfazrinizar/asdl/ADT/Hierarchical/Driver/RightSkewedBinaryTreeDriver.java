package com.mfazrinizar.asdl.ADT.Hierarchical.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree.RightSkewedBinaryTree;

public class RightSkewedBinaryTreeDriver {
    public static void main(String[] args) {
        RightSkewedBinaryTree rightSkewedBinaryTree = new RightSkewedBinaryTree();
        rightSkewedBinaryTree.insert(new int[] { 1, 2, 3, 4, 5 });

        System.out.println("Pre-order traversal of the right skewed binary tree:");
        rightSkewedBinaryTree.printPreOrder(rightSkewedBinaryTree.getRoot());
        System.out.println();

        System.out.println("In-order traversal of the right skewed binary tree:");
        rightSkewedBinaryTree.printInOrder(rightSkewedBinaryTree.getRoot());
        System.out.println();

        System.out.println("Post-order traversal of the right skewed binary tree:");
        rightSkewedBinaryTree.printPostOrder(rightSkewedBinaryTree.getRoot());
        System.out.println();
    }

}
