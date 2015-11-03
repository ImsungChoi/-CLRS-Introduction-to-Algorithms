package ch8;

/**
 * Created by skplanet on 2015-11-03.
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] input = new int[] {3, 2, 6, 8, 4, 2, 1, 4, 5, 6, 7, 9};
        int[] ret = new int[input.length];
        countingSort(input, ret, 9);

        for(int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
        }
    }

    public static void countingSort(int[] input, int[] ret, int k) {
        int[] countingArray = new int[k+1];

        for (int i = 0; i <= k; i++) {
            countingArray[i] = 0;
        }

        for (int i = 0; i < input.length; i++) {
            countingArray[input[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            countingArray[i] += countingArray[i-1];
        }

        for (int i = input.length-1; i >= 0; i--) {
            ret[countingArray[input[i]]-1] = input[i];
            countingArray[input[i]]--;
        }
    }
}
