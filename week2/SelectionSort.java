import java.util.Arrays;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) == -1) {
            return true;
        }

        return false;
    }

    public static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 5, 2, 3, 10, 6, 22, 11 };

        System.out.println(Arrays.deepToString(arr));
        SelectionSort.sort(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
