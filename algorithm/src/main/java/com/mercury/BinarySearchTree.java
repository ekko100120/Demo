package com.mercury;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *定义每个节点的键值大于左孩子, 小于右孩子的二叉树
 */
public class BinarySearchTree {

    private TreeNode root;
    int count;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }

    /*递归插入*/
    private TreeNode insert(TreeNode node,int value){
        if (node==null){
            return  new TreeNode(value);
        }
        if (value==node.data){
            return  node;
        }
        if (value<node.data){
            node.left =insert(node.left,value);
        }else {
            node.right=insert(node.right,value);
        }
        return node;
    }
    //非递归插入节点
    private TreeNode insertNotRecusive(TreeNode node,int value){
        TreeNode treeNode = node;
        TreeNode indexNode = node;

        while (node==null){
            if (node.data==value){
                return node;
            }
            treeNode =indexNode;
            if (node.data>value){
                indexNode =indexNode.left;
            }else {
                indexNode =indexNode.right;
            }
            if (treeNode==null){
                treeNode = new TreeNode(value);
            }
            if (treeNode.data>value){
                treeNode.left = new TreeNode(value);
            }
            if (treeNode.data>=value) {
                treeNode.right = new TreeNode((value));
            }

        }
        return treeNode;
    }
    //二叉搜索树查找
    boolean search(int value){
       return search(root,value);
    }

    private boolean search(TreeNode node, int value) {
        if (node==null){
            return false;
        }
        if (value<node.data){
            return  search(node.left,value);
        }else {
            return  search(node.right,value);
        }
    }
    //前序遍历
    public  void preOrder(){
        preOrder(root);
    }
    private void preOrder(TreeNode node){
        if (node!=null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

    }
    //中序遍历
    public  void  inOrder(){
        inOrder(root);
    }
    private void inOrder(TreeNode node){
        if (node!=null){
            preOrder(node.left);
            System.out.println(node.data);
            preOrder(node.right);
        }

    }

    //后续遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(TreeNode node){
        if (node!=null){
            preOrder(node.left);
            System.out.println(node.data);
            preOrder(node.right);
        }

    }
    public void levelOrder(){
        LinkedList<TreeNode>  list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()){
            TreeNode treeNode = list.peek();
            list.poll();
            System.out.println(treeNode.data);
            if (treeNode.left!=null){
                list.offer(treeNode.left);
            }
            if (treeNode.right!=null){
                list.offer(treeNode.right);
            }
        }
    }
    //删除为value的节点
    public TreeNode delete(TreeNode treeNode,int value){
        //TODO
        return null;
    }

    public void insert(int value){
        insert(root,value);
    }

    private static class TreeNode{
        private int data;
        private  TreeNode left;
        private  TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
