import java.util.*;
public class Tree 
{
	private class Node
	{
		private int val;
		private Node left = null;
		private Node right = null;
		private Node mid = null;
		public Node(int val) 
		{
			this.val = val;
		}
	}
	private Node root;
	public List<Integer> node_list = new ArrayList<>();
	public void insert(int val) 
	{
		Queue<Node> node_list = new LinkedList<>();
		if(root == null)
		{
			root = new Node(val);
			return;
		}
		else node_list.add(root);
		while(node_list.isEmpty()!= true)
		{
			Node popped_node = node_list.poll();
			if(val < popped_node.val && popped_node.left!= null )
			{
				node_list.add(popped_node.left);
				continue;
			}
			else if(val < popped_node.val && popped_node.left== null)
			{
				//System.out.println("Making "+ val + " left child of "+ popped_node.val);
				popped_node.left = new Node(val); break;}
			if(val > popped_node.val && popped_node.right!= null)
			{
				node_list.add(popped_node.right); continue;
			}
			else if(val > popped_node.val && popped_node.right== null)
			{
				//System.out.println("Making "+ val + " right child of "+ popped_node.val);
				popped_node.right = new Node(val); break;}
			if(val == popped_node.val && popped_node.mid!= null)
			{
				node_list.add(popped_node.mid); continue;
			}
			else if(val == popped_node.val && popped_node.mid== null)
			{
				//System.out.println("Making "+ val + " mid child of "+ popped_node.val);
				popped_node.mid = new Node(val); break; }
		}
	}
	public void traverse_tree(Node root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			//System.out.println(root.val);
			node_list.add(root.val);
			traverse_tree(root.left);
			traverse_tree(root.mid);
			traverse_tree(root.right);
		}
	}
	public void delete1(int val) 
	{
		root = delete_function(root, val);
	}
	public Node delete_function(Node root, int val) 
	{
		if(root== null)
		{
			return root;
		}
		if(val < root.val)
		{
			root.left = delete_function(root.left, val);
		}
		else if(val > root.val)
		{
			root.right = delete_function(root.right, val);
		}
		else
		{
			// taking care of 1 child or no child scenarios
			if(root.left == null && root.mid == null)
			{
				return root.right;
			}
			else if(root.left == null && root.right == null)
			{
				return root.mid;
			}
			else if(root.mid == null && root.right == null)
			{
				return root.left;
			}
			// taking care of 1 child or no child scenarios
			if(root.right!= null && root.left!= null && root.mid== null)
			{
				root.val = method_call(root.right);
				root.right = delete_function(root.right, root.val);
			}
			else if(root.mid!= null && root.right!= null && root.left== null)
			{
				root.mid = delete_function(root.mid, root.val);
			}
			else if(root.mid!= null && root.right!= null && root.right== null)
			{
				root.mid = delete_function(root.mid, root.val);
			}
			else if(root.mid!= null && root.right!= null && root.right!= null)
			{
				root.mid = delete_function(root.mid, root.val);
			}
		}
		return root;
	}
	public int method_call(Node root) 
	{
		int minv = root.val;
        while (root.left != null)
        {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
	}
	public static void main(String[] args)
	{
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(11);
		tree.insert(7);
		tree.insert(9);
		tree.insert(10);
		tree.insert(10);
		tree.traverse_tree(tree.root);
		System.out.println(tree.node_list.toString());
		tree.node_list.clear();
		//tree.delete1(11);
		tree.delete1(8);
		tree.delete1(10);
		tree.traverse_tree(tree.root);
		System.out.println(tree.node_list.toString());
	}
}
