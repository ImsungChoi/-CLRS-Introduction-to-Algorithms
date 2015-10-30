package ch7;

/**
 * Created by skplanet on 2015-10-29.
 */
public class QuickSort {

    public static void main (String[] args) {
        int[] input = new int[] {1, 3, 4, 5, 2, 32, 2344, 32, 2, 3, 1, 323, 4, 23, 343, 31, 3, 5 ,8};

        randomizedQuickSort(input, 0, input.length-1);

        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if(start >= end)
            return;

        int pivot = partition(input, start, end);
        quickSort(input, start, pivot - 1);
        quickSort(input, pivot + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[end];
        int d = start-1;

        for(int i = start; i < end; i++) {
            if (input[i] <= pivot) {
                d++;
                swap(input, i, d);
            }
        }
        d++;
        swap(input, d, end);
        return d;
    }

    public static void randomizedQuickSort(int[] input, int start, int end) {
        if(start >= end)
            return;

        int pivot = randomizedPartition(input, start, end);
        randomizedQuickSort(input, start, pivot - 1);
        randomizedQuickSort(input, pivot + 1, end);
    }

    public static int randomizedPartition(int[] input, int start, int end) {
        int pivot = getRandomElement(start, end);
        swap(input, pivot, end);

        return partition(input, start, end);
    }

    public static int getRandomElement(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
