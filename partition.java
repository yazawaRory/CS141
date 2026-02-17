package HW2;

public class partition {
	private partition() {}
	private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	
	public static int partitionLomuto(int[] array, int low, int high) {
		if (array == null) {
		    throw new NullPointerException("Empty array");
		}

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
	
	public static int partitionHoare(int[] array, int low, int high) {
        if (array == null) {
		    throw new NullPointerException("Empty array");
		}

        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do { i++; } while (array[i] < pivot);
            do { j--; } while (array[j] > pivot);

            if (i >= j) return j;

            swap(array, i, j);
        }
    }
}
