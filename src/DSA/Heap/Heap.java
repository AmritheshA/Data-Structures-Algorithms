package DSA.Heap;


public class Heap {

    private final Integer[] heap;
    private Integer size;
    private final Integer capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Integer[capacity];
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int fPos, int sPos) {
        int temp = heap[fPos];
        heap[fPos] = heap[sPos];
        heap[sPos] = temp;
    }

    public void arrayToHeap(int[] array) {

        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    private void heapify(int[] array, int... integers) {

        int root = integers[1];
        int leftChild = 2 * integers[1] + 1;
        int rightChild = 2 * integers[1] + 2;

        if (leftChild < integers[0] && array[leftChild] < array[root]) {
            root = leftChild;
        }
        if (rightChild < integers[0] && array[rightChild] < array[root]) {
            root = rightChild;
        }

        if (root != integers[1]) {
            int temp = array[integers[1]];
            array[integers[1]] = array[root];
            array[root] = temp;
            heapify(array, integers[0], root);
        }
    }

    public void insertElement(int value) {

        if (size.equals(capacity)) {
            System.out.println("heap is reached the capacity");
            return;
        }
        size++;
        int index = size - 1;
        heap[index] = value;

        while (index != 0 && heap[parent(index)] > heap[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void removeTopElement() {

        if (size == 0) throw new IndexOutOfBoundsException("Heap is empty");

        heap[0] = heap[size - 1];
        size--;
        minHeapDown(0);
    }

    private void minHeapDown(int index) {
        int root = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && heap[leftChild] < heap[root]) {
            root = leftChild;
        }

        if (rightChild < size && heap[rightChild] < heap[root]) {
            root = rightChild;
        }

        if (root != index) {
            swap(index, root);
            minHeapDown(root);
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        Heap heap = new Heap(10);

        heap.arrayToHeap(array);

        heap.insertElement(10);
        heap.insertElement(200);
        heap.insertElement(500);

        heap.insertElement(800);
        heap.insertElement(100);

        heap.insertElement(600);
        heap.insertElement(75);


        System.out.println("Before removing:--");
        heap.display();

        heap.removeTopElement();

        System.out.println("After removing:--");
        heap.display();
    }   
}