package DSA.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] array){

        int n = array.length;

        for(int i = 1;i<n;i++){

            int temp = array[i];
            int j = i - 1;

            while(j>= 0 && array[j] > temp){

                array[j+1] = array[j];
                j--;
            }

            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {5,4,3,2,1};

        insertionSort.insertionSort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }
}
