package ch6;

/**
 * Created by skplanet on 2015-10-26.
 */

public class MinHeap extends Heap {

    public MinHeap() {
        super();
    }

    public MinHeap(int[] array) {
        super(array);
    }

    public MinHeap(int[] array, int heapSize) {
        super(array, heapSize);
    }

    // Max Heapify
    @Override
    public void heapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < heapSize  && array[left] < array[i]) {
            largest = left;
        }

        if (right < heapSize && array[right] < array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
}