import java.util.LinkedList;
import java.util.Queue;

public class Treeheight {
	public int treeHeight(Node root){
		if(root==null)
		{System.out.println("Inside if");
			return 0;
		}
		//System.out.println("height:"+Math.max(treeHeight(root.left),treeHeight(root.right)));
		int leftDepth=treeHeight(root.left);
		System.out.println("leftDepth:"+leftDepth);
		int rightDepth= treeHeight(root.right);
		System.out.println("rightDepth:"+rightDepth);
		return 1 + leftDepth + rightDepth;
		//return (leftDepth>rightDepth)?leftDepth+1:rightDepth+1;
	}
	public void print(int [] path, int pathLen){
		for(int i=0;i<pathLen;i++){
			System.out.print(path[i]+ "");
		}
		System.out.println();
	}
	public int minDepth(Node root)
	{
		if(root==null)
			return 0;
		Queue <Node> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		System.out.println("size of the queue:"+q.size());
		int count =1;
		int k=0;
		while(!q.isEmpty())
		{++k;
			Node currentNode = q.poll();
			System.out.println("if left is null:"+k);
			System.out.println("size of the queue:"+q.size());
			if(currentNode!=null)
			{
				if(currentNode.left==null&&currentNode.right==null)
				{
					System.out.println("k "+k);
					return count;
				}
				if(currentNode.left!=null)
				{
					System.out.println("left data:"+currentNode.left.data);
					q.offer(currentNode.left);
				}
				if(currentNode.right!=null)
				{
					System.out.println("right data:"+currentNode.right.data);
					q.offer(currentNode.right);
				}
			}
			else
			{
				System.out.println("Inside else condition");
				if(!q.isEmpty())
				{
					count++;
					q.offer(null);
				}
				
			}
		}
		return count;
	}
	public int getSize(Node root){
		if(root==null){
			return 0;
		}
		return 1 + getSize(root.left) + getSize(root.right);
	}
	public void printPaths(Node root, int [] path, int pathLen){
		if(root==null){
			return;
		}
		path[pathLen++]= root.data;
		if(root.left==null && root.right==null){
			print(path,pathLen);
		}
		else{
			printPaths(root.left,path,pathLen);
			printPaths(root.right,path,pathLen);
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.right.right=new Node(51);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.left.left.left =new Node(30);
		root.left.right.left = new Node(35);
		root.left.right.left.left = new Node(40);
		root.left.right.left.left.right = new Node(45);
			root.left.right.left.left.right.left = new Node(50);
			
		Treeheight i  = new Treeheight();
		int [] path = new int [100];
		i.printPaths(root, path, 0);
		int k=i.minDepth(root);
		System.out.println("min depth:"+k);
		//System.out.println(i.treeHeight(root));
		//System.out.println("Size of the Tree is : " + i.getSize(root));
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}