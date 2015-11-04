package ch8;

/**
 * Created by skplanet on 2015-11-03.
 */
public class RadixSort {
    public static void main (String[] args) {
        int[] input = new int[] {32030, 20039, 34040, 12499, 98848, 99388, 45409, 85543, 33333, 33334, 33433, 34333};
        radixSort(input, 5);

        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void radixSort(int[] input, int d) {
        int[] ret = new int[input.length];

        for (int i = 0; i < d; i++) {
            extendedCountingSort(input, ret, 9, i);
            System.arraycopy(ret, 0, input, 0, ret.length);
        }
    }

    public static void extendedCountingSort(int[] input, int[] ret, int k, int index) {
        int[] countingArray = new int[k+1];

        for (int i = 0; i <= k; i++) {
            countingArray[i] = 0;
        }

        for (int i = 0; i < input.length; i++) {
            countingArray[getIntByIndex(input[i], index)]++;
        }

        for (int i = 1; i <= k; i++) {
            countingArray[i] += countingArray[i-1];
        }

        for (int i = input.length-1; i >= 0; i--) {
            ret[countingArray[getIntByIndex(input[i], index)]-1] = input[i];
            countingArray[getIntByIndex(input[i], index)]--;
        }
    }

    public static int getIntByIndex(int value, int index) {
        if(index == 0)
            return value % 10;

        value = value % ((int) Math.pow(10, index + 1));
        return value / (int)Math.pow(10, index);
    }
}
