package DSA.Queue;

class QueueNode<Type> {

    Type value;
    QueueNode<Type> next;

    public QueueNode(Type value) {
        this.value = value;
    }
}

public class Queue<Type> {

    QueueNode<Type> top;
    QueueNode<Type> tail;

    public void enqueue(Type value) {
        QueueNode<Type> newNode = new QueueNode<>(value);

        if (top == null) {
            top = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void dequeue(){

        if(top == null){
            System.out.println("Queue is empty");
            return;
        }
        top = top.next;

        if(top == null){
            System.out.println("Queue is empty now");
            tail = null;
        }
    }

    public void display(){

        QueueNode current = top;

        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();


        queue.display();

    }

}
