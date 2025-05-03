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


    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Sort an array a[0 ... n-1]
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; // Ciura gap sequence
        int n = a.length;

        //Start with the largest gap and work down to a gap of 1
        //similar to insertion sort but instead of 1, gap is being used in each step
        for (int gap : gaps) {

            //Do a gapped insertion sort for every elements in gaps
            //Each loop leaves a[0..gap-1] in gapped order
            for (int i = gap; i < n; i++) {

                 //save a[i] in temp and make a hole at position i
                T temp = a[i];

                //Shift earlier gap-sorted elements up until the correct location for a[i] is found
                int j;
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j-=gap) {
                    a[j] = a[j - gap];
                }

                //Put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





