package ch6;

import java.lang.reflect.Array;

/**
 * Created by skplanet on 2015-10-21.
 */
public class HeapSort {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7});
        maxHeap.buildMaxHeap();
        for(int i = 0; i < maxHeap.getArray().length; i++)
            System.out.println(maxHeap.getArray()[i]);
    }
}

class Heap {
    protected int heapSize;
    protected int[] array;

    public Heap() {
        this.array = null;
        this.heapSize = 0;
    }

    public Heap(int[] array) {
        this.array = array;
        this.heapSize = array.length;
    }

    public Heap(int[] array, int heapSize) {
        this.array = array;
        this.heapSize = heapSize;
    }

    public int parent(int i) {
        return ((i + 1) / 2) - 1;
    }

    public int left(int i) {
        return ((i + 1) * 2) - 1;
    }

    public int right(int i) {
        return ((i + 1) * 2);
    }

    public void swap (int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Getter and Setter

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}

class MaxHeap extends Heap {

    public MaxHeap() {
        this.array = null;
        this.heapSize = 0;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.heapSize = array.length;
    }

    public MaxHeap(int[] array, int heapSize) {
        this.array = array;
        this.heapSize = heapSize;
    }

    // Build Max Heap
    public void buildMaxHeap() {
        heapSize = array.length;

        for (int i = (array.length / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    // Max Heapify
    public void maxHeapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < heapSize  && array[left] > array[i]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }
}

class MinHeap extends Heap {

    // Build Min Heap

    // Min Heapify
}