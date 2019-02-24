import java.util.Arrays;

public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
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
        Insertion.sort(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
