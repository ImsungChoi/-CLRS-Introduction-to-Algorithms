package ch8;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by skplanet on 2015-11-04.
 */
public class BucketSort {
    public static void main (String[] args) {
        double[] input = new double[]{0.9, 0.8, 0.7, 0.5, 0.3, 0.2, 0.1};
        bucketSort(input, 10);

        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void bucketSort(double[] input, int d) {
        List[] bucket = new List[d];
        for (int i = 0; i < d; i++) {
            bucket[i] = new LinkedList<Double>();
        }

        for(int i = 0; i < input.length; i++) {
            bucket[(int) (input[i] * d)].add(input[i]);
        }

        int index = 0;
        for(int i = 0; i < d; i++) {
            if (bucket[i].size() == 0) {
                continue;
            }

            Collections.sort(bucket[i]);

            for (int j = 0; j < bucket[i].size(); j++) {
                input[index] = (double) bucket[i].get(j);
                index++;
            }
        }
    }
}
