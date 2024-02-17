package DSA.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    public static void main(String[] args) {

        SelectionSort sort = new SelectionSort();

        int[] arr = {5, 4, 1, 2, 9,};

        sort.selectionSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }
}
