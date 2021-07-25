/*
* CREATE NODE CLASS
*/

public class Node<T extends Comparable<? super T>>{

	// el STORE DATA PASS THROUGH CONSTRUCTOR
	private T el;

	// INSTANCE OF NODE
	public Node<T> prev, next;

	// CONSTRUCTOR
	public Node(T el, Node<T> prev, Node<T> next)
	{
		this.el = el;
		this.prev = prev;
		this.next = next;
	}

	// Get el
	public T getElement()
	{
		return el;
	}
}