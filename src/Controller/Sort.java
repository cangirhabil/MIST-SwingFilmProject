package Controller;


public class Sort<T extends Comparable<T>> {
	
    public void sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(T[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        T[] leftArray = (T[]) new Comparable[n1];
        T[] rightArray = (T[]) new Comparable[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) >= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
/*
    public static void main(String[] args) {
        Sort<Integer> mergeSort = new Sort<>();
        Integer[] arr = {5, 3, 9, 1, 7, 2, 8, 4, 6};
        mergeSort.sort(arr);
        System.out.println("Sıralanmış Dizi:");
        for (int num : arr) {
            System.out.println(num);
        }
    }
*/
}
