package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;

        while (pos < a.length) {
            if (pos == 0 || (a[pos].compareTo(a[pos - 1]) >= 0)) {
                pos = pos + 1;
            } else {
                swap(a, pos, pos - 1);
                pos-=1;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] A) {
        boolean swapped;
        do {
            swapped = false;
            // Forward pass (left to right)
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }

            swapped = false;
            // Backward pass (right to left)
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped); // Continue until no swaps are made
    }





    public static <T extends Comparable<T>> void shellSort(T[] data) {

        // TODO implement Shell Sort here
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





