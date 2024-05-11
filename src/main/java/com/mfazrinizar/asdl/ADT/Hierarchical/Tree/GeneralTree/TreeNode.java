package com.mfazrinizar.asdl.ADT.Hierarchical.Tree.GeneralTree;

/*
 * Author       : M. Fazri Nizar
 * Institution  : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

import com.mfazrinizar.asdl.ADT.Linear.LinkedList.Doubly.GenericLinkedList;

public class TreeNode<T> {
    public T key;
    public GenericLinkedList<TreeNode<T>> children;

    public TreeNode(T key) {
        this.key = key;
        this.children = new GenericLinkedList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.children.append(child);
    }
}