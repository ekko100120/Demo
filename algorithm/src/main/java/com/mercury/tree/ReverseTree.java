package com.mercury.tree;

import java.util.Stack;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/5/18-13:27
 * @Description:
 * @return:
 */
// 翻转二叉树
public class ReverseTree<T> {

  //递归翻转
  public TreeNode<T> reverseRecusively(TreeNode<T> root){
    if (root==null){
      return null;
    }
    TreeNode<T> temp = root.left;
    root.setLeft(reverseRecusively(root.getRight()));
    root.setRight(reverseRecusively(temp));
    return root;
  }

  //非递归用栈[queue也可以]
  public TreeNode<T> reverse(TreeNode<T> root){
   if (root ==null){
     return null;
   }
   Stack<TreeNode<T>> stack = new Stack<>();
   stack.push(root);
   while (!stack.isEmpty()){
     TreeNode<T> parent = stack.pop();
     TreeNode<T> temp = parent.getLeft();
     parent.setLeft(parent.getRight());
     parent.setRight(temp);
     if (parent.left!=null){
       stack.push(parent.left);
       stack.push(parent.right);
     }

   }
   return root;
  }


  private static class TreeNode<T>{
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public TreeNode<T> getLeft() {
      return left;
    }

    public void setLeft(TreeNode<T> left) {
      this.left = left;
    }

    public TreeNode<T> getRight() {
      return right;
    }

    public void setRight(TreeNode<T> right) {
      this.right = right;
    }
  }
}
