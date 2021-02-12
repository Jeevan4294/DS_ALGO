package my.preparation.ds;

public class SinglyLinkedList<T> implements DataStructure<T> {

	public static void main(String[] args) {
		SinglyLinkedList<Object> sl = new SinglyLinkedList<Object>("1");
		sl.addElement("2");
		sl.addElement("3");
		sl.addElement("4");
		sl.addElement("5");
		sl.addElement("6");
		
		sl.traverse();
		System.out.println("Length: "+sl.getLenthg());
		
		System.out.println(sl.deleteElement("4"));
		System.out.println("Length: "+sl.getLenthg());
		
		sl.traverse();

		System.out.println(sl.deleteElement("1"));
		System.out.println("Length: "+sl.getLenthg());
		
		sl.traverse();

		System.out.println(sl.deleteElement("0"));
		System.out.println("Length: "+sl.getLenthg());
		
		sl.traverse();

		System.out.println(sl.getHead());

	}
	
	private Node<T> head;
	
	public Node<T> getHead() {
		return head;
	}

	public SinglyLinkedList(T data) {
		head = new Node<T>(data);
	}
	
	public void addElement(T data) {
		Node<T> tmp = head;
		head = new Node<T>(data);
		head.setNext(tmp);
	}
	
	public boolean deleteElement(T data) {
		boolean result = false;
		if (head == null) {
			return result;
		}
		if (data.equals(head.getData())) {
			head = head.getNext();
			return true;
		}
		Node<T> prev = head;
		Node<T> curr = head.getNext();
		while (curr != null) {
			if (data.equals(curr.getData())) {
				prev.setNext(curr.getNext());
				return true;
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
		
		return result;
	}
	
	public void traverse() {
		print(head);
	}
	
	private void print(Node<T> node) {
		if(node == null) { System.out.println(); return;}
		System.out.print(node.getData()+", ");
		print(node.getNext());
	}

	@Override
	public int getLenthg() {
		int len = -1;
		
		if(head==null) return len;
		
		len = 1;
		Node<T> tmp = head.getNext();
		while(tmp != null) {
			len++;
			tmp = tmp.getNext();
		}
		
		return len;
	}
	

	private class Node<T> {
	
		private Node<T> next;
		private T data; 
		
		public Node(T data) {
			setData(data);
		}
	
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return ""+data+"" ;
		}
	
	}
}

