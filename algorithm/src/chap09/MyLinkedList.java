package chap09;

public class MyLinkedList {
	
	private Node head;
	private int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	/*
	 * 특정 인덱스에 새로운 노드를 추가한다.
	 * @param index
	 * @param newNode
	 * 
	 */
	public void add(int index, Node newNode) {
		//첫번째 노드인 경우
		Node nextNode = null;
		if(index == 0) {
			if(this.head == null) {
				this.head = new Node();
				this.head.setNext(newNode);
			}else {
				nextNode = this.head.getNext();
				newNode.setNext(nextNode);
				this.head.setNext(newNode);
			}
		}else {
			//첫번째 노드가 아닌 경우
			if(index<0 || index > this.size-1) throw new IndexOutOfBoundsException();
			Node p = this.head;
			
			for(int i =0; i<index-1; i++) {
				p = p.getNext();
				
				if(index<this.size) {
					nextNode = p.getNext();
				}
			}
			if(nextNode != null) {
				if(nextNode != null) {
					newNode.setNext(nextNode);
					p.setNext(newNode);
				}
			}
		}
		
		this.size++;
		
	}
	
	/*
	 * 마지막 노드를 리턴한다
	 * @return
	 */
	
	public Node get() {
		if(this.head  == null)throw new IndexOutOfBoundsException();
		Node p = head;
		
		for(int i =0; i<this.size; i++) {
			p = p.getNext();
		}
		
		return p;
	}
	
	public void printList() {
		System.out.println("<<LinkedList Data출력>>");
		if(this.head != null) {
			Node p = this.head;
			for(int i =0; i<size; i++) {
				p = p.getNext();
				if(p != null)System.out.print(p.getData()+", ");
			}
		}
	}
	
	/*
	 * @return the size
	 */
	
	public int getSize() {
		return size;
	}
	
	/*
	 * @param size the size to set
	 */
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
