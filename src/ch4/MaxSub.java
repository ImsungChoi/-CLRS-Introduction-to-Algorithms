package ch4;

import java.util.Scanner;

/**
 * Created by skplanet on 2015-09-23.
 */
public class MaxSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while(c-- > 0) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for(int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            maximumSubArrayN2(input);
            System.out.println("Max Sum : " + maximumSubArrayNlogN(input, 0, input.length - 1));
            System.out.println("Max Sum : " + maxSubN(input));
        }
    }

    public static void maximumSubArrayN2 (int[] input) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for(int i = 0; i < input.length; i++) {
            int sum = 0;
            for(int j = i; j < input.length; j++) {
                sum += input[j];
                if(sum > max) {
                    max = sum;
                    left = i;
                    right = j;
                }
            }
        }
        System.out.println("Left Index : " + left);
        System.out.println("Right Index : " + right);
        System.out.println("Max Sum : " + max);
    }

    public static int maximumSubArrayNlogN (int[] input, int left, int right) {
        if (left == right) {
            return input[right];
        }

        int max = Integer.MIN_VALUE;
        int median = (left + right) / 2;
        max = Integer.max(max, maximumSubArrayNlogN(input, left, median));
        max = Integer.max(max, maximumSubArrayNlogN(input, median + 1, right));
        max = Integer.max(max, maxSubCrossing(input, left, right));
        return max;
    }

    public static int maxSubCrossing(int[] input, int left, int right) {
        int median = (left + right) / 2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = median; i > left - 1; i--) {
            sum += input[i];
            if(sum > leftMax) {
                leftMax = sum;
            }
        }
        sum = 0;
        for (int i = median + 1; i < right + 1; i++) {
            sum += input[i];
            if(sum > rightMax) {
                rightMax = sum;
            }
        }

        return leftMax + rightMax;
    }

    public static int maxSubN(int[] input) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
