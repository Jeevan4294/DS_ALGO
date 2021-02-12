package my.preparation.ds;

public class Tree<T>  implements DataStructure<T>  {

	public static void main(String[] args) {
		
		Tree<Object> tree = new Tree<Object>("1");
		
		tree.getRoot().setLeft(new Node<Object>("2"));
		tree.getRoot().setRight(new Node<Object>("3"));
		tree.getRoot().getLeft().setLeft(new Node<Object>("4"));
		tree.getRoot().getLeft().setRight(new Node<Object>("5"));
		tree.getRoot().getRight().setLeft(new Node<Object>("6"));
		tree.getRoot().getRight().setRight(new Node<Object>("7"));
		
		
	}

	private Node<T> root;

	public Tree (T data) {
		this.root = new Node<T>(data);
	}
	
	@Override
	public boolean deleteElement(T data) {
		return false;
	}

	@Override
	public void addElement(T data) {
		Node<T> node = new Node<T>(data);
		add(node);		
	}

	private void add(Node<T> node) {
		if(root == null) {
			root = node;
			return;
		}
	}

	@Override
	public void traverse() {
		
	}

	@Override
	public int getLenthg() {
		return 0;
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	private static class Node<T> {
		
		private Node<T> left;
		private Node<T> right;
		private T data;
		
		public Node (T data) {
			this.data = data;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

}
