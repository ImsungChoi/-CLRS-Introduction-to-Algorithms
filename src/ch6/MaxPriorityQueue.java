package ch6;

/**
 * Created by skplanet on 2015-10-26.
 */
public class MaxPriorityQueue extends MaxHeap {

    public MaxPriorityQueue() {
        super();
    }

    public MaxPriorityQueue(int[] input) {
        super(input);
    }

    public MaxPriorityQueue(int[] input, int heapSize) {
        super(input, heapSize);
    }


    public void insert(int key) {
        heapSize++;
        array[heapSize-1] = Integer.MIN_VALUE;
        increaseKey(heapSize-1, key);
    }

    public int maximum() {
        return array[0];
    }

    public int extractMax() {
        if(heapSize < 1) {
            return -1;
        }

        int max = array[0];
        array[0] = array[heapSize - 1];
        heapSize--;
        heapify(heapSize-1);
        return max;
    }

    public void increaseKey(int i, int key) {
        if (key < array[i]) {
            return;
        }

        array[i] = key;
        while(i > 0 && array[parent(i)] < array[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
}
