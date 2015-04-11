package chapter_4;

import tree.BSearchTree;
import tree.TreeNode;

/**
 * Given a sorted array, build a BST with minimal height
 */
public class C4_3 {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    BSearchTree bSearchTree = new BSearchTree(array);

    bSearchTree.inOrder(bSearchTree.root);
  }

  public void buildBST(int[] array, TreeNode node, int start, int end) {
    if(start > end) {
      return;
    }

    int mid = (start + end) / 2;
    node.data = array[mid];

    if(start <= mid - 1) {
      node.leftChild = new TreeNode();
    }
    buildBST(array, node.leftChild, start, mid - 1);

    if(end >= mid + 1) {
      node.rightChild = new TreeNode();
    }
    buildBST(array, node.rightChild, mid + 1, end);
  }
}