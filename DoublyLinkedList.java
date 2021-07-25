/*
* DOUBLY LINKED LIST CLASS
*/

public class DoublyLinkedList<T extends Comparable<? super T>>{
	// INSTANCE OF NODE CLASS
	private Node<T> root;

	// CONSTRUCTOR
	public DoublyLinkedList()
	{
		// SET ROOT TO NULL
		root = null;
	}

	// return the size of linked
	public int size()
	{
		int count = 0;
		for(Node<T> curr = root ; curr != null; count++,curr=curr.next);
		return count;
	}

	// add data at the beginning of linked using data that is pass as argument
	public void prepend(T data)
	{
		// CHECK IF ROOT IS NULL
		if ( root == null)
		{
			root = new Node<T>(data,null,null);
		}
		else
		{
			Node<T> newNode = new Node<T>(data,null,root);
			root.prev = newNode;
			root = newNode;
		}
	}

	// add data according to argument index
	public void indexInsertion(T data, int index)
	{
		// CHECK IF INDEX QUELS ZERO
		if ( index == 0 )
		{
			this.prepend(data);
		}
		// CHECK IF INDEX EQUALS SIZE
		else if ( index == size() )
		{
			this.append(data);
		}
		else if(index > 0 && index <size())
		{
			int count = 0;
			Node<T> curr = root;
			for(;count != index; count++, curr=curr.next);
			Node<T> newNode = new Node<T>(data,curr.prev,null);
			curr.prev = newNode;
			newNode.next = curr;
		}
	}

	// add data at the end
	public void append(T data)
	{
		// CHECK IF ROOT IS NULL
		if ( root == null )
		{
			root = new Node<T>(data,null,null);
		}
		else
		{
			Node<T> curr = root;
			for(;curr.next != null; curr = curr.next);
			curr.next = new Node<T>(data,curr,null);
		}
	}

	// override toString
	@Override
	public String toString()
	{
		String str = "";
		for(Node<T> curr = root ; curr != null; str += curr.getElement() + ",",curr = curr.next);
		str = str.substring(0, str.length() - 1);
		return str;
	}

	// 	DELETING A NODE FROM THE END OF A DOUBLY LINKED LIST
	public T deleteEndNode()
	{
		Node<T> curr = root;
		for(;curr.next != null; curr = curr.next);
		if ( curr != null )
		{
			if ( curr == root )
			{
				return this.deleteBeginNode();
			}

			T el = curr.getElement();
			curr.prev.next = null;
			curr = null;
			return el;
		}
		return null;
	}

	// 	DELETING A NODE FROM THE BEGINNING OF A DOUBLY LINKED LIST
	public T deleteBeginNode()
	{
		if ( root != null )
		{
			T el = root.getElement();
			
			if ( root.next != null )
			{
				root = root.next;
				root.prev = null;
			}
			else
			{
				root = null;
			}
			return el;
		}
		return null;
	}

	// DELETING A NODE ACCORDING TO ARGUMENT INDEX
	public T deleteIndexNode(int index)
	{
		// CHECK IF INDEX QUELS ZERO
		if ( index == 0 )
		{
			return this.deleteBeginNode();
		}
		// CHECK IF INDEX EQUALS SIZE
		else if ( index  == size() )
		{
			return this.deleteEndNode();
		}
		else if( index > 0 && index <size() )
		{
			int count = 0;
			Node<T> curr = root;
			for(;count != index; count++, curr=curr.next);
			T el = curr.getElement();
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
			curr = null;
			return el;
		}
		return null;
	}

	// Return true when root is null otherwise false
	public Boolean isEmpty()
	{
		return ( root == null );
	}
}