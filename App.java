public class App {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertFirst(1);
        myList.insertLast(6);
        myList.insertFirst(3);
        myList.insertLast(7);
        myList.insertFirst(2);

        myList.printList();

        myList.insertAfter(3, 4);

        myList.printList();

        System.out.println("Return 2nd element: " + myList.deleteAfter(2));

        myList.printList();
    }
}
