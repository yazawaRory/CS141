package HW1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeArraysTest {

	@Test
    void testMergeNormal() {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};

        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, MergeArrays.merge(a, b));
    }

    @Test
    void testMergeWithEmptyArray() {
        int[] a = {3, 4};
        int[] b = {1, 2};

        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, MergeArrays.merge(a, b));
    }

}
