

public class DoublyLinkedList<T> extends LinkedList<T>{
	//public DoublyLinkedListNode<T> head;
	public DoublyLinkedListNode<T> tail;
	
	public DoublyLinkedList(){
		super();
	}

	public DoublyLinkedListNode<T> getFirstNode(){
		return (DoublyLinkedListNode<T>) this.head;
	}
	
	public DoublyLinkedListNode<T> getLastNode(){
		return (DoublyLinkedListNode<T>) this.tail;
	}
	
	public boolean isEmpty() {
		if (this.head == null && this.tail==null) {
			return true;
		}
		return false;
	}
	
	public void insertFirst(T data){
		DoublyLinkedListNode<T> temp = new DoublyLinkedListNode<T>(data); 
		if (isEmpty()){
			head = temp;
			tail = temp;
		}
		if(!isEmpty()){
		temp.setNext(  (DoublyLinkedListNode<T>) getFirstNode());
		//head.prev = temp;
		((DoublyLinkedListNode<T>) head).setPrev(temp);
		head = temp;
		}
	}

	
	public void insertLast(T data) {
		LinkedListNode<T> last = getLastNode();
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (last!=null) {
		last.setNext(added);
		added.setPrev((DoublyLinkedListNode<T>) last);
		tail = added;
		}
		if (last == null){
			tail = added;
			head = added;
		}
	}
	
	public void insertPrev(DoublyLinkedListNode<T> currentNode, T data){
		DoublyLinkedListNode<T> added = new DoublyLinkedListNode<T>(data);
		if (currentNode==head){
			currentNode.prev = added;
			head = added;
			added.setNext(currentNode);
		}
		else if (currentNode.getNext()!=null){	
			currentNode.prev.next = added;
			added.setPrev(currentNode); 	
			added.setNext(currentNode);
			currentNode.setPrev(added);
		}	
	}
	
	public void deletePrev(DoublyLinkedListNode<T> node){
//		DoublyLinkedListNode<T> temp = node.getPrev();
//		//if not deleting head
//		if (temp.getPrev()!=null){
//			temp = node;
//			node.setPrev(temp.getPrev());
//		}//if deleting head
//		else if (temp.getPrev()==null){
//			head = node;
//		}
		if (node == head) {
			return;
		}if(node.getPrev()!=null){
			if (node.getPrev()==head){
			node.setPrev(null);
			head = node;
			}else {
				node.setPrev(node.getPrev().getPrev());
				node.getPrev().setNext(node);
				
			}
		}
	}
	
	public void deleteNext(DoublyLinkedListNode<T> currentNode) {
		DoublyLinkedListNode<T> temp = currentNode.next.next;
		currentNode.next = temp;
		temp.prev = (DoublyLinkedListNode<T>) currentNode;
		if (isEmpty()){
			return;
		}
		if (!isEmpty()) {
			if (currentNode.getNext()==tail) {
				currentNode.next=null;
				tail = currentNode;
			}
		}else {
			currentNode.setNext(currentNode.getNext().getNext());
			((DoublyLinkedListNode<T>) currentNode.getNext()).setPrev(currentNode);
		}
	}
	
	public void deleteLast(){
		if (isEmpty()){
			return;
		}
		if (getSize()==1){
			head = null;
			tail = null;
		}else {
			tail=((DoublyLinkedListNode<T>) getLastNode()).getPrev();
			DoublyLinkedListNode<T> node = (DoublyLinkedListNode<T>) getLastNode();
			node = null;
			
		}
	}
	
//	public String toStringPrev(){
//		DoublyLinkedListNode<T> currentNode = tail;
//		String s = "";
//		// add each node and the pointers
//		while (currentNode!= null) {
//			s += (currentNode.getData().toString());
//			currentNode = currentNode.getPrev();
//		}
//		return s;
//	}
	

}

