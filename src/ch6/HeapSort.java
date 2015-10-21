package ch6;

/**
 * Created by skplanet on 2015-10-21.
 */
public class HeapSort {
    public static void main(String[] args) {
        System.out.println(parent(3));
    }

    public static int parent(int i) {
        return 3/2;
    }

    public static int left(int i) {
        return i*2;
    }

    public static int right(int i) {
        return i*2 + 1;
    }
}
