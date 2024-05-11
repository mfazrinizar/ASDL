package com.mfazrinizar.asdl.ADT.Hierarchical.Driver;

import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree.BinaryTree;
import com.mfazrinizar.asdl.ADT.Hierarchical.Tree.BinaryTree.TreeNode;


public class BinaryTreeDriver {
    public static void main(String[] args) {
        testFirstTree();
        testSecondTree();
        testThirdTree();
    }

    public static void testFirstTree() {
        BinaryTree bt = new BinaryTree();
        TreeNode root = new TreeNode(1);
        bt.addLeft(null, 1); 
        bt.addLeft(root, 2);
        bt.addRight(root, 3);

        System.out.println("Pre-order traversal:");
        bt.printPreOrder(root);
        System.out.println("\nIn-order traversal:");
        bt.printInOrder(root);
        System.out.println("\nPost-order traversal:");
        bt.printPostOrder(root);

        System.out.println("\nNumber of nodes: " + bt.jumlahNode(root));
        System.out.println("Number of leaves: " + bt.jumlahDaun(root));
        System.out.println("Height of tree: " + bt.height(root));
    }

    public static void testSecondTree() {
        BinaryTree bt2 = new BinaryTree(new int[] {1, 2, 3, 4, 5});

        System.out.println("\nPre-order traversal of second tree:");
        bt2.printPreOrder(bt2.getRoot());
        System.out.println("\nIn-order traversal of second tree:");
        bt2.printInOrder(bt2.getRoot());
        System.out.println("\nPost-order traversal of second tree:");
        bt2.printPostOrder(bt2.getRoot());

        System.out.println("\nNumber of nodes in second tree: " + bt2.jumlahNode(bt2.getRoot()));
        System.out.println("Number of leaves in second tree: " + bt2.jumlahDaun(bt2.getRoot()));
        System.out.println("Height of second tree: " + bt2.height(bt2.getRoot()));
    }

    public static void testThirdTree() {
        BinaryTree bt3 = new BinaryTree();
        String input = "JHDBGMIKACFL";
        for (char c : input.toCharArray()) {
            bt3.setRoot(bt3.insert(bt3.getRoot(), c));
        }

        System.out.println("\nPre-order traversal of third tree:");
        bt3.printPreOrderChar(bt3.getRoot());
        System.out.println("\nIn-order traversal of third tree:");
        bt3.printInOrderChar(bt3.getRoot());
        System.out.println("\nPost-order traversal of third tree:");
        bt3.printPostOrderChar(bt3.getRoot());
    }
}