package ch6;

/**
 * Created by skplanet on 2015-10-26.
 */
public abstract class Heap {

        protected int heapSize;
        protected int[] array;

        public Heap() {
            this.array = new int[100];
            this.heapSize = 0;
        }

        public Heap(int[] input) {
            this.array = new int[100];
            System.arraycopy(input, 0, this.array, 0, input.length);
            this.heapSize = input.length;
        }

        public Heap(int[] input, int heapSize) {
            this.array = new int[100];
            System.arraycopy(input, 0, this.array, 0, input.length);
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

        public void buildHeap() {
            for (int i = (heapSize / 2) - 1; i >= 0; i--) {
                heapify(i);
            }
        }
        protected abstract void heapify(int i);
}
