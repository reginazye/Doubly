
public class DoublyLinkedListNode<T> extends LinkedListNode<T>{
	protected T data;
	protected DoublyLinkedListNode<T> next;
	protected DoublyLinkedListNode<T> prev;

	public DoublyLinkedListNode(T data) {
		super(data);
	}
	
	public void setPrev(DoublyLinkedListNode<T> node){
		this.prev = node;
	}

	public DoublyLinkedListNode<T> getPrev(){
		return  this.prev;
	}
	
}
