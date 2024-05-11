package com.mfazrinizar.asdl.ADT.Hierarchical.Driver;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.GeneralTree.GeneralTree;
import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.GeneralTree.TreeNode;

// Based on GFG General Tree Implementation

public class GeneralTreeDriver {
    public static void main(String[] args) {
            /*   Let us create below tree
             *              10
             *        /   /    \   \
             *        2  34    56   100
             *       / \         |   /  | \
             *      77  88       1   7  8  9
             */

        TreeNode<Integer> root = new TreeNode<>(10);
        root.addChild(new TreeNode<>(2));
        root.addChild(new TreeNode<>(34));
        root.addChild(new TreeNode<>(56));
        root.addChild(new TreeNode<>(100));
        root.children.getNodeAt(0).getValue().addChild(new TreeNode<>(77));
        root.children.getNodeAt(0).getValue().addChild(new TreeNode<>(88));
        root.children.getNodeAt(2).getValue().addChild(new TreeNode<>(1));
        root.children.getNodeAt(3).getValue().addChild(new TreeNode<>(7));
        root.children.getNodeAt(3).getValue().addChild(new TreeNode<>(8));
        root.children.getNodeAt(3).getValue().addChild(new TreeNode<>(9));

        System.out.println("Level order traversal Before Mirroring");
        GeneralTree.levelOrderTraversal(root);
    }
}
