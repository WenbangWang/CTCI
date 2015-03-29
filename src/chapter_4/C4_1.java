package chapter_4;

import tree.*;

public class C4_1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private static int checkHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = checkHeight(node.leftChild);
        if (leftHeight == -1)
            return -1;
        int rightHeight = checkHeight(node.rightChild);
        if (rightHeight == -1)
            return -1;
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalance(TreeNode root) {
        if (checkHeight(root) == -1)
            return false;
        else
            return true;
    }

}
