package DSA.Sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int fIndex, int lIndex) {

        if (lIndex < fIndex) return; // Base Condition

        int nextPivot = division(arr, fIndex, lIndex); // Helper function

        sort(arr, fIndex, nextPivot - 1); // For left
        sort(arr, nextPivot + 1, lIndex); // For right
    }

    private int division(int[] arr, int fIndex, int lIndex) {

        int pivot = arr[lIndex];
        int i = fIndex - 1;

        for(int j = fIndex;j<lIndex;j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[lIndex];
        arr[lIndex] = temp;

        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5, 4, 3, 2, 1};

        quickSort.sort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(System.out::println);


    }
}
