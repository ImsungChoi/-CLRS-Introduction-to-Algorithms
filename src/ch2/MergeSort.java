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

            mergeSort(list, 0, list.size() - 1);
            System.out.println(list);
        }
        sc.close();
    }

    public static void mergeSort(List<Integer> list, int start, int end) {
        if (start < end) {
            int dividedByTwo = (start + end) / 2;
            mergeSort(list, start, dividedByTwo);
            mergeSort(list, dividedByTwo + 1, end);
            mergeWithoutMaxValue(list, start, dividedByTwo, end);
        }
    }

    public static void merge(List<Integer> list, int start, int divided, int end) {
        List<Integer> first = new ArrayList<Integer>(divided - start + 1 + 1);
        List<Integer> second = new ArrayList<Integer>(end - divided + 1);

        list.subList(start, divided + 1).stream().forEach(i -> first.add(i));
        list.subList(divided + 1, end + 1).stream().forEach(i -> second.add(i));

        first.add(Integer.MAX_VALUE);
        second.add(Integer.MAX_VALUE);

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = start; i <= end; i++) {
            if (first.get(firstIndex) > second.get(secondIndex)) {
                list.set(i, second.get(secondIndex));
                secondIndex++;
            } else {
                list.set(i, first.get(firstIndex));
                firstIndex++;
            }
        }
    }

    /*
     * Integer.MAX_Value 없이 merge (경계값 체크)
     */
    public static void mergeWithoutMaxValue(List<Integer> list, int start, int divided, int end) {
        List<Integer> first = new ArrayList<Integer>(divided - start + 1);
        List<Integer> second = new ArrayList<Integer>(end - divided);

        list.subList(start, divided + 1).stream().forEach(i -> first.add(i));
        list.subList(divided + 1, end + 1).stream().forEach(i -> second.add(i));

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = start; i <= end; i++) {
            if (firstIndex == first.size()) {
                list.set(i, second.get(secondIndex));
                secondIndex++;
            } else if (secondIndex == second.size()) {
                list.set(i, first.get(firstIndex));
                firstIndex++;
            } else if (first.get(firstIndex) > second.get(secondIndex)) {
                list.set(i, second.get(secondIndex));
                secondIndex++;
            } else {
                list.set(i, first.get(firstIndex));
                firstIndex++;
            }
        }
    }
}
