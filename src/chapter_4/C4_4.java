package chapter_4;

import linkedlist.LinkedList;
import tree.BSearchTree;
import tree.TreeNode;

import java.util.ArrayList;

public class C4_4 {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    BSearchTree bSearchTree = new BSearchTree(array);

    System.out.println(insertLinkedList(bSearchTree.root));
  }

  private static ArrayList<LinkedList<TreeNode>> insertLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    LinkedList<TreeNode> list = new LinkedList<>();

    list.addFirst(root);

    while(!list.isEmpty()) {
      lists.add(list);

      LinkedList<TreeNode> parents = list;
      list = new LinkedList<>();

      for(TreeNode parent : parents) {
        if(parent.leftChild != null) {
          list.addLast(parent.leftChild);
        }

        if(parent.rightChild != null) {
          list.addLast(parent.rightChild);
        }
      }
    }

    return lists;
  }
}