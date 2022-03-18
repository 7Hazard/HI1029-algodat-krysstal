package ten1606;

public class BinarySearchTree<E extends Comparable<E>> {
	
	private static class Node<E>{
		private E data;
		private Node<E> left,right;
		private Node(E d){
			data=d;
			left=right=null;
		}
		@Override
		public String toString(){
			return data.toString();
		}
	}
	
	private Node<E> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	private void inOrder(Node<E> node, StringBuilder sb){
		if(node!=null){
			inOrder(node.left, sb);
			sb.append(node.toString()+" ");
			inOrder(node.right, sb);
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		inOrder(root,sb);
		return sb.toString();
	}
	private boolean add(E data,Node<E> node){
		if(data.compareTo(node.data)==0)
			return false;
		else if(data.compareTo(node.data)<0)
			if(node.left==null){
				node.left = new Node<E>(data);
				return true;
			}else
				return add(data,node.left);
		else
			if(node.right==null){
				node.right = new Node<E>(data);
				return true;
			}else
				return add(data,node.right);
	}
	public boolean add(E data){
		if(root==null){
			root = new Node<E>(data);
			return true;
		}else{
			return add(data,root);	
		}
	}

	public void reverse() {
		reverse(root);
	}

	private void reverse(Node node) {
		if(node == null) return;
		var left = node.left;
		node.left = node.right;
		node.right = left;
		reverse(node.left);
		reverse(node.right);
	}
		
}