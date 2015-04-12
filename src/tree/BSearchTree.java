package tree;

public class BSearchTree {

  public TreeNode root;

  public BSearchTree() {
    this.root = new TreeNode();
  }

  public BSearchTree(int[] array) {
    this.root = new TreeNode();
    this.buildTree(array, this.root, 0, array.length - 1);
  }

  public TreeNode find(int key) {
    TreeNode current = root;

    while (current.data != key) {
      if (key < current.data) {
        current = current.leftChild;
      } else {
        current = current.rightChild;
      }

      if (current == null) {
        return null;
      }
    }
    return current;
  }

  public void insert(int key) {
    TreeNode node = new TreeNode();
    node.data = key;

    if (root == null) {
      root = node;
    } else {
      TreeNode current = root;
      TreeNode parent;

      while (true) {
        parent = current;

        if (key < current.data) {
          current = current.leftChild;

          if (current == null) {
            parent.leftChild = current;
            return;
          }
        } else {
          current = current.rightChild;

          if (current == null) {
            parent.rightChild = current;
            return;
          }
        }
      }
    }
  }

  public boolean delete(int key) {
    TreeNode current = root;
    TreeNode parent = root;
    boolean isLeftChild = true;

    while (current.data != key) {
      parent = current;
      if (key < current.data) {
        isLeftChild = true;
        current = current.leftChild;
      } else {
        isLeftChild = false;
        current = current.rightChild;
      }
      if (current == null)
        return false;
    }

    if (current.leftChild == null && current.rightChild == null) {
      if (current == root)
        root = null;
      else if (isLeftChild)
        parent.leftChild = null;
      else
        parent.rightChild = null;
    } else if (current.rightChild == null) {
      if (current == root)
        root = current.leftChild;
      else if (isLeftChild)
        parent.leftChild = current.leftChild;
      else
        parent.rightChild = current.leftChild;
    } else if (current.leftChild == null) {
      if (current == root)
        root = current.leftChild;
      else if (isLeftChild)
        parent.leftChild = current.rightChild;
      else
        parent.rightChild = current.rightChild;
    } else {
      TreeNode successor = getSuccessor(current);
      if (current == root)
        root = successor;
      else if (isLeftChild)
        parent.leftChild = successor;
      else
        parent.rightChild = successor;
      successor.leftChild = current.leftChild;
    }
    return true;
  }

  private TreeNode getSuccessor(TreeNode node) {
    TreeNode successorParent = node;
    TreeNode successor = node;
    TreeNode current = node.rightChild;

    while (current != null) {
      successorParent = successor;
      successor = current;
      current = current.leftChild;
    }

    if (successor != node.rightChild) {
      successorParent.leftChild = successor.rightChild;
      successor.rightChild = node.rightChild;
    }
    return successor;
  }

  public void preOrder(TreeNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
      preOrder(node.leftChild);
      preOrder(node.rightChild);

    }
  }

  public void inOrder(TreeNode node) {
    if (node != null) {
      inOrder(node.leftChild);
      System.out.print(node.data + " ");
      inOrder(node.rightChild);
    }
  }

  public void postOrder(TreeNode node) {
    if (node != null) {
      postOrder(node.leftChild);
      postOrder(node.rightChild);
      System.out.println(node.data + " ");
    }
  }

  private void buildTree(int[] array, TreeNode node, int start, int end) {
    int mid;

    if(start > end) {
      return;
    }

    mid = (start + end) / 2;
    node.data = array[mid];

    if(start <= mid - 1) {
      node.leftChild = new TreeNode();
    }
    this.buildTree(array, node.leftChild, start, mid - 1);

    if(end >= mid + 1) {
      node.rightChild = new TreeNode();
    }
    this.buildTree(array, node.rightChild, mid + 1, end);
  }
}
