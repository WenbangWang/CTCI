package chapter_4;

import tree.TreeNode;

/**
 * Check whether a BST is balanced.
 */
public class C4_1 {

  public int checkHeight(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int leftHeight = checkHeight(node.leftChild);
    if(leftHeight == -1) {
      return -1;
    }

    int rightHeight = checkHeight(node.rightChild);
    if(rightHeight == -1) {
      return -1;
    }

    int heightDiff = leftHeight - rightHeight;
    if(Math.abs(heightDiff) > 1) {
      return -1;
    }

    return Math.max(leftHeight, heightDiff) + 1;
  }
}