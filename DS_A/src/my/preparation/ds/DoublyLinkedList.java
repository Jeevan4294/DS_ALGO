package my.preparation.ds;

public class DoublyLinkedList<T> implements DataStructure<T> {

	public static void main(String[] args) {
		DoublyLinkedList<Object> dl = new DoublyLinkedList<Object>("1");
		dl.addElement("2");
		dl.addElement("3");
		dl.addElement("4");
		dl.addElement("5");
		dl.addElement("6");
		
		dl.traverse();
		dl.revreseTraverse();
		System.out.println("Length: "+dl.getLenthg());
		
		System.out.println(dl.deleteElement("4"));
		
		dl.traverse();
		dl.revreseTraverse();
		
		System.out.println("Length: "+dl.getLenthg());
		System.out.println(dl.deleteElement("1"));
		
		dl.traverse();
		dl.revreseTraverse();
		System.out.println("Length: "+dl.getLenthg());

		System.out.println(dl.deleteElement("2"));
		System.out.println(dl.deleteElement("3"));
		System.out.println(dl.deleteElement("5"));
		System.out.println(dl.deleteElement("6"));
		
		dl.traverse();
		dl.revreseTraverse();
		System.out.println("Length: "+dl.getLenthg());

		System.out.println(dl.deleteElement("0"));
		
		dl.traverse();
		dl.revreseTraverse();
		System.out.println("Length: "+dl.getLenthg());

		System.out.println("Head: "+dl.getHead());
		System.out.println("Tail: "+dl.getTail());
		
		

	}
	
	private Node<T> head;
	private Node<T> tail;
	
	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getHead() {
		return head;
	}

	public DoublyLinkedList(T data) {
		head = new Node<T>(data);
		tail = head;
	}
	
	public void addElement(T data) {
		Node<T> tmp = head;
		head = new Node<T>(data);
		head.setNext(tmp);
		tmp.setPrev(head); //Specific for DL
	}
	
	public boolean deleteElement(T data) {
		boolean result = false;
		if (head == null) {
			return result;
		}
		if (data.equals(head.getData())) {
			if (head.getNext() != null) {
				head.getNext().setPrev(null);
			}	else {
				tail = head.getPrev();
			}
			head = head.getNext();
			return true;
		}
		
		Node<T> curr = head.getNext();
		while (curr != null) {
			if (data.equals(curr.getData())) {
				if (curr.getNext() != null) {
					curr.getNext().setPrev(curr.getPrev());
				} else {
					tail = curr.getPrev();
				}
				curr.getPrev().setNext(curr.getNext());
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		
		return result;
	}
	
	public void traverse() {
		print(head);
	}
	
	public void revreseTraverse() {
		printFromTail(tail);
	}

	private void printFromTail(Node<T> node) {
		if(node == null) { System.out.println(); return;}
		System.out.print(node.getData()+", ");
		printFromTail(node.getPrev());		
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
		private Node<T> prev; //Specific for DL
		private T data; 
		
		public Node(T data) {
			setData(data);
		}
	
		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
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
