package com.mfazrinizar.asdl.ADT.Hierarchical.Tree.GeneralTree;

import com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly.GenericLinkedList;
import com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly.GenericNode;

public class GeneralTree {
    public static void levelOrderTraversal(TreeNode<Integer> root) {
        if (root == null)
            return;

        GenericLinkedList<TreeNode<Integer>> queue = new GenericLinkedList<>();
        queue.append(root);
        while (queue.size() > 0) {
            int n = queue.size();

            while (n > 0) {
                TreeNode<Integer> p = queue.deleteFirst().getValue();

                System.out.print(p.key + " ");

                GenericNode<TreeNode<Integer>> childNode = p.children.getNodeAt(0);
                while (childNode != null) {
                    queue.append(childNode.getValue());
                    childNode = childNode.getNext();
                }
                n--;
            }

            System.out.println();
        }
    }
}