package ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by skplanet on 2015-08-31.
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        while (c-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();

            while (n-- > 0) {
                list.add(sc.nextInt());
            }

            System.out.println(mergeSort(list));
        }
        sc.close();
    }

    public static List<Integer> mergeSort(List<Integer> list) {

        int size = list.size();

        if (size <= 1) {
            return list;
        }

        int dividedByTwo = size / 2;
        List<Integer> first = mergeSort(list.subList(0, dividedByTwo));
        List<Integer> second = mergeSort(list.subList(dividedByTwo + 1, size));
        return merge(first, second);
    }

    public static List<Integer> merge(List<Integer> first, List<Integer> second) {

        int size = first.size() + second.size();
        List<Integer> output = new ArrayList<Integer>();
        int firstIndex = 0;
        int secondIndex = 0;
        first.add(Integer.MAX_VALUE);
        second.add(Integer.MAX_VALUE);

        for (int i = 0; i < size; i++) {
            if (first.get(firstIndex) > second.get(secondIndex)) {
                output.add(second.get(secondIndex));
                secondIndex++;
            } else {
                output.add(first.get(firstIndex));
                firstIndex++;
            }
        }

        return output;
    }
}
