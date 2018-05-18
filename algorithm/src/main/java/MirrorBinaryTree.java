import java.util.Stack;

/**
 * @discreption : 给定二叉树的左右翻转问题[递归和非递归]
 * @param :
 * @author: 62083 [411316753@qq.com]
 * @Date: 2018/4/16-11:02
 * @Description:
 * @return:
 */
public class MirrorBinaryTree {

  private TreeNode root;

  public MirrorBinaryTree(TreeNode node) {
    this.root =node;
  }
  //二叉树左右交换
  public void  mirror(){
     mirrorTree(root);
  }

  //非递归
  public void  mirrorTree(TreeNode node){
    if (node==null){
      return;
    }
    if (node.left==null&&node.right==null){
      return ;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()){
        TreeNode parent = stack.pop();
        TreeNode temp = parent.left;
        parent.right=temp;
        if (parent.left!=null){
          stack.push(parent.left);
        }
        if (parent.right!=null){
          stack.push(parent.right);
        }

    }
  }

  private static class  TreeNode{
     int value;
     TreeNode left;
     TreeNode right;

    public TreeNode(int value) {
      this.value = value;
      this.left=null;
      this.right=null;

    }
  }

}
