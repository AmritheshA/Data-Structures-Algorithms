package DSA.LinkedList;

class LinkedNode<Type> {
    public Type value;
    public LinkedNode<Type> next;

    public LinkedNode(Type value) {
        this.value = value;
    }
}


public class LinkedList<Type> {

    LinkedNode<Type> head;
    LinkedNode<Type> tail;


    public void insertValue(Type value) {
        LinkedNode<Type> newNode = new LinkedNode<>(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void removeElement(Type value) {

        LinkedNode<Type> current = head;

        if (head.value.equals(value)) {
            head = head.next;
            return;
        }

        while (!current.next.value.equals(value)) {
            current = current.next;
        }

        current.next = current.next.next;

    }

    public void removeFirstElement() {

        if (head == null) {
            System.out.println("Linked List Is Empty");
            return;
        }
        head = head.next;
    }

    public void removeLastElement() {

        LinkedNode<Type> current = head;

        while (current.next.next != null) {

            current = current.next;
        }

        current.next = null;
        tail = current;
    }

    public Integer size() {

        Integer length = 0;
        LinkedNode<Type> current = head;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void updateElement( int position,Type value) {

        if (position <= 0 || position > size()) {
            System.out.println("Invalid position");
            return;
        }

        LinkedNode<Type> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public LinkedNode reverseLinkedList(){
        LinkedNode<Type> current = head;
        LinkedNode<Type> prev = null;

        while(current != null){
            LinkedNode<Type> tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }

        return prev;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isContain(Type value) {

        LinkedNode<Type> current = head;

        while (current != null) {

            if (current.value.equals(value)) {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    public void display() {

        LinkedNode<Type> current = head;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }


    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.insertValue(40);
        linkedList.insertValue(50);
        linkedList.insertValue(60);

        linkedList.removeFirstElement();
        linkedList.removeLastElement();
        linkedList.removeElement(50);

        linkedList.insertValue(10);
        linkedList.insertValue(20);
        linkedList.insertValue(30);

        linkedList.updateElement(3, 40);

        boolean isContains = linkedList.isContain(60);
        boolean isEmpty = linkedList.isEmpty();

        linkedList.display();

        System.out.println(isContains);
        System.out.println(isEmpty);

        linkedList.reverseLinkedList();

        linkedList.display();


    }
}
