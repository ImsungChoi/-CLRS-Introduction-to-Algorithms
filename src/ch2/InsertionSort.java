package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        while (c-- > 0) {
            int size = sc.nextInt();
            List<Integer> input = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                input.add(sc.nextInt());
            }

            insertionSortWithBS(input);
            System.out.println(input);
        }

        sc.close();
    }

    public static void insertionSort(List<Integer> intList) {
        for (int i = 1; i < intList.size(); i++) {
            int key = intList.get(i);
            int j = i - 1;

            while (j >= 0 && intList.get(j) > key) {
                intList.set(j + 1, intList.get(j));
                j = j - 1;
            }
            intList.set(j + 1, key);
        }
    }

    public static void insertionSortWithBS(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);

            int insertionIndex = binarySearch(list, 0, i - 1, key);

            for (int j = i - 1; j >= insertionIndex; j--) {
                int temp = list.get(j);
                list.set(j, list.get(j + 1));
                list.set(j + 1, temp);
            }
        }
    }

    public static int binarySearch(List<Integer> list, int start, int end, int target) {
        if (start >= end) {
            if (list.get(start) > target) {
                return start;
            } else {
                return start + 1;
            }
        }

        int median = (start + end) / 2;

        if (list.get(median) > target) {
            return binarySearch(list, start, median - 1, target);
        } else {
            return binarySearch(list, median + 1, end, target);
        }
    }
}
