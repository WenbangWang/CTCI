package chapter_4;

import tree.TreeNode;

public class C4_9 {

  public static void main(String[] args) {

  }


  private void findPath(int[] array, TreeNode node, int level, int sum) {
    int data = 0;

    if(node == null) {
      return;
    }

    array[level] = node.data;

    for(int i = 0; i < level; i++) {
      data += array[i];

      if(data == sum) {
        System.out.println("yoyoyo");
      }
    }

    findPath(array, node.leftChild, level + 1, sum);
    findPath(array, node.rightChild, level + 1, sum);
  }

  private int getDepth(TreeNode node) {
    if(node == null) {
      return 0;
    }

    return 1 + Math.max(getDepth(node.leftChild), getDepth(node.rightChild));
  }
}