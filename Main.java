public class Main {
	public static void main(String[] args) {
		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
		doublyLinkedList.append(6);
		doublyLinkedList.prepend(5);
		doublyLinkedList.indexInsertion(8,2);
		doublyLinkedList.append(10);
		System.out.println("List: "+doublyLinkedList);
		System.out.println("DELETE END NODE: "+doublyLinkedList.deleteEndNode());
		System.out.println("List: "+doublyLinkedList);
		System.out.println("DELETE INDEX NODE: "+doublyLinkedList.deleteIndexNode(1));
		System.out.println("List: "+doublyLinkedList);
		System.out.println("DELETE BEGIN NODE: "+doublyLinkedList.deleteBeginNode());
		System.out.println("List: "+doublyLinkedList);

	}
} 
