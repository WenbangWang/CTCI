package tree;

public class TreeNode {
	
	public int data;
	public TreeNode leftChild;
	public TreeNode rightChild;
	
	public TreeNode(int t)
	{
		data = t;
	}
	
	public TreeNode()
	{
		
	}
	
	public void display()
	{
		System.out.print("{" + data + "}");
	}

}
