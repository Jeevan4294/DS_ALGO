package my.preparation.skiena;

public class Chapter3 {

	public static void main(String[] args) {
		/*LinkedList linkedList = new LinkedList();
		linkedList.insert("Test1");
		linkedList.insert("Test2");
		linkedList.insert("Test3");
		linkedList.insert("Test4");
		linkedList.insert("Test5");
		linkedList.insert("Test6");
		System.out.println(linkedList.delete("Test4"));
		System.out.println(linkedList.delete("Test2"));
		linkedList.traverse();*/
		
		Stack stack = new Stack();
		stack.push("Test1");
		stack.push("Test2");
		stack.push("Test3");
		stack.push("Test4");
		stack.push("Test5");
		stack.pop();
		stack.pop();
		System.out.println(stack.peak);
		stack.traverse();
		
		/*Queue queue = new Queue();
		System.out.println(queue.front);
		System.out.println(queue.rear);
		queue.enqueue("Test1");
		queue.enqueue("Test2");
		queue.enqueue("Test3");
		queue.enqueue("Test4");
		queue.enqueue("Test5");
		System.out.println(queue.dequeue());
		System.out.println(queue.front);
		System.out.println(queue.rear);
		queue.traverse();*/
	}

}

class LinkedList {
	Node head = null;
	public void insert(Object item) {
		if(this.head == null) {
			head = new Node(item);
		}else {
			Node tmpNode = this.head;
			head=new Node(item);
			head.next=tmpNode;
		}
	}
	
	public boolean delete(Object item) {
		if(this.head == null) return false;
		if(this.head.item.equals(item)) {
			this.head = this.head.next;
		}else {
			Node previousNode = this.head;
			Node currentNode = this.head.next;
			while(currentNode!=null) {
				if(currentNode.item.equals(item)) {
					previousNode.next = currentNode.next;
					return true;
				}else {
					previousNode = currentNode;
					currentNode = currentNode.next;
				}
			}
		}
		return false;
	}
	
	public void traverse() {
		if(this.head == null) return;
		Node tmpNode = this.head;
		while(tmpNode != null){
			System.out.println(tmpNode.item);
			tmpNode = tmpNode.next;
		}
	}

	class Node {
		public Node(Object item) {
			this.item = item;
		}
		Object item;
		Node next;
	}
}

class Stack extends LinkedList{
	Object peak = null;
	
	public void push(Object item) {
		peak = item;
		super.insert(item);
	}
	public Object pop() {
		Object item = null;
		if(super.head != null) {
			item = super.head.item;
			super.delete(item);
		}
		if(super.head != null)
			this.peak = super.head.item;
		return item;
	}
	public void traverse() {
		super.traverse();
	}
}

class Queue extends LinkedList{
	Object front = null;
	Object rear = null;
	public void enqueue(Object item) {
		this.rear = item;
		if(this.head == null) {
			head = new Node(item);
		}else {
			Node tmpNode = this.head;
			while(tmpNode.next != null) {
				tmpNode = tmpNode.next;
			}
			tmpNode.next = new Node(item);
			this.front = super.head.item;
		}
	}
	
	public Object dequeue() {
		Object item = null;
		if(super.head != null) {
			item = super.head.item;
			super.delete(item);
		}
		if(super.head != null)
			this.front = super.head.item;
		return item;
	}
	
	public void traverse() {
		super.traverse();
	}
}
