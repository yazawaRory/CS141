package HW2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class partitionTest {

	private static final int[] PRESORTED = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
    private static final int[] EMPTY = {};
    private static final int[] UNSORTED = {84, 3, 7, 1, 9, 6, 2, 5};

    @Test
    void lomuto_onSortedArray_partitionsCorrectly() {
        int[] a = PRESORTED.clone();
        int low = 0, high = a.length - 1;

        int p = partition.partitionLomuto(a, low, high);

        int pivot = a[p];
        // making left <= pivot
        for (int i = low; i < p; i++) assertTrue(a[i] <= pivot);
        // pivot at p 
        assertEquals(pivot, a[p]);
        // right > pivot
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] > pivot);

        // lomuto uses last element as pivot
        assertEquals(high, p);
        assertArrayEquals(PRESORTED, a); // should remain same
    }

    @Test
    void lomuto_onUnsortedArray_partitionsCorrectly() {
        int[] a = UNSORTED.clone();
        int low = 0, high = a.length - 1;

        int p = partition.partitionLomuto(a, low, high);

        int pivot = a[p];
        for (int i = low; i < p; i++) assertTrue(a[i] <= pivot);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] > pivot);
    }

    @Test
    void lomuto_onEmptyArray_throws() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> partition.partitionLomuto(EMPTY, 0, 0));
    }


    @Test
    void hoare_onSortedArray_partitionsCorrectly() {
        int[] a = PRESORTED.clone();
        int low = 0, high = a.length - 1;

        int p = partition.partitionHoare(a, low, high);

        int pivot = PRESORTED[low]; // Pivot chosen from original a[low]
        // left side <= pivot
        for (int i = low; i <= p; i++) assertTrue(a[i] <= pivot);
        // right side >= pivot
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] >= pivot);

        // For a strictly increasing sorted array, pivot is the smallest (10),
        // so partition index should be low (0).
        assertEquals(low, p);
        assertArrayEquals(PRESORTED, a); // should remain unchanged
    }

    @Test
    void hoare_onUnsortedArray_partitionsCorrectly() {
        int[] a = UNSORTED.clone();
        int low = 0, high = a.length - 1;

        int pivot = a[low];
        int p = partition.partitionHoare(a, low, high);

        for (int i = low; i <= p; i++) assertTrue(a[i] <= pivot);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] >= pivot);
    }

    @Test
    void hoare_onEmptyArray_throws() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> partition.partitionHoare(EMPTY, 0, 0));
    }

}
