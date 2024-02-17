package DSA.Sorting;

public class BubbleSort {

    public Integer[] sort(Integer[] array) {

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {

                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        Integer[] arr = {5, 4, 3, 2, 1};

        bubbleSort.sort(arr);

        for (Integer num : arr) {
            System.out.println(num);
        }
    }
}
