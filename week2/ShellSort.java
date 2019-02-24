import java.util.Arrays;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
        ShellSort.sort(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
