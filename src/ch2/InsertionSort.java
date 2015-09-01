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

            insertionSort(input);
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
}
