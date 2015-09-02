package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by skplanet on 2015-09-02.
 */
public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            InsertionSort.insertionSort(list);
            System.out.println(list);
            System.out.println(binarySearch(list, 0, list.size() - 1, k));
        }
    }

    public static int binarySearch(List<Integer> list, int start, int end, int k) {
        if (start > end)
            return -1;

        int median = (start + end) / 2;

        if (list.get(median) == k)
            return median;
        else if (list.get(median) > k)
            return binarySearch(list, start, median - 1, k);
        else
            return binarySearch(list, median + 1, end, k);
    }
}
