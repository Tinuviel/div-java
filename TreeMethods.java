/**
 * 
 * @author Lovisa Colerus
 * 2016
 *
 */
public class TreeMethods {
	
	/**
	 * checks if two trees are equal
	 * @param root
	 * @param root2
	 * @return
	 */
	public static boolean equal(Node root, Node root2){
		if(root == root2){
			return true;
		}
		if(root == null || root2 == null){
			return false;
		}
		
		return ((root.value.equals(root2.value))&& equal(root.left, root2.left) && equal(root.right, root2.right));
		
	}
	
	/**
	 * returns the depth of the tree
	 * @param root
	 * @return
	 */
	public static int depth(Node root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
		
	}
	
	/**
	 * counts the number of leaves
	 * @param root
	 * @return
	 */
	public static int countLeaves(Node root){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}else{
			return countLeaves(root.right) + countLeaves(root.left);
		}		
	}
	
	
	/**
	 * copies a tree and returns the root of a tree
	 * @param root
	 * @return
	 */
	public static Node copyTree(Node root){
		Node left = null;
		Node right = null;
		if(root.left != null){
			left = copyTree(root.left);
		}
		if(root.right != null){
			right = copyTree(root.right);
		}
		Node n = new Node(root.value);
		n.left = left;
		n.right = right;
		return n;
	}
}
