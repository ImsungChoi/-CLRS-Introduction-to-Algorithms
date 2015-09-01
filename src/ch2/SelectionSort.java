package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();
            List<Integer> input = new ArrayList<Integer>();

            for (int i = 0; i < n; i++)
                input.add(sc.nextInt());

            selectionSort(input);
            System.out.println(input);
        }
        sc.close();
    }

    public static void selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;

            for (int j = min + 1; j < list.size(); j++) {
                if (list.get(min) > list.get(j)) {
                    min = j;
                }
            }

            int temp = list.get(min);
            list.set(min, list.get(i));
            list.set(i, temp);
        }
    }
}
