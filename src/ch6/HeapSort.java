package ch6;

import java.lang.reflect.Array;

/**
 * Created by skplanet on 2015-10-21.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] input = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        heapSort(input, true);
        for(int i = 0; i < input.length; i++)
            System.out.print(input[i] + " ");

        System.out.println("");

        heapSort(input, false);
        for(int i = 0; i < input.length; i++)
            System.out.print(input[i] + " ");
    }

    public static void heapSort(int[] input, boolean isAscending) {
        Heap heap = null;

        if(isAscending) {
            heap = new MaxHeap(input);
        } else {
            heap = new MinHeap(input);
        }

        heap.buildHeap();

        for(int i = heap.getHeapSize()-1; i > 0; i--) {
            heap.swap(0, i);
            heap.setHeapSize(heap.getHeapSize() - 1);
            heap.heapify(0);
        }

        System.arraycopy(heap.getArray(), 0, input, 0, input.length);
    }


/*    public static void heapSort(int[] input) {
        MaxHeap maxHeap = new MaxHeap(input);
        maxHeap.buildHeap();

        for(int i = maxHeap.getHeapSize()-1; i > 0; i--) {
            maxHeap.swap(0, i);
            maxHeap.setHeapSize(maxHeap.getHeapSize() - 1);
            maxHeap.heapify(0);
        }

        System.arraycopy(maxHeap.getArray(), 0, input, 0, input.length);
    }

    public static void heapSortByAscendingOrder(int[] input) {
        MinHeap minHeap = new MinHeap(input);
        minHeap.buildHeap();

        for(int i = minHeap.getHeapSize()-1; i > 0; i--) {
            minHeap.swap(0, i);
            minHeap.setHeapSize(minHeap.getHeapSize() - 1);
            minHeap.heapify(0);
        }

        System.arraycopy(minHeap.getArray(), 0, input, 0, input.length);
    }*/
}



