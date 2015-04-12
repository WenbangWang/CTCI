package chapter_4;

import tree.TreeNode;

/**
 * Check if a tree is a BST
 */
public class C4_5 {

  public static void main(String[] args) {

  }

  public boolean isBST(TreeNode node) {
    if(node == null) {
      return true;
    }

    if(node.leftChild != null && node.leftChild.data >= node.data) {
      return false;
    }

    if(node.rightChild != null && node.rightChild.data < node.data) {
      return false;
    }

    return isBST(node.leftChild) && isBST(node.rightChild);
  }

  public boolean checkBST(TreeNode node, int min, int max) {
    if(node == null) {
      return true;
    }

    if(node.data >= min || node.data < max) {
      return false;
    }

    return checkBST(node.leftChild, min, node.data) && checkBST(node.rightChild, node.data, max);
  }
}