public class DoublyLinkedList {
    private int size;
    private Node first;
    private Node last;

    public DoublyLinkedList(){
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int input){
        if(this.isEmpty()){
            Node node = new Node(input);
            this.first = node;
            this.last = node;
        } else {
            Node node = new Node(input);
            node.next = first;
            first.previous = node;
            this.first = node;
        }
        this.size++;
    }

    public void insertLast(int input){
        if(this.isEmpty()){
            Node node = new Node(input);
            this.first = node;
            this.last = node;
        } else {
            Node node = new Node(input);
            node.previous = last;
            last.next = node;
            this.last = node;
        }
        this.size++;
    }

    public int deleteFirst(){
        if(this.isEmpty()){
            System.out.println("The list is empty!");
            return -1;
        } else if(first.next == null){
            Node temp = first;
            this.first = null;
            this.last = null;
            this.size--;
            return temp.data;
        } else {
            Node temp = first;
            first.next.previous = null;
            this.first = first.next;
            this.size--;
            return temp.data;
        }

        /* The following is a try / catch clause version of this function */

//        try{
//            Node temp = first;
//            first.next.previous = null;
//            this.first = first.next;
//            return temp.data;
//        } catch(NullPointerException sizeEqualsOneError){
//            Node temp = first;
//            this.first = null;
//            this.last = null;
//            try{
//                return temp.data;
//            } catch(NullPointerException emptyListError){
//                System.err.println("The list is empty!");
//                return -1;
//            }
//        }

    }

    public int deleteLast(){
        if(this.isEmpty()){
            System.out.println("The list is empty!");
            return -1;
        } else if(last.previous == null){
            Node temp = last;
            this.last = null;
            this.first = null;
            this.size--;
            return temp.data;
        } else {
            Node temp = last;
            last.previous.next = null;
            this.last = last.next;
            this.size--;
            return temp.data;
        }
    }

    public void printList(){
        if(this.isEmpty()){
            System.out.println("The list is empty!");
        } else {
            Node node = this.first;
            node.displayNode();
            while(node.next != null){
                node = node.next;
                node.displayNode();
            }
            System.out.println();
        }
    }

    public void insertAfter(int key, int input){
        if(key >= this.size){
            System.out.println("Unreachable index!");
        } else {
            if(key == 0){
                insertFirst(input);
            } else if (key == this.size - 1){
                insertLast(input);
            } else {
                Node temp = this.first;
                for(int i = 0; i < key; i++){
                    temp = temp.next;
                }
                Node newNode = new Node(input);
                newNode.next = temp.next;
                newNode.previous = temp;
                temp.next.previous = newNode;
                temp.next = newNode;
            }
        }
        this.size++;
    }

    public int deleteAfter(int key){
        if(key >= this.size){
            System.out.println("Unreachable index!");
            return -1;
        } else {
            if(key == 0){
                deleteFirst();
            } else if (key == this.size - 1){
                deleteLast();
            } else {
                Node temp = this.first;
                for(int i = 0; i < key; i++){
                    temp = temp.next;
                }
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                return temp.data;
            }
        }
        return -1;
    }


}
